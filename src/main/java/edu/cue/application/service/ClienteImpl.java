package edu.cue.application.service;

import edu.cue.domain.Cliente;
import edu.cue.interfaces.ClienteRepository;
import edu.cue.infraestructure.repository.ClienteRepositoryImpl;

import java.util.List;

public abstract class ClienteImpl implements ClienteServicio {
    private final ClienteRepository clienteRepository = new ClienteRepositoryImpl(); // Uso de la interfaz

    @Override
    public Cliente consultarCliente(String ID) throws Exception {
        Cliente cliente = clienteRepository.findById(ID);
        if (cliente == null) {
            throw new Exception("El cliente no existe");
        }
        return cliente;
    }

    @Override
    public void insertarCliente(String ID, String nombre, String direccion, int telefono) throws Exception {
        if (ID.isBlank()) {
            throw new Exception("El ID está vacío");
        }

        if (clienteRepository.findById(ID) != null) {
            throw new Exception("Ya hay un cliente con este ID");
        }

        if (nombre.isBlank()) {
            throw new Exception("El nombre está vacío");
        }

        if (direccion.isBlank()) {
            throw new Exception("Por favor ingresa una dirección");
        }

        Cliente cliente = new Cliente(ID, nombre, direccion, telefono);
        clienteRepository.save(cliente);
    }

    @Override
    public void borrarCliente(String ID) throws Exception {
        if (clienteRepository.findById(ID) == null) {
            throw new Exception("No hay un cliente con ese ID");
        }

        clienteRepository.delete(ID);
    }

    @Override
    public Cliente actualizarCliente(String ID, String nombre, String direccion, String telefono) throws Exception {
        Cliente cliente = clienteRepository.findById(ID);
        if (cliente == null) {
            throw new Exception("El cliente no existe");
        }

        cliente.setNombre(nombre);
        cliente.setDireccion(direccion);
        cliente.setTelefono(Integer.parseInt(telefono));

        return clienteRepository.save(cliente);
    }
}


