package com.example.recycleviewpermisos.Model;

public class Perrmisos {
    public String nombre;
    public String[] permiso;

    public Perrmisos(String nombre, String permiso[]) {
        this.nombre = nombre;
        this.permiso = permiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String[] getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso[]) {
        this.permiso = permiso;
    }
}
