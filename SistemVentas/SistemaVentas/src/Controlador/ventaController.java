/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Dao.ventaDAO;
import Modelo.DetalleVenta;
import Modelo.Venta;

import java.util.List;

public class ventaController {

    private ventaDAO dao;

    public ventaController() {
        dao = new ventaDAO();
    }

    public boolean registrarVenta(
            int idCliente,
            double total,
            List<DetalleVenta> detalles) {

        Venta venta = new Venta();

        venta.setIdCliente(idCliente);
        venta.setTotal(total);

        return dao.registrarVenta(venta, detalles);
    }
    public List<Venta> listarVentas() {

    return dao.listarVentas();
}
    public List<Venta> buscarVentas(String texto) {

    return dao.buscarVentas(texto);
}
    public List<DetalleVenta> listarDetalles(int idVenta) {

    return dao.listarDetalles(idVenta);
}
}