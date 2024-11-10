package com.example.listadin;

import static global.info.lista;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import adaptador.adaptadoreliminar;
import pojo.equipo;

public class ver2 extends AppCompatActivity {
    RecyclerView rv2;
    Context context;
    Toolbar toolbar;
    SharedPreferences archivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ver2);

        archivo = this.getSharedPreferences("sesion", MODE_PRIVATE);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rv2=findViewById(R.id.rv_lista2);
        adaptadoreliminar av = new adaptadoreliminar();
        av.context=this;
        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv2.setLayoutManager(llm);
        rv2.setAdapter(av);
    }
    public void del(View view) {
        List<equipo> itemsParaEliminar = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            equipo item = lista.get(i);
            if (item.isChecked()) {
                itemsParaEliminar.add(item);
            }
        }
        rv2.getAdapter().notifyDataSetChanged();
        lista.removeAll(itemsParaEliminar);
    }
    @Override
    public void onOptionsMenuClosed(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        super.onOptionsMenuClosed(menu);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.opc1){
            Intent cambio = new Intent(this, ver.class);
            startActivity(cambio);
        }
        if(item.getItemId()==R.id.opc2){
            Intent cambio = new Intent(this, autor.class);
            startActivity(cambio);
        }
        if(item.getItemId()==R.id.opc3){
            Intent cambio = new Intent(this, contacto.class);
            startActivity(cambio);
        }
        if(item.getItemId()==R.id.opc4){
            Intent cambio = new Intent(this, MainActivity.class);
            startActivity(cambio);
        }
        if(item.getItemId()==R.id.opc5){
            Intent cambio = new Intent(this, modificar.class);
            startActivity(cambio);
        }
        if(item.getItemId()==R.id.opc6){
            Intent cambio = new Intent(this, ver2.class);
            startActivity(cambio);
        }
        if(item.getItemId()==R.id.wazaa){
            if(archivo.contains("usuario") && archivo.contains("contra")){
                SharedPreferences.Editor editor = archivo.edit();
                editor.remove("usuario");
                editor.remove("contra");
                editor.remove("valida");
                editor.commit();
                Intent fin = new Intent(this, inicio.class);
                startActivity(fin);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}