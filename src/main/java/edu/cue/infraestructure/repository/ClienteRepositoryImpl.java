package edu.cue.infraestructure.repository;

import edu.cue.domain.Cliente;
import edu.cue.interfaces.ClienteRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteRepositoryImpl implements ClienteRepository {
    private static final String RUTA_ARCHIVO = "src/main/resources/archivoClientes.dat";

    @Override
    public List<Cliente> findAll() {
        File file = new File(RUTA_ARCHIVO);
        if (!file.exists()) return new ArrayList<>();  // Si el archivo no existe, retorna una lista vacía.

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Cliente>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Cliente findById(String id) {
        return findAll().stream()
                .filter(c -> c.getID().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente) {
        List<Cliente> clientes = findAll();

        int index = clientes.indexOf(cliente);
        if (index != -1) {
            clientes.set(index, cliente);
        } else {
            clientes.add(cliente);
        }
        saveAll(clientes);
        return cliente;
    }

    @Override
    public void delete(String id) {
        List<Cliente> clientes = findAll();
        clientes = clientes.stream()
                .filter(p -> !p.getID().equals(id))
                .collect(Collectors.toList());
        saveAll(clientes);
    }

    private void saveAll(List<Cliente> clientes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            oos.writeObject(clientes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





