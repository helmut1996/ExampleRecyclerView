package com.helcode.examplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText textoEdit,textoEdit2;
    Button btnAgregar,btnMostrar;

    BDHelper BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        //mando a llamar la clase conexion de BD
        BD= new BDHelper(this);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = textoEdit.getText().toString();
                String lastname= textoEdit2.getText().toString();

                Boolean checkInsertData = BD.inserdata(name,lastname);

                if (checkInsertData== true){
                    Toast.makeText(MainActivity.this, "Nuevo Dato Insertado", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "No se Insertado el Nuevo Dato ", Toast.LENGTH_SHORT).show();
                }
            }


        });

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainListaUsuario.class);
                startActivity(intent);
            }
        });

    }


    private void initView() {
    textoEdit = findViewById(R.id.editTextTextPersonName2);
        textoEdit2 = findViewById(R.id.editTextTextPersonName3);
    btnAgregar = findViewById(R.id.btn_guardar);
    btnMostrar= findViewById(R.id.btn_mostrar);
    }
}