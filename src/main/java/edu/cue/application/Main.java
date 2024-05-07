package edu.cue.application;

import edu.cue.application.service.ClienteImpl;
import edu.cue.domain.Cliente;

import java.util.List;
import java.util.Scanner;

public class Main { // Encapsulando el main en una clase

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteImpl clienteService = new ClienteImpl();

        while (true) {
            System.out.println("\n--- Menú de Gestión de Clientes ---");
            System.out.println("1. Consultar todos los clientes");
            System.out.println("2. Insertar un nuevo cliente");
            System.out.println("3. Borrar un cliente");
            System.out.println("4. Actualizar un cliente");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();  // Consume newline left-over

            switch (option) {
                case 1:
                    List<Cliente> clientes = clienteService.consultarClientes();
                    assert clientes != null;
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados.");
                    } else {
                        clientes.forEach(cliente -> System.out.println(cliente.ID+" "+cliente.getNombre()+" "+cliente.getDireccion()+" "+cliente.getTelefono()));
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Ingrese ID del cliente: ");
                        String id = scanner.nextLine();
                        System.out.print("Ingrese nombre del cliente: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese dirección del cliente: ");
                        String direccion = scanner.nextLine();
                        System.out.print("Ingrese teléfono del cliente: ");
                        String telefono = scanner.nextLine();
                        clienteService.insertarCliente(id, nombre, direccion, telefono);
                        System.out.println("Cliente insertado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al insertar el cliente: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Ingrese ID del cliente a borrar: ");
                        String deleteId = scanner.nextLine();
                        clienteService.borrarCliente(deleteId);
                        System.out.println("Cliente borrado correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al borrar el cliente: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Ingrese ID del cliente a actualizar: ");
                        String updateId = scanner.nextLine();
                        System.out.print("Ingrese nuevo nombre del cliente: ");
                        String updateNombre = scanner.nextLine();
                        System.out.print("Ingrese nueva dirección del cliente: ");
                        String updateDireccion = scanner.nextLine();
                        System.out.print("Ingrese nuevo teléfono del cliente: ");
                        String updateTelefono = scanner.nextLine();
                        Cliente updatedCliente = clienteService.actualizarCliente(updateId, updateNombre, updateDireccion, updateTelefono);
                        System.out.println("Cliente actualizado: " + updatedCliente);
                    } catch (Exception e) {
                        System.out.println("Error al actualizar el cliente: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
                    break;
            }
        }
    }
}
