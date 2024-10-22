package com.example.listadin;

import android.content.Intent;
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

public class MainActivity extends AppCompatActivity {

    EditText nomEquipo, puntos, juegos, ganados, empatados, ncontacto;
    Toolbar toolbar;
    Button guardar, limpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        nomEquipo = findViewById(R.id.item0);
        puntos = findViewById(R.id.item1);
        juegos = findViewById(R.id.item2);
        ganados = findViewById(R.id.item3);
        empatados = findViewById(R.id.item4);
        ncontacto = findViewById(R.id.item5);

        guardar = findViewById(R.id.guardar);
        limpiar = findViewById(R.id.limpiar);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });

    }

    private void limpiar() {
        nomEquipo.setText("");
        puntos.setText("");
        juegos.setText("");
        ganados.setText("");
        empatados.setText("");
        ncontacto.setText("");
    }

    private void guardar() {
        equipo unequipo =new equipo();
        unequipo.setTeam(nomEquipo.getText().toString());

        unequipo.setPoints(puntos.getText().toString());

        unequipo.setGames(juegos.getText().toString());

        unequipo.setWins(ganados.getText().toString());

        unequipo.setTies(empatados.getText().toString());

        unequipo.setContact(ncontacto.getText().toString());
        info.lista.add(unequipo);
        Toast.makeText(this,"Guardando",Toast.LENGTH_SHORT).show();
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
        return super.onOptionsItemSelected(item);
    }
}