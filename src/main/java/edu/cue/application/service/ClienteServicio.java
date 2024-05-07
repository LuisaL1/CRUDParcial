package edu.cue.application.service;

import edu.cue.domain.Cliente;

import java.util.List;

public interface ClienteServicio {
    Cliente consultarCliente(String IDCliente) throws Exception;
    void insertarCliente(String ID, String nombre, String direccion, int telefono) throws Exception;

    List<Cliente> consultarClientes();

    void insertarCliente(String ID, String nombre, String direccion, String telefono) throws Exception;

    void borrarCliente(String ID) throws Exception;
    Cliente actualizarCliente(String ID, String nombre, String direccion, int telefono) throws Exception;

    Cliente actualizarCliente(String ID, String nombre, String direccion, String telefono) throws Exception;
}