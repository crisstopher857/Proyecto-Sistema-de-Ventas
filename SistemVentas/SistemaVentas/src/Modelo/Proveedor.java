/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Proveedor {

    private int idProveedor;
    private String nit;
    private String nombre;
    private String telefono;
    private String empresa;

    public Proveedor() {
    }

    public Proveedor(
            int idProveedor,
            String nit,
            String nombre,
            String telefono,
            String empresa) {

        this.idProveedor = idProveedor;
        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.empresa = empresa;
    }

    public Proveedor(
            String nit,
            String nombre,
            String telefono,
            String empresa) {

        this.nit = nit;
        this.nombre = nombre;
        this.telefono = telefono;
        this.empresa = empresa;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
}