package com.example.puppies2.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.puppies2.R;
import com.example.puppies2.entidades.PerroVo;
import com.example.puppies2.fragments.DetallePerroFragment;
import com.example.puppies2.fragments.ListaPerrosFragment;

public class MainActivity extends AppCompatActivity implements ListaPerrosFragment.OnFragmentInteractionListener,DetallePerroFragment.OnFragmentInteractionListener, IComunicaFragments {


    ListaPerrosFragment listaFragment;
    DetallePerroFragment detalleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaFragment = new ListaPerrosFragment();


        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,listaFragment).commit();



    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarPerro(PerroVo perro) {
        detalleFragment = new DetallePerroFragment();
        Bundle bundleEnvio = new Bundle();
        bundleEnvio.putSerializable("objeto",perro);
        detalleFragment.setArguments(bundleEnvio);

        //CARGAR FRAGMENT EN ACTIVITY
        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragment,detalleFragment).addToBackStack(null).commit();
    }

    @Override
    public void iniciarDonar() {
        //Toast.makeText(getApplicationContext(),"Prueba del Mactivity",Toast.LENGTH_SHORT).show();
        Intent botonDonar = new Intent(this, Main2Activity.class);
        startActivity(botonDonar);
    }

    @Override
    public void iniciarContactar() {
        Intent botonContactar = new Intent(this, Main2Activity.class);
        startActivity(botonContactar);
    }


}
