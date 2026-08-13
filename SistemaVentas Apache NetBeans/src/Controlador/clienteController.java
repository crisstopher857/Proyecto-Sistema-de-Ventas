/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.ClienteDAO;
import Modelo.Cliente;

import java.util.List;

public class clienteController {

    private ClienteDAO Dao;

    public clienteController() {
        Dao = new ClienteDAO();
    }

    // INSERTAR
    public boolean insertarCliente(String nit, String nombre, String telefono) {

        Cliente cliente = new Cliente();

        cliente.setNit(nit);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);

        return Dao.insertar(cliente);
    }

    // LISTAR
    public List<Cliente> listarClientes() {

        return Dao.listar();
    }

    // BUSCAR
    public List<Cliente> buscarClientes(String texto) {

        return Dao.buscar(texto);
    }

    // ACTUALIZAR
    public boolean actualizarCliente(
            int id,
            String nit,
            String nombre,
            String telefono) {

        Cliente cliente = new Cliente();

        cliente.setIdCliente(id);
        cliente.setNit(nit);
        cliente.setNombre(nombre);
        cliente.setTelefono(telefono);

        return Dao.actualizar(cliente);
    }

    // ELIMINAR
    public boolean eliminarCliente(int id) {

        return Dao.eliminar(id);
    }
}