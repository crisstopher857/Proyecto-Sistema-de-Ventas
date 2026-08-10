/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Configuracion.Conexion;
import Modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // INSERTAR CLIENTE
    public boolean insertar(Cliente cliente) {

        String sql = "INSERT INTO clientes "
                + "(nit, nombre, telefono) "
                + "VALUES (?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al insertar cliente: "
                    + e.getMessage());

            return false;
        }
    }

    // LISTAR CLIENTES
    public List<Cliente> listar() {

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT id_cliente, nit, nombre, telefono "
                + "FROM clientes "
                + "ORDER BY id_cliente";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(
                        rs.getInt("id_cliente")
                );

                cliente.setNit(
                        rs.getString("nit")
                );

                cliente.setNombre(
                        rs.getString("nombre")
                );

                cliente.setTelefono(
                        rs.getString("telefono")
                );

                clientes.add(cliente);
            }

        } catch (SQLException e) {

            System.out.println("Error al listar clientes: "
                    + e.getMessage());
        }

        return clientes;
    }

    // BUSCAR CLIENTES
    public List<Cliente> buscar(String texto) {

        List<Cliente> clientes = new ArrayList<>();

        String sql = "SELECT id_cliente, nit, nombre, telefono "
                + "FROM clientes "
                + "WHERE CAST(id_cliente AS TEXT) ILIKE ? "
                + "OR nit ILIKE ? "
                + "OR nombre ILIKE ? "
                + "OR telefono ILIKE ? "
                + "ORDER BY id_cliente";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            String busqueda = "%" + texto + "%";

            ps.setString(1, busqueda);
            ps.setString(2, busqueda);
            ps.setString(3, busqueda);
            ps.setString(4, busqueda);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setIdCliente(
                        rs.getInt("id_cliente")
                );

                cliente.setNit(
                        rs.getString("nit")
                );

                cliente.setNombre(
                        rs.getString("nombre")
                );

                cliente.setTelefono(
                        rs.getString("telefono")
                );

                clientes.add(cliente);
            }

        } catch (SQLException e) {

            System.out.println("Error al buscar clientes: "
                    + e.getMessage());
        }

        return clientes;
    }

    // ACTUALIZAR CLIENTE
    public boolean actualizar(Cliente cliente) {

        String sql = "UPDATE clientes SET "
                + "nit = ?, "
                + "nombre = ?, "
                + "telefono = ? "
                + "WHERE id_cliente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, cliente.getNit());
            ps.setString(2, cliente.getNombre());
            ps.setString(3, cliente.getTelefono());
            ps.setInt(4, cliente.getIdCliente());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al actualizar cliente: "
                    + e.getMessage());

            return false;
        }
    }

    // ELIMINAR CLIENTE
    public boolean eliminar(int idCliente) {

        String sql = "DELETE FROM clientes "
                + "WHERE id_cliente = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println("Error al eliminar cliente: "
                    + e.getMessage());

            return false;
        }
    }
}  