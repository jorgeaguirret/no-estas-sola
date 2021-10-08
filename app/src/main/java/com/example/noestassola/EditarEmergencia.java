package com.example.noestassola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditarEmergencia extends AppCompatActivity implements View.OnClickListener {

    EditText ediUser,ediPass,ediNombre,ediApellido,ediEmail,ediFono,ediDireccion,ediComuna,ediComuna2;
    Button btnActualizar, btnCancelar;
    int id=0;
    UsuarioEmergencia u ;
    daoUsuarioEmergencia dao;
    Intent x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editaremergencia);

        ediUser=(EditText)findViewById(R.id.EdiNombre1);
        ediPass=(EditText)findViewById(R.id.EdiApellido1);
        ediNombre=(EditText)findViewById(R.id.EdiFono1);
        ediApellido=(EditText)findViewById(R.id.EdiNombre2);
        ediEmail=(EditText)findViewById(R.id.EdiApellido2);
        ediFono=(EditText)findViewById(R.id.EdiFono2);
        ediDireccion=(EditText)findViewById(R.id.EdiNombre3);
        ediComuna=(EditText)findViewById(R.id.EdiApellido3);
        ediComuna2=(EditText)findViewById(R.id.EdiFono3);
        btnActualizar=(Button)findViewById(R.id.btnEdiActualizar);
        btnCancelar=(Button)findViewById(R.id.btnEdiCancelar);
        btnActualizar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuarioEmergencia(this);
        u=dao.getUsuarioById(id);
        ediUser.setText(u.getNombre1());
        ediPass.setText(u.getApellidos1());
        ediNombre.setText(u.getFono1());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEdiActualizar:
                u.setNombre1(ediUser.getText().toString());
                u.setApellidos1(ediPass.getText().toString());
                u.setFono1(ediNombre.getText().toString());

                if (!u.isNull()){
                    Toast.makeText(this,"error: campos vacios",Toast.LENGTH_LONG).show();
                }else if(dao.updateUsuario(u)){
                    Toast.makeText(this,"Actualizacion Exitosa",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(EditarEmergencia.this,Inicio.class);
                    i2.putExtra("id",u.getId());
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this,"No se puede actualizar!!",Toast.LENGTH_LONG).show();
                }
                break;
            /*case R.id.btnEdiCancelar:
                Intent i2 = new Intent(EditarEmergencia.this,Inicio.class);
                i2.putExtra("id",u.getId());
                startActivity(i2);
                finish();
                break;*/
        }
    }
}