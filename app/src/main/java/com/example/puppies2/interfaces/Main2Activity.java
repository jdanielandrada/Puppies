package com.example.puppies2.interfaces;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.puppies2.R;



public class Main2Activity extends AppCompatActivity {

    Button botonTelefono;
    Button botonWpp;
    Button botonGmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //REDIRECCION A TELEFONO
        botonTelefono = findViewById(R.id.boton_telefono);
        botonTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent phoneIntent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+"1154847164"));
                Intent phoneIntent = new Intent(Intent.ACTION_DIAL); Uri data = Uri.parse("tel:"+"1154847164");
                phoneIntent.addCategory("android.intent.category.DEFAULT");
                phoneIntent.setData(data);
                startActivity(phoneIntent);
            }
        });


        //REDIRECCION A WHATSAPP
        botonWpp = findViewById(R.id.boton_whatsapp);
        botonWpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse ("smsto:" + "1154847164");
                Intent i = new Intent (Intent.ACTION_SENDTO, uri);
                i.setPackage("com.whatsapp");
                startActivity(i);
            }
        });


        //REDIRECCION A GMAIL
        botonGmail = findViewById(R.id.boton_gmail);
        botonGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"dejandohuella@gmail.com"});
                //intent.putExtra(Intent.EXTRA_SUBJECT, "PONER LO QUE QUIERA DE TEMA");
                intent.setPackage("com.google.android.gm");

                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Gmail no está instalado", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}
