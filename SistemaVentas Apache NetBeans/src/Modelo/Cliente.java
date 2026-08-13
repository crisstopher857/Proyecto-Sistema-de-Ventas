/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Cliente extends Persona {

    private String direccion;

    public Cliente() {
        super();
    }

    public Cliente(int id, String nombre, String nit,
                   String telefono, String direccion) {

        super(id, nombre, nit, telefono);
        this.direccion = direccion;
    }

    public Cliente(String nit, String nombre, String telefono) {

        super(0, nombre, nit, telefono);
    }

    public int getIdCliente() {
        return getId();
    }

    public void setIdCliente(int idCliente) {
        setId(idCliente);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}