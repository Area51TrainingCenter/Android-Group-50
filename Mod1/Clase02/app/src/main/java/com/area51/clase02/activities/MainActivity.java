package com.area51.clase02.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.area51.clase02.R;
import com.area51.clase02.modelos.Producto;

public class MainActivity extends AppCompatActivity {
    private Spinner categoria;
    private EditText nombre, descripcion;
    private RadioButton publico, privado;
    private CheckBox acepto;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Habilitas el boton de home
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Registro producto");

        categoria = findViewById(R.id.spCategoria);
        nombre = findViewById(R.id.etNombre);
        descripcion = findViewById(R.id.etDescripcion);
        publico = findViewById(R.id.rbPublico);
        privado = findViewById(R.id.rbPrivado);
        acepto = findViewById(R.id.cbAcepto);
        registrar = findViewById(R.id.btnRegistrar);

        String[] categorias = getResources().getStringArray(R.array.categorias);
        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_dropdown_item, categorias
        );
        categoria.setAdapter(adapter);

        int posicion = getIntent().getIntExtra("posicion", -1);
        if (posicion != -1) {
            Producto obj = ListadoActivity.listaProductos.get(posicion);
            nombre.setText(obj.getNombre());
            descripcion.setText(obj.getDescripcion());
            publico.setChecked(obj.isPublico());
            privado.setChecked(!obj.isPublico());
            acepto.setChecked(obj.isAccept());

            for (int i = 0; i < categorias.length; i++) {
                if (obj.getCategoria().equals(categorias[i])) {
                    categoria.setSelection(i);
                    break;
                }
            }

            registrar.setTag(posicion);
            registrar.setText("Modificar");
        } else {

            registrar.setTag(-1);

        }

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String categoriaValor = categoria.getSelectedItem().toString();
                String nombreValor = nombre.getText().toString();
                String descripcionValor = descripcion.getText().toString();
                boolean publicoValor = publico.isChecked();
                boolean privadoValor = privado.isChecked();
                boolean aceptoValor = acepto.isChecked();

                if (nombreValor.length() == 0) {
                    nombre.setError("El campo es requerido");
                    return;
                } else {
                    nombre.setError(null);
                }
                if (descripcionValor.length() == 0) {
                    descripcion.setError("El campo es requerido");
                    return;
                } else {
                    descripcion.setError(null);
                }

                int posicion = (int) registrar.getTag();
                if (posicion == -1) {
                    Producto obj = new Producto();
                    obj.setNombre(nombreValor);
                    obj.setDescripcion(descripcionValor);
                    obj.setCategoria(categoriaValor);
                    obj.setPublico(publicoValor);
                    obj.setAccept(aceptoValor);

                    ListadoActivity.listaProductos.add(obj);

                    Toast.makeText(MainActivity.this,
                            "Se registro el producto", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    ListadoActivity.listaProductos.get(posicion).setNombre(nombreValor);
                    ListadoActivity.listaProductos.get(posicion).setAccept(aceptoValor);
                    ListadoActivity.listaProductos.get(posicion).setPublico(publicoValor);
                    ListadoActivity.listaProductos.get(posicion).setCategoria(categoriaValor);
                    ListadoActivity.listaProductos.get(posicion).setDescripcion(descripcionValor);

                    Toast.makeText(MainActivity.this,
                            "Se actualizo el producto", Toast.LENGTH_SHORT).show();
                    finish();

                }

            }
        });
    }

    //Le damos funcionalidad al boton home
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //Asignamos animación en la transición de pantallas
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}
