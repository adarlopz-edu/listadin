package com.example.listadin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import global.info;
import pojo.equipo;

public class modificar extends AppCompatActivity {
    EditText ne, p, jj, jg, je, noe;
    Button anterior, actualizar, siguiente;
    Integer posicion = -1;
    Toolbar toolbar;
    SharedPreferences archivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_modificar);

        archivo = this.getSharedPreferences("sesion", Context.MODE_PRIVATE);
        ne =findViewById(R.id.ne);
        p =findViewById(R.id.p);
        jj =findViewById(R.id.jj);
        jg =findViewById(R.id.jg);
        je =findViewById(R.id.je);
        noe =findViewById(R.id.noe);
        anterior = findViewById(R.id.anterior);
        actualizar = findViewById(R.id.actualizar);
        siguiente = findViewById(R.id.siguiente);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        siguiente();

        anterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anterior();
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar();
            }
        });
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente();
            }
        });
    }
    private void siguiente() {
        Integer tamaño = info.lista.size();
        if (tamaño == 0) {
            Toast.makeText(this, "Lista vacía", Toast.LENGTH_SHORT).show();
            return;
        }

        posicion = (posicion + 1) % tamaño; // si sobrepasa vuelve a cero
        mostrarEquipo();
    }
    private void actualizar() {
        equipo equipoActual = info.lista.get(posicion);
        equipoActual.setTeam(ne.getText().toString());
        equipoActual.setPoints(p.getText().toString());
        equipoActual.setWins(jj.getText().toString());
        equipoActual.setGames(jg.getText().toString());
        equipoActual.setTies(je.getText().toString());
        equipoActual.setContact(noe.getText().toString());
    }
    private void anterior() {
        Integer tamaño = info.lista.size();
        if (tamaño == 0) {
            Toast.makeText(this, "Lista vacía", Toast.LENGTH_SHORT).show();
            return;
        }
        posicion = (posicion - 1 + tamaño) % tamaño;
        mostrarEquipo();
    }
    private void mostrarEquipo() {
        equipo equipoActual = info.lista.get(posicion);

        // Actualiza los campos con la información del equipo actual
        ne.setText(equipoActual.getTeam());
        p.setText(equipoActual.getPoints());
        jj.setText(equipoActual.getWins());
        jg.setText(equipoActual.getGames());
        je.setText(equipoActual.getTies());
        noe.setText(equipoActual.getContact());
        // Mostrar el índice actual en un Toast (opcional, para depuración)
        Toast.makeText(this, "P" + posicion, Toast.LENGTH_SHORT).show();
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
            if(archivo.contains("id_usuario"))  {
                SharedPreferences.Editor editor =  archivo.edit();
                editor.remove("id_usuario");
                editor.commit();
                Intent x = new Intent(this, inicio.class);
                startActivity(x);
                finish();
            }
//            if(archivo.contains("usuario") && archivo.contains("contra")){
//                SharedPreferences.Editor editor = archivo.edit();
//                editor.remove("usuario");
//                editor.remove("contra");
//                editor.remove("valida");
//                editor.commit();
//                Intent fin = new Intent(this, inicio.class);
//                startActivity(fin);
//                finish();
//            }
        }
        return super.onOptionsItemSelected(item);
    }
}