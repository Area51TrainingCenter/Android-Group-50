package com.area51.clase10;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    private Button btnUbicacion, btnCamara;
    private GPSTracker gpsTracker;
    private ImageView ivImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUbicacion = findViewById(R.id.btnUbicacion);
        btnCamara = findViewById(R.id.btnCamara);
        ivImagen = findViewById(R.id.ivImagen);

        btnUbicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermission();
            }
        });

        btnCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestPermissionCamera();
            }
        });
    }

    public static final int RC_LOCATION = 123;
    public static final int RC_CAMERA = 456;
    public static final int CAMERA = 789;

    @AfterPermissionGranted(RC_CAMERA)
    private void requestPermissionCamera() {
        String[] perms = {Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, CAMERA);
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.camera),
                    RC_CAMERA, perms);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA) {
            if (data.getExtras() != null) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                ivImagen.setImageBitmap(bitmap);
            }
        }
    }

    public String guardar(Bitmap myBitmap) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);

        File wallpaperDirectory = new File(
                (Environment.getExternalStorageDirectory()).toString() + "clase");
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        try {
            File f = new File(
                    wallpaperDirectory,
                    ((Calendar.getInstance().getTimeInMillis()) + ".jpg"));
            f.createNewFile();
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(bytes.toByteArray());
            MediaScannerConnection.scanFile(this,
                    new String[]{f.getPath()},
                    new String[]{"image/jpeg"}, null);
            fo.close();

            MetodoServicio metodoServicio = null;

            RequestBody requestBody =
                    RequestBody.create(MediaType.parse("image/*"), f);
            MultipartBody.Part part =
                    MultipartBody.Part.createFormData("file",
                            f.getName(), requestBody);

            RequestBody requestBody1 =
                    RequestBody.create(MediaType.parse("text/plain"), "");
            Call<String> response = metodoServicio.guardarImagen(part, requestBody1);
            response.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Toast.makeText(MainActivity.this,
                            "Se grabo", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });

            return f.getAbsolutePath();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return "";
    }

    @AfterPermissionGranted(RC_LOCATION)
    private void requestPermission() {
        String[] perms = {Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Already have permission, do the thing
            // ...

            gpsTracker = new GPSTracker(this);
            if (gpsTracker.canGetLocation()) {
                Double latitud = gpsTracker.getLatitude();
                Double longitud = gpsTracker.getLongitude();

                Toast.makeText(MainActivity.this,
                        "Latitud:" + latitud + " Longitud:" + longitud,
                        Toast.LENGTH_SHORT).show();
            }
        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.location),
                    RC_LOCATION, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {

    }
}
