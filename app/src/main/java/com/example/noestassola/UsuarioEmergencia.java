package com.example.noestassola;

public class UsuarioEmergencia {
    int id;
    String Nombre1, Apellidos1, Fono1;
    int usuario_id;

    public UsuarioEmergencia() {
    }

    public UsuarioEmergencia(String nombre1, String apellidos1, String fono1, String nombre2, String apellidos2, String fono2, String nombre3, String apellidos3, String fono3,Integer usuario_id) {
        Nombre1 = nombre1;
        Apellidos1 = apellidos1;
        Fono1 = fono1;
        this.usuario_id = usuario_id;

    }

    public boolean isNull(){
        if (Nombre1.equals("")|| Apellidos1.equals("")||Fono1.equals("")){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "UsuarioEmergencia{" +
                "id=" + id +
                ", Nombre1='" + Nombre1 + '\'' +
                ", Apellidos1='" + Apellidos1 + '\'' +
                ", Fono1='" + Fono1 + '\'' +
                ", usuario_id=" + usuario_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre1() {
        return Nombre1;
    }

    public void setNombre1(String nombre1) {
        Nombre1 = nombre1;
    }

    public String getApellidos1() {
        return Apellidos1;
    }

    public void setApellidos1(String apellidos1) {
        Apellidos1 = apellidos1;
    }

    public String getFono1() {
        return Fono1;
    }

    public void setFono1(String fono1) {
        Fono1 = fono1;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }
}
