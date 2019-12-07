package com.area51.clase03_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnEmpezar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEmpezar = findViewById(R.id.btnEmpezar);

        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences preferences =
                        getSharedPreferences("clase04", MODE_PRIVATE);
                Intent intent;
                if (preferences.contains("usuario")) {
                    intent = new Intent(MainActivity.this, ListadoActivity.class);
                } else {
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                }
                startActivity(intent);
            }
        });
    }
}
