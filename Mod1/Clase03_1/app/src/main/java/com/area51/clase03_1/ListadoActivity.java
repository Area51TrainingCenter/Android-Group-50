package com.area51.clase03_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ListadoActivity extends AppCompatActivity {
    private Button btnNuevo;
    private ListView lvLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        btnNuevo = findViewById(R.id.btnNuevo);
        lvLista = findViewById(R.id.lvLista);

        btnNuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListadoActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}
