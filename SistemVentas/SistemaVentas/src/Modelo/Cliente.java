/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Cliente {

    private int idCliente;
    private String nit;
    private String nombre;
    private String telefono;

    public Cliente() {
    }

    public Cliente(int idCliente, String nit, String nombre, String telefono) {
        this.idCliente = idCliente;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Cliente(String nit, String nombre, String telefono) {
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}