package com.example.noestassola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Emergencias extends AppCompatActivity {

    ImageView imghome, imgcirculo, imgperfil;
    ImageView carabineros, pdi,mujer,bomberos,ambulancia;
    int id=0;
    UsuarioPrincipal u;
    daoUsuarioPrincipal dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergencias);

        carabineros = (ImageView) findViewById(R.id.btn_carabineros);
        pdi = (ImageView) findViewById(R.id.btn_pdi);
        bomberos = (ImageView) findViewById(R.id.btn_bomberos);
        ambulancia = (ImageView) findViewById(R.id.btn_ambulancias);
        mujer = (ImageView) findViewById(R.id.btn_mujer);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuarioPrincipal(this);
        u=dao.getUsuarioById(id);

        if(ActivityCompat.checkSelfPermission(Emergencias.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED&& ActivityCompat.checkSelfPermission(Emergencias.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){ ActivityCompat.requestPermissions(Emergencias.this,new String[]

                { Manifest.permission.CALL_PHONE,},1000);
        }else{
        };
        carabineros.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:133"));
                Toast.makeText(getApplicationContext(), "Llamando al 133 de carabineros.", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

        pdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:134"));
                Toast.makeText(getApplicationContext(), "Llamando al 134 de PDI.", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

        ambulancia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:131"));
                Toast.makeText(getApplicationContext(), "Llamando al 131 de ambulancias.", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

        bomberos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:132"));
                Toast.makeText(getApplicationContext(), "Llamando al 132 de Bomberos.", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

        mujer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:1455"));
                Toast.makeText(getApplicationContext(), "Llamando al 1455 de Fono Mujer.", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });

     /* imghome = (ImageView) findViewById(R.id.imghome);
        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTipoUsu = new Intent(Emergencias.this,Inicio.class);
                Emergencias.this.startActivity(intentTipoUsu);
            }
        });

        imgperfil = (ImageView) findViewById(R.id.imgperfil);
        imgperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentTipoUsu = new Intent(Emergencias.this,Mostrar.class);
                Emergencias.this.startActivity(intentTipoUsu);
            }
        });*/

        imghome = (ImageView) findViewById(R.id.imghome);
        imgperfil=(ImageView) findViewById(R.id.imgperfil);
        imgcirculo=(ImageView)findViewById(R.id.imgcirculo);
        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emergencias.this,Inicio.class);
                intent.putExtra("id",u.getUsuariop_id());
                startActivity(intent);
            }
        });
        imgperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emergencias.this,Editar.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        imgcirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Emergencias.this,Amigos.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }





}