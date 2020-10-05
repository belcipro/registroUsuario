package edu.continental;

public class Usuario {
    public String idusuario;
    public String apellido;
    public String nombre;
    public String direccion;
    public String nacionalidad;
    public String fechanac;
    public String telefono;
    public String email;
    public String password;

    public Usuario() {
    }

    public Usuario(String idusuario, String apellido, String nombre, String direccion, String nacionalidad, String fechanac, String telefono, String email, String password) {
        this.idusuario = idusuario;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
        this.fechanac = fechanac;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }


    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
