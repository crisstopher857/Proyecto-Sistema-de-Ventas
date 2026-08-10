/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Configuracion.Conexion;
import Modelo.Producto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class productoDAO {

    // INSERTAR PRODUCTO
    public boolean insertar(Producto producto) {

        String sql = "INSERT INTO productos "
                + "(nombre, precio, existencia) "
                + "VALUES (?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getExistencia());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al insertar producto: "
                    + e.getMessage());

            return false;
        }
    }


    // LISTAR PRODUCTOS
    public List<Producto> listar() {

        List<Producto> productos = new ArrayList<>();

        String sql = "SELECT id_producto, nombre, precio, existencia "
                + "FROM productos "
                + "ORDER BY id_producto";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Producto producto = new Producto();

                producto.setIdProducto(
                        rs.getInt("id_producto")
                );

                producto.setNombre(
                        rs.getString("nombre")
                );

                producto.setPrecio(
                        rs.getDouble("precio")
                );

                producto.setExistencia(
                        rs.getInt("existencia")
                );

                productos.add(producto);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar productos: "
                    + e.getMessage());
        }

        return productos;
    }
    public List<Producto> buscar(String texto) {

    List<Producto> productos = new ArrayList<>();

    String sql = "SELECT id_producto, nombre, precio, existencia "
            + "FROM productos "
            + "WHERE CAST(id_producto AS TEXT) ILIKE ? "
            + "OR nombre ILIKE ? "
            + "ORDER BY id_producto";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement ps = conexion.prepareStatement(sql)) {

        String busqueda = "%" + texto + "%";

        ps.setString(1, busqueda);
        ps.setString(2, busqueda);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Producto producto = new Producto();

            producto.setIdProducto(
                    rs.getInt("id_producto")
            );

            producto.setNombre(
                    rs.getString("nombre")
            );

            producto.setPrecio(
                    rs.getDouble("precio")
            );

            producto.setExistencia(
                    rs.getInt("existencia")
            );

            productos.add(producto);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar productos: "
                + e.getMessage()
        );
    }

    return productos;
} 


    // ACTUALIZAR PRODUCTO
    public boolean actualizar(Producto producto) {

        String sql = "UPDATE productos SET "
                + "nombre = ?, "
                + "precio = ?, "
                + "existencia = ? "
                + "WHERE id_producto = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getExistencia());
            ps.setInt(4, producto.getIdProducto());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al actualizar producto: "
                    + e.getMessage());

            return false;
        }
    }


    // ELIMINAR PRODUCTO
    public boolean eliminar(int idProducto) {

        String sql = "DELETE FROM productos "
                + "WHERE id_producto = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idProducto);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al eliminar producto: "
                    + e.getMessage());

            return false;
        }
    }
}