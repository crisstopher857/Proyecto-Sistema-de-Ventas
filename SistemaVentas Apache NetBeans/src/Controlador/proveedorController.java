/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.proveedorDAO;
import Modelo.Proveedor;

import java.util.List;

public class proveedorController {

    private proveedorDAO dao;

    public proveedorController() {
        dao = new proveedorDAO();
    }

    // INSERTAR
    public boolean insertarProveedor(
            String nit,
            String nombre,
            String telefono,
            String empresa) {

        Proveedor proveedor = new Proveedor();

        proveedor.setNit(nit);
        proveedor.setNombre(nombre);
        proveedor.setTelefono(telefono);
        proveedor.setEmpresa(empresa);

        return dao.insertar(proveedor);
    }

    // LISTAR
    public List<Proveedor> listarProveedores() {

        return dao.listar();
    }

    // BUSCAR
    public List<Proveedor> buscarProveedores(String texto) {

        return dao.buscar(texto);
    }

    // ACTUALIZAR
    public boolean actualizarProveedor(
            int id,
            String nit,
            String nombre,
            String telefono,
            String empresa) {

        Proveedor proveedor = new Proveedor();

        proveedor.setIdProveedor(id);
        proveedor.setNit(nit);
        proveedor.setNombre(nombre);
        proveedor.setTelefono(telefono);
        proveedor.setEmpresa(empresa);

        return dao.actualizar(proveedor);
    }

    // ELIMINAR
    public boolean eliminarProveedor(int id) {

        return dao.eliminar(id);
    }
}