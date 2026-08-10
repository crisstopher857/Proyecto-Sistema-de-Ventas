/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.productoDAO;
import Modelo.Producto;

import java.util.List;

public class ProductoController {

    private productoDAO productoDAO;

    public ProductoController() {

        productoDAO = new productoDAO();
    }

    public boolean guardarProducto(Producto producto) {

        return productoDAO.insertar(producto);
    }

    public List<Producto> listarProductos() {

        return productoDAO.listar();
    }

    public boolean modificarProducto(Producto producto) {

        return productoDAO.actualizar(producto);
    }

    public boolean eliminarProducto(int idProducto) {

        return productoDAO.eliminar(idProducto);
    }
    public List<Producto> buscarProductos(String texto) {

    return productoDAO.buscar(texto);
}
    
}
