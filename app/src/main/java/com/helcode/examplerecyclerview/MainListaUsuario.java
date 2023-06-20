package com.helcode.examplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainListaUsuario extends AppCompatActivity {
    ArrayList<String> name,lastname;
    RecyclerView recyclerView;
    RecyclerAdapter MyAdapter;
    BDHelper BD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lista_usuario);

        BD = new BDHelper(this);
        name= new ArrayList<>();
        lastname= new ArrayList<>();
        recyclerView= findViewById(R.id.recycler);
        MyAdapter= new RecyclerAdapter(this,name,lastname);
        recyclerView.setAdapter(MyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MostrarInfo();
    }

    private void MostrarInfo() {
        Cursor cursor= BD.getdata();
        if (cursor.getCount()== 0){
            Toast.makeText(this, "No Hay Datos", Toast.LENGTH_SHORT).show();
            return;
        }else {
            while (cursor.moveToNext()){
                name.add(cursor.getString(0));
                lastname.add(cursor.getString(1));
            }
        }

    }
}