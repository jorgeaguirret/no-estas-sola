package com.example.noestassola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistrarEmergencia extends AppCompatActivity implements View.OnClickListener {

    EditText us,pas,nom,ap,ema,fon,dir,com,com2,usu_id;
    Button reg,can;
    daoUsuarioEmergencia dao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registraremergencia);


    us=(EditText)findViewById(R.id.RegNombre1);
    pas=(EditText)findViewById(R.id.RegApellido1);
    nom=(EditText)findViewById(R.id.RegFono1);
    ap=(EditText)findViewById(R.id.RegNombre2);
    ema=(EditText)findViewById(R.id.RegApellido2);
    fon=(EditText)findViewById(R.id.RegFono2);
    dir=(EditText)findViewById(R.id.RegNombre3);
    com=(EditText)findViewById(R.id.RegApellido3);
    com2=(EditText)findViewById(R.id.RegFono3);
    usu_id=(EditText)findViewById(R.id.RegUsu_id);

    reg=(Button)findViewById(R.id.btnRegRegistrar);
    can=(Button)findViewById(R.id.btnRegCancelar);

        reg.setOnClickListener(this);
        can.setOnClickListener(this);

    dao=new daoUsuarioEmergencia(this);
}

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnRegRegistrar:

                UsuarioEmergencia u=new UsuarioEmergencia();
                u.setNombre1(us.getText().toString());
                u.setApellidos1(pas.getText().toString());
                u.setFono1(nom.getText().toString());
                u.setUsuario_id(Integer.parseInt(usu_id.getText().toString()));



                if (!u.isNull()){
                    Toast.makeText(this,"¡Error! Debe agregar al menos un contacto...",Toast.LENGTH_LONG).show();
                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this,"Contacto Registrado Exitosamente",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(RegistrarEmergencia.this,Amigos.class);
                    //i2.putExtra("id",u.getId());
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this,"Usuario ya registrado!!",Toast.LENGTH_LONG).show();
                }

                break;

            /*case R.id.btnRegCancelar:
                Intent i = new Intent(RegistrarEmergencia.this,Main.class);
                startActivity(i);
                finish();
                break;*/
        }
    }
}