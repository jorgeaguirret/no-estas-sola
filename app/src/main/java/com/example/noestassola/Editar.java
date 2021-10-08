package com.example.noestassola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Editar extends AppCompatActivity implements View.OnClickListener {

    EditText ediUser,ediPass,ediNombre,ediApellido,ediEmail,ediFono,ediDireccion,ediComuna;
    Button btnActualizar, btnCancelar;
    int id=0;
    UsuarioPrincipal u ;
    daoUsuarioPrincipal dao;
    Intent x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar);

        ediUser=(EditText)findViewById(R.id.EdiUser);
        ediPass=(EditText)findViewById(R.id.EdiPass);
        ediNombre=(EditText)findViewById(R.id.EdiNombre);
        ediApellido=(EditText)findViewById(R.id.EdiApellido);
        ediEmail=(EditText)findViewById(R.id.EdiEmail);
        ediFono=(EditText)findViewById(R.id.EdiFono);
        ediDireccion=(EditText)findViewById(R.id.EdiDireccion);
        ediComuna=(EditText)findViewById(R.id.EdiComuna);
        btnActualizar=(Button)findViewById(R.id.btnEdiActualizar);
        btnCancelar=(Button)findViewById(R.id.btnEdiCancelar);
        btnActualizar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);

        Bundle b = getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuarioPrincipal(this);
        u=dao.getUsuarioById(id);

        ediNombre.setText(u.getNombre());
        ediApellido.setText(u.getApellido());
        ediUser.setText(u.getUsuario());
        ediPass.setText(u.getPassword());
        ediFono.setText(u.getTelefono());
        ediDireccion.setText(u.getDireccion());
        ediComuna.setText(u.getComuna());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEdiActualizar:
                u.setUsuario(ediUser.getText().toString());
                u.setPassword(ediPass.getText().toString());
                u.setNombre(ediNombre.getText().toString());
                u.setApellido(ediApellido.getText().toString());
                u.setTelefono(ediFono.getText().toString());
                u.setDireccion(ediDireccion.getText().toString());
                u.setComuna(ediComuna.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this,"error: campos vacios",Toast.LENGTH_LONG).show();
                }else if(dao.updateUsuario(u)){
                    Toast.makeText(this,"Actualizacion Exitosa",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(Editar.this,Inicio.class);
                    i2.putExtra("id",u.getUsuariop_id());
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this,"No se puede actualizar!!",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnEdiCancelar:
                Intent i2 = new Intent(Editar.this,Inicio.class);
                i2.putExtra("id",u.getUsuariop_id());
                startActivity(i2);
                finish();
                break;
        }
    }

}