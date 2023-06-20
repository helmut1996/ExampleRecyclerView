package com.helcode.examplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ModelUser> arrayList = new ArrayList<>();
    RecyclerAdapter adapter;
    EditText textoEdit;
    RecyclerView recyclerItem;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = "";
                texto = textoEdit.getText().toString();

                arrayList.add(new ModelUser(texto));
                adapter.notifyItemInserted(arrayList.size() -1);
                 textoEdit.getText().clear();
                 recyclerItem.scrollToPosition(arrayList.size()-1);
            }


        });

        recyclerItem.setLayoutManager(new LinearLayoutManager(this));
        adapter= new  RecyclerAdapter(this,arrayList);
        recyclerItem.setAdapter(adapter);

        System.out.println( "Mostrando Texto"+arrayList.toString());
    }

    private void initRecyclerView() {

    }

    private void initView() {
    textoEdit = findViewById(R.id.editTexto);
    recyclerItem= findViewById(R.id.lista_items);
    btnAgregar = findViewById(R.id.btn_agregar);
    }
}