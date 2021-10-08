package com.example.noestassola;

public class UsuarioCirculoCercano {

    int usuariocc_id;
    String Nombre, Apellido, Usuario, Password, Telefono;
    int rol_id;

    public UsuarioCirculoCercano() {
    }

    public UsuarioCirculoCercano(int usuariocc_id, String nombre, String apellido, String usuario, String password, String telefono, int rol_id) {
        this.usuariocc_id = usuariocc_id;
        Nombre = nombre;
        Apellido = apellido;
        Usuario = usuario;
        Password = password;
        Telefono = telefono;
        this.rol_id = rol_id;
    }

    public boolean isNull(){
        if (Nombre.equals("")|| Apellido.equals("")||Usuario.equals("")|| Password.equals("")||Telefono.equals("")){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "UsuarioCirculoCercano{" +
                "usuariocc_id=" + usuariocc_id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", Password='" + Password + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", rol_id=" + rol_id +
                '}';
    }

    public int getUsuariocc_id() {
        return usuariocc_id;
    }

    public void setUsuariocc_id(int usuariocc_id) {
        this.usuariocc_id = usuariocc_id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }
}
