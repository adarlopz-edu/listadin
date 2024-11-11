package com.example.listadin;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import global.info;

public class cardview extends AppCompatActivity {
    Button llamar;
    Toolbar toolbar;
    TextView ne, p, jj, jg, je, noe;
    SharedPreferences archivo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cardview);

        archivo = this.getSharedPreferences("sesion", Context.MODE_PRIVATE);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        llamar = findViewById(R.id.llamar);
        ne =findViewById(R.id.ne);
        p =findViewById(R.id.p);
        jj =findViewById(R.id.jj);
        jg =findViewById(R.id.jg);
        je =findViewById(R.id.je);
        noe =findViewById(R.id.noe);

        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamar();
            }
        });

        int posicion;
        posicion=getIntent().getIntExtra("posicion", -1);
        ne.setText(info.lista.get(posicion).getTeam());
        p.setText(info.lista.get(posicion).getPoints());
        jj.setText(info.lista.get(posicion).getWins());
        jg.setText(info.lista.get(posicion).getGames());
        je.setText(info.lista.get(posicion).getTies());
        noe.setText(info.lista.get(posicion).getContact());
    }

    private void llamar() {
        Intent llamada = new Intent(Intent.ACTION_CALL);
        llamada.setData(Uri.parse(  "tel: "+ noe.getText().toString()));
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.CALL_PHONE
            }, 10);
        }
        startActivity(llamada);
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