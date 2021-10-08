package com.example.noestassola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends AppCompatActivity implements View.OnClickListener {

    EditText user,pass;
    Button btnEntrar,btnRegistrar,btnRegistrarcc;
    daoUsuarioPrincipal dao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        user=(EditText)findViewById(R.id.User);
        pass=(EditText)findViewById(R.id.Pass);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        btnRegistrar=(Button)findViewById(R.id.btnRegistrar);
        btnRegistrarcc=(Button)findViewById(R.id.btnRegistrarcc);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        btnRegistrarcc.setOnClickListener(this);

        dao=new daoUsuarioPrincipal(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEntrar:
                    String u=user.getText().toString();
                    String p=pass.getText().toString();
                    if (u.equals("")&&p.equals("")){
                        Toast.makeText(this,"error: campos vacios",Toast.LENGTH_LONG).show();
                    }else if (dao.login(u,p)==1){
                        UsuarioPrincipal ux=dao.getUsuario(u,p);
                        Toast.makeText(this,"Datos correctos",Toast.LENGTH_LONG).show();
                        Intent i2 = new Intent(Main.this,Inicio.class);
                        i2.putExtra("id",ux.getUsuariop_id());
                        startActivity(i2);

                    }else {
                        Toast.makeText(this,"Usuario o Password incorrectos",Toast.LENGTH_LONG).show();
                    }
                break;

            case R.id.btnRegistrar:
                Intent i = new Intent(Main.this, RegistrarPrincipal.class);
                startActivity(i);
                break;

            case R.id.btnRegistrarcc:
                Intent i2 = new Intent(Main.this, RegistrarCirculoCercano.class);
                startActivity(i2);
                break;
        }
    }
}
