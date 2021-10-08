package com.example.noestassola;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class daoUsuarioCercano {

    Context c;
    UsuarioCirculoCercano u;
    ArrayList<UsuarioCirculoCercano> lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tabla="create table if not exists usuariocirculocercano(usuariocc_id integer primary key autoincrement,  nombre text, apellido text, usuario text, pass text, telefono text, rol_id integer)";

    public daoUsuarioCercano(Context c){
        this.c=c;
        sql=c.openOrCreateDatabase(bd,c.MODE_PRIVATE,null);
        sql.execSQL(tabla);
        u=new UsuarioCirculoCercano();
    }


    public boolean insertUsuario(UsuarioCirculoCercano u){
        if (buscar(u.getUsuario())==0){
            ContentValues cv=new ContentValues();
            cv.put("nombre",u.getNombre());
            cv.put("apellido",u.getApellido());
            cv.put("usuario",u.getUsuario());
            cv.put("pass",u.getPassword());
            cv.put("telefono",u.getTelefono());
            cv.put("rol_id",u.getRol_id());
            return (sql.insert("usuariocirculocercano",null,cv)>0);
        }else {
            return false;
        }
    }

    public int buscar(String u){
        int x=0;
        lista=selectUsuario();
        for (UsuarioCirculoCercano us:lista) {
            if (us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<UsuarioCirculoCercano> selectUsuario(){
        ArrayList<UsuarioCirculoCercano> lista=new ArrayList<UsuarioCirculoCercano>();
        lista.clear();
        Cursor cr=sql.rawQuery("select * from usuariocirculocercano", null);
        if (cr!=null&&cr.moveToFirst()){
            do {
                UsuarioCirculoCercano u=new UsuarioCirculoCercano();
                u.setUsuariocc_id(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setApellido(cr.getString(2));
                u.setUsuario(cr.getString(3));
                u.setPassword(cr.getString(4));
                u.setTelefono(cr.getString(5));
                u.setRol_id(cr.getInt(6));
                lista.add(u);
            }while (cr.moveToNext());
        }
        return lista;
    }

    public int login(String u, String p){
        int a=0;
        Cursor cr=sql.rawQuery("select * from usuariocirculocercano", null);
        if (cr!=null&&cr.moveToFirst()){
            do {
                if (cr.getString(3).equals(u)&&cr.getString(4).equals(p)){
                    a++;
                }
            }while (cr.moveToNext());
        }
        return a;
    }

    public UsuarioCirculoCercano getUsuario(String u, String p){
        lista=selectUsuario();
        for (UsuarioCirculoCercano us: lista) {
            if (us.getUsuario().equals(u)&&us.getPassword().equals(p)){
                return us;
            }
        }
        return null;
    }

    public UsuarioCirculoCercano getUsuarioById(int usuariocc_id){
        lista=selectUsuario();
        for (UsuarioCirculoCercano us: lista) {
            if (us.getUsuariocc_id()==usuariocc_id){
                return us;
            }
        }
        return null;
    }

    public boolean updateUsuario(UsuarioCirculoCercano u){
        ContentValues cv=new ContentValues();

        cv.put("nombre",u.getNombre());
        cv.put("apellido",u.getApellido());
        cv.put("usuario",u.getUsuario());
        cv.put("pass",u.getPassword());
        cv.put("telefono",u.getTelefono());
        cv.put("rol_id",u.getRol_id());
        return (sql.update("usuariocirculocercano",cv,"usuariocc_id="+u.getUsuariocc_id(),null)>0);
    }

    public boolean deleteUsuario(int usuariocc_id){
        return (sql.delete("usuariocirculocercano","usuariocc_id"+usuariocc_id,null)>0);
    }

}
