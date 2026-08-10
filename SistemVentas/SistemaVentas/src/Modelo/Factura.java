/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {

    private int idFactura;
    private LocalDate fecha;
    private Cliente cliente;
    private List<DetalleFactura> detalles;

    public Factura() {
        detalles = new ArrayList<>();
    }

    public Factura(int idFactura, LocalDate fecha, Cliente cliente) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.cliente = cliente;
        this.detalles = new ArrayList<>();
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public void agregarDetalle(DetalleFactura detalle) {
        detalles.add(detalle);
    }

    public double calcularTotal() {

        double total = 0;

        for (DetalleFactura detalle : detalles) {
            total += detalle.calcularSubtotal();
        }

        return total;
    }
}