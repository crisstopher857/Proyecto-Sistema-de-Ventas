/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Timestamp;

public class Venta {

    private int idVenta;
    private int idCliente;
    private Timestamp fecha;
    private double total;

    public Venta() {
    }

    public Venta(
            int idVenta,
            int idCliente,
            Timestamp fecha,
            double total) {

        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.total = total;
    }

    public Venta(
            int idCliente,
            double total) {

        this.idCliente = idCliente;
        this.total = total;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}