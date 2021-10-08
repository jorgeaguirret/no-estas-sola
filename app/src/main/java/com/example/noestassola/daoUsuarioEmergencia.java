package com.example.noestassola;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuarioEmergencia {
    Context c;
    UsuarioEmergencia u;
    ArrayList<UsuarioEmergencia> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tabla="create table if not exists usuarioemergencia(id integer primary key autoincrement, nombre1 text, ap1 text, fono1 text, usuario_id integer)";

    public daoUsuarioEmergencia(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        u=new UsuarioEmergencia();
    }


    public boolean insertUsuario(UsuarioEmergencia u){
        if (buscar(u.getNombre1())==0){
            ContentValues cv=new ContentValues();
            cv.put("nombre1",u.getNombre1());
            cv.put("ap1",u.getApellidos1());
            cv.put("fono1",u.getFono1());
            cv.put("usuario_id",u.getUsuario_id());

            return (sql.insert("usuarioemergencia",null,cv)>0);
        }else {
            return false;
        }
    }

    public int buscar(String u){
        int x=0;
        lista=selectUsuario();
        for (UsuarioEmergencia us:lista) {
            if (us.getNombre1().equals(u)){
             x++;
            }
        }
        return x;
    }

    public ArrayList<UsuarioEmergencia> selectUsuario(){
        ArrayList<UsuarioEmergencia> lista=new ArrayList<UsuarioEmergencia>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuarioemergencia", null);
        if (cr!=null&&cr.moveToFirst()){
            do {
                UsuarioEmergencia u=new UsuarioEmergencia();
                u.setId(cr.getInt(0));
                u.setNombre1(cr.getString(1));
                u.setApellidos1(cr.getString(2));
                u.setFono1(cr.getString(3));
                u.setUsuario_id(cr.getInt(4));

                lista.add(u);
            }while (cr.moveToNext());
        }
        return lista;
    }

    public int login(String u, String p){
        int a=0;
        Cursor cr=sql.rawQuery("select * from usuarioemergencia", null);
        if (cr!=null&&cr.moveToFirst()){
            do {
                if (cr.getString(1).equals(u)&&cr.getString(2).equals(p)){
                    a++;
                }
            }while (cr.moveToNext());
        }
        return a;
    }

    public UsuarioEmergencia getUsuario(String u, String p){
        lista=selectUsuario();
        for (UsuarioEmergencia us: lista) {
            if (us.getNombre1().equals(u)&&us.getApellidos1().equals(p)){ //OJO AQUIIIIIIIIIIIIIIII
                return us;
            }
        }
        return null;
    }

    public UsuarioEmergencia getUsuarioById(int id){
        lista=selectUsuario();
        for (UsuarioEmergencia us: lista) {
            if (us.getId()==id){
                return us;
            }
        }
        return null;
    }

    public boolean updateUsuario(UsuarioEmergencia u){
        ContentValues cv=new ContentValues();
        cv.put("nombre1",u.getNombre1());
        cv.put("ap1",u.getApellidos1());
        cv.put("fono1",u.getFono1());
        cv.put("usuario_id",u.getUsuario_id());

        return (sql.update("usuarioemergencia",cv,"id="+u.getId(),null)>0);
    }

    public boolean deleteUsuario(int id){
        return (sql.delete("usuarioemergencia","id"+id,null)>0);
    }
}
