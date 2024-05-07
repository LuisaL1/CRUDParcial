package edu.cue.domain;

import java.io.Serializable;

public class Cliente implements Serializable {
    public String ID;
    public String nombre;
    public String direccion;
    public int telefono;

    public Cliente(String ID, String nombre, String direccion, int telefono) {
        this.ID = ID;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}


