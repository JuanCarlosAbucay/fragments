package com.example.correo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Principal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle onSavedInstanceState){
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentListado frgListado = (FragmentListado) getSupportFragmentManager().findFragmentById(R.id.frgListado);
        frgListado.setCorreosListener(correo -> {
            FragmentDetalle frgDetalle = (FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
            if (frgDetalle != null){
                frgDetalle.mostrarDetall(correo.texto);
            }
            else {
                Intent i = new Intent(this, DetalleActivity.class);
                i.putExtra(DetalleActivity.EXTRA_TEXTO, correo.texto);
                startActivity(i);
            }
        });
    }
}
