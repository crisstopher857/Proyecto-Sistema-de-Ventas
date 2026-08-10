/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Configuracion.Conexion;
import Modelo.Proveedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class proveedorDAO {

    // INSERTAR PROVEEDOR
    public boolean insertar(Proveedor proveedor) {

        String sql = "INSERT INTO proveedores "
                + "(nit, nombre, telefono, empresa) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, proveedor.getNit());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getEmpresa());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al insertar proveedor: "
                    + e.getMessage());

            return false;
        }
    }

    // LISTAR PROVEEDORES
    public List<Proveedor> listar() {

        List<Proveedor> proveedores = new ArrayList<>();

        String sql = "SELECT id_proveedor, nit, nombre, telefono, empresa "
                + "FROM proveedores "
                + "ORDER BY id_proveedor";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Proveedor proveedor = new Proveedor();

                proveedor.setIdProveedor(
                        rs.getInt("id_proveedor")
                );

                proveedor.setNit(
                        rs.getString("nit")
                );

                proveedor.setNombre(
                        rs.getString("nombre")
                );

                proveedor.setTelefono(
                        rs.getString("telefono")
                );

                proveedor.setEmpresa(
                        rs.getString("empresa")
                );

                proveedores.add(proveedor);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar proveedores: "
                    + e.getMessage());
        }

        return proveedores;
    }

    // BUSCAR PROVEEDORES
    public List<Proveedor> buscar(String texto) {

        List<Proveedor> proveedores = new ArrayList<>();

        String sql = "SELECT id_proveedor, nit, nombre, telefono, empresa "
                + "FROM proveedores "
                + "WHERE CAST(id_proveedor AS TEXT) ILIKE ? "
                + "OR nit ILIKE ? "
                + "OR nombre ILIKE ? "
                + "OR telefono ILIKE ? "
                + "OR empresa ILIKE ? "
                + "ORDER BY id_proveedor";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            String busqueda = "%" + texto + "%";

            ps.setString(1, busqueda);
            ps.setString(2, busqueda);
            ps.setString(3, busqueda);
            ps.setString(4, busqueda);
            ps.setString(5, busqueda);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Proveedor proveedor = new Proveedor();

                proveedor.setIdProveedor(
                        rs.getInt("id_proveedor")
                );

                proveedor.setNit(
                        rs.getString("nit")
                );

                proveedor.setNombre(
                        rs.getString("nombre")
                );

                proveedor.setTelefono(
                        rs.getString("telefono")
                );

                proveedor.setEmpresa(
                        rs.getString("empresa")
                );

                proveedores.add(proveedor);
            }

        } catch (SQLException e) {

            System.out.println("Error al buscar proveedores: "
                    + e.getMessage());
        }

        return proveedores;
    }

    // ACTUALIZAR PROVEEDOR
    public boolean actualizar(Proveedor proveedor) {

        String sql = "UPDATE proveedores SET "
                + "nit = ?, "
                + "nombre = ?, "
                + "telefono = ?, "
                + "empresa = ? "
                + "WHERE id_proveedor = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, proveedor.getNit());
            ps.setString(2, proveedor.getNombre());
            ps.setString(3, proveedor.getTelefono());
            ps.setString(4, proveedor.getEmpresa());
            ps.setInt(5, proveedor.getIdProveedor());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al actualizar proveedor: "
                    + e.getMessage());

            return false;
        }
    }

    // ELIMINAR PROVEEDOR
    public boolean eliminar(int idProveedor) {

        String sql = "DELETE FROM proveedores "
                + "WHERE id_proveedor = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idProveedor);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al eliminar proveedor: "
                    + e.getMessage());

            return false;
        }
    }
}