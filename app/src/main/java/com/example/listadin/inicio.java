package com.example.listadin;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class inicio extends AppCompatActivity {
    EditText user, pass;
    Button ingresar;
    Context context;
    SharedPreferences archivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_inicio);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        ingresar = findViewById(R.id.ingresar);
        archivo = this.getSharedPreferences("sesion", Context.MODE_PRIVATE);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ingresar();
            }
        });
    }
    private void ingresar() {
        if(user.getText().toString().equals("GUSA") && pass.getText().toString().equals("123456")){
            Intent in = new Intent(this, MainActivity.class);
            SharedPreferences.Editor editor = archivo.edit();
            editor.putString("usuario", "GUSA");
            editor.putString("contra", "123456");
            editor.putBoolean("valido", true);
            editor.apply();
            //editor.commit();
            startActivity(in);
            finish();
        }else{
            user.setText("");
            pass.setText("");
            Toast.makeText(this, "incorrecto", Toast.LENGTH_LONG);
        }
    }
}