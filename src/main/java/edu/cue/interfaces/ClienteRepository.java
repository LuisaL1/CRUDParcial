package edu.cue.interfaces;

import edu.cue.domain.Cliente;

import java.util.List;

public interface ClienteRepository {
    List<Cliente> findAll();
    Cliente findById(String id);
    Cliente save(Cliente producto);
    void delete(String id);
}
