package com.example.noestassola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Amigos extends AppCompatActivity {

    Button btnEditar,btnEliminar,btnMostrar,btnSalir ,btnEnviarSms,btn_registrar_contactos,btn_mis_contactos;
    TextView nombre;
    ImageView imgperfil,imgemergencia,imghome;
    int id=0;
    UsuarioPrincipal u;
    daoUsuarioPrincipal dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amigos);

        btn_mis_contactos=(Button)findViewById(R.id.btn_mis_contactos);
        btn_registrar_contactos=(Button)findViewById(R.id.btn_registrar_contactos);
        imgemergencia=(ImageView)findViewById(R.id.imgemergencia);
        imgperfil=(ImageView)findViewById(R.id.imgperfil);
        imghome = (ImageView) findViewById(R.id.imghome);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuarioPrincipal(this);
        u=dao.getUsuarioById(id);

        imghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Amigos.this,Inicio.class);
                intent.putExtra("id",u.getUsuariop_id());
                startActivity(intent);
            }
        });
        imgperfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Amigos.this,Editar.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        imgemergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ae =new Intent(Amigos.this,Emergencias.class);
                ae.putExtra("id",id);
                startActivity(ae);
            }
        });

        btn_registrar_contactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ae =new Intent(Amigos.this,RegistrarEmergencia.class);
                startActivity(ae);
            }
        });

        btn_mis_contactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Amigos.this,EditarEmergencia.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });


    }
}