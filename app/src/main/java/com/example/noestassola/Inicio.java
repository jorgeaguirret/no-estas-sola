package com.example.noestassola;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    Button btnEditar,btnEliminar,btnMostrar,btnSalir ,btnEnviarSms;
    TextView nombre,telefono1;
    ImageView imgperfil,imgemergencia,imgcirculo;
    int id=0;
    UsuarioPrincipal u;
    daoUsuarioPrincipal dao;

    //agregado ultimo
    UsuarioEmergencia ue;
    daoUsuarioEmergencia daoem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        imgcirculo=(ImageView)findViewById(R.id.imgcirculo);
        imgemergencia=(ImageView)findViewById(R.id.imgemergencia);
        imgperfil=(ImageView)findViewById(R.id.imgperfil);
        nombre=(TextView)findViewById(R.id.nombreUsuario);
        btnSalir=(Button)findViewById(R.id.btnSalir);

        imgcirculo.setOnClickListener(this);
        imgemergencia.setOnClickListener(this);
        imgperfil.setOnClickListener(this);
        btnSalir.setOnClickListener(this);


        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuarioPrincipal(this);

        u=dao.getUsuarioById(id);

        nombre.setText(u.getNombre()+" "+u.getApellido());

        //agregado

        Bundle b2 = getIntent().getExtras();
        id=b2.getInt("id");
        daoem=new daoUsuarioEmergencia(this);
        ue=daoem.getUsuarioById(id);





        btnEnviarSms = (Button)findViewById(R.id.btnEnviarSms);
        if(ActivityCompat.checkSelfPermission(Inicio.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED&& ActivityCompat.checkSelfPermission(Inicio.this,Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){ ActivityCompat.requestPermissions(Inicio.this,new String[]

                { Manifest.permission.SEND_SMS,},1000);
        }else{
        };
        btnEnviarSms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //enviarMensaje("922126811","945619099","930596548", "Por favor, necesito ayuda... Enviado por NO ESTA SSOLA APP");
                enviarMensaje(telefono1,"Por favor, necesito ayuda... Enviado por NO ESTA SSOLA APP");

            }
        });


    }

    private void enviarMensaje (TextView telefono1, String mensaje){
        try {
            SmsManager sms = SmsManager.getDefault();

            sms.sendTextMessage(String.valueOf(telefono1),null,mensaje,null,null);
            Toast.makeText(getApplicationContext(), "Mensaje de Alerta Enviado Exitosamente.", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Mensaje no enviado, verificar saldo o permisos.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    /*private void enviarMensaje (String numero, String numero1, String numero3, String mensaje){
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero,null,mensaje,null,null);
            sms.sendTextMessage(numero1,null,mensaje,null,null);
            sms.sendTextMessage(numero3,null,mensaje,null,null);
            Toast.makeText(getApplicationContext(), "Mensaje de Alerta Enviado Exitosamente.", Toast.LENGTH_LONG).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Mensaje no enviado, verificar saldo o permisos.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }*/


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgcirculo:
                Intent am =new Intent(Inicio.this,Amigos.class);
                am.putExtra("id",id);
                startActivity(am);
                break;
            case R.id.imgemergencia:
                Intent ae =new Intent(Inicio.this,Emergencias.class);
                ae.putExtra("id",id);
                startActivity(ae);
                break;
            case R.id.imgperfil:
                Intent a = new Intent(Inicio.this,Editar.class);
                a.putExtra("id",id);
                startActivity(a);
                break;


            case R.id.btnSalir:
                Intent i2 = new Intent(Inicio.this,Main.class);
                startActivity(i2);
                finish();
                break;

        }
    }
}