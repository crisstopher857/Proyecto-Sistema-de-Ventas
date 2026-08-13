/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Configuracion.Conexion;
import Modelo.DetalleVenta;
import Modelo.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;  
import java.util.List;

public class ventaDAO {

    public boolean registrarVenta(
            Venta venta,
            List<DetalleVenta> detalles) {

        Connection conexion = null;

        try {

            conexion = Conexion.conectar();

            conexion.setAutoCommit(false);

            // 1. INSERTAR VENTA
            String sqlVenta =
                    "INSERT INTO ventas "
                    + "(id_cliente, total) "
                    + "VALUES (?, ?) "
                    + "RETURNING id_venta";

            int idVenta;

            try (PreparedStatement ps =
                    conexion.prepareStatement(sqlVenta)) {

                ps.setInt(1, venta.getIdCliente());
                ps.setDouble(2, venta.getTotal());

                ResultSet rs = ps.executeQuery();

                if (!rs.next()) {

                    conexion.rollback();

                    return false;
                }

                idVenta = rs.getInt("id_venta");
            }

            // 2. INSERTAR DETALLES
            String sqlDetalle =
                    "INSERT INTO detalle_venta "
                    + "(id_venta, id_producto, cantidad, precio, subtotal) "
                    + "VALUES (?, ?, ?, ?, ?)";

            // 3. ACTUALIZAR EXISTENCIAS
            String sqlExistencia =
                    "UPDATE productos "
                    + "SET existencia = existencia - ? "
                    + "WHERE id_producto = ? "
                    + "AND existencia >= ?";

            for (DetalleVenta detalle : detalles) {

                try (PreparedStatement ps =
                        conexion.prepareStatement(sqlDetalle)) {

                    ps.setInt(1, idVenta);
                    ps.setInt(2, detalle.getIdProducto());
                    ps.setInt(3, detalle.getCantidad());
                    ps.setDouble(4, detalle.getPrecio());
                    ps.setDouble(5, detalle.getSubtotal());

                    ps.executeUpdate();
                }

                try (PreparedStatement ps =
                        conexion.prepareStatement(sqlExistencia)) {

                    ps.setInt(1, detalle.getCantidad());
                    ps.setInt(2, detalle.getIdProducto());
                    ps.setInt(3, detalle.getCantidad());

                    int filas =
                            ps.executeUpdate();

                    if (filas == 0) {

                        conexion.rollback();

                        return false;
                    }
                }
            }

            conexion.commit();

            return true;

        } catch (SQLException e) {

            if (conexion != null) {

                try {
                    conexion.rollback();

                } catch (SQLException ex) {

                    System.out.println(
                            "Error en rollback: "
                            + ex.getMessage()
                    );
                }
            }

            System.out.println(
                    "Error al registrar venta: "
                    + e.getMessage()
            );

            return false;

        } finally {

            if (conexion != null) {

                try {

                    conexion.setAutoCommit(true);
                    conexion.close();

                } catch (SQLException e) {

                    System.out.println(
                            "Error al cerrar conexión: "
                            + e.getMessage()
                    );
                }
            }
        }
    }
    public List<Venta> listarVentas() {

    List<Venta> ventas = new ArrayList<>();

    String sql =
            "SELECT id_venta, id_cliente, fecha, total "
            + "FROM ventas "
            + "ORDER BY id_venta DESC";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement ps =
                 conexion.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Venta venta = new Venta();

            venta.setIdVenta(
                    rs.getInt("id_venta")
            );

            venta.setIdCliente(
                    rs.getInt("id_cliente")
            );

            venta.setFecha(
                    rs.getTimestamp("fecha")
            );

            venta.setTotal(
                    rs.getDouble("total")
            );

            ventas.add(venta);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al listar ventas: "
                + e.getMessage()
        );
    }

    return ventas;
}
    public List<Venta> buscarVentas(String texto) {

    List<Venta> ventas = new ArrayList<>();

    String sql =
            "SELECT v.id_venta, v.id_cliente, "
            + "v.fecha, v.total "
            + "FROM ventas v "
            + "INNER JOIN clientes c "
            + "ON v.id_cliente = c.id_cliente "
            + "WHERE CAST(v.id_venta AS TEXT) ILIKE ? "
            + "OR c.nombre ILIKE ? "
            + "OR c.nit ILIKE ? "
            + "ORDER BY v.id_venta DESC";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement ps =
                 conexion.prepareStatement(sql)) {

        String busqueda = "%" + texto + "%";

        ps.setString(1, busqueda);
        ps.setString(2, busqueda);
        ps.setString(3, busqueda);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Venta venta = new Venta();

            venta.setIdVenta(
                    rs.getInt("id_venta")
            );

            venta.setIdCliente(
                    rs.getInt("id_cliente")
            );

            venta.setFecha(
                    rs.getTimestamp("fecha")
            );

            venta.setTotal(
                    rs.getDouble("total")
            );

            ventas.add(venta);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar ventas: "
                + e.getMessage()
        );
    }

    return ventas;
}
    public List<DetalleVenta> listarDetalles(int idVenta) {

    List<DetalleVenta> detalles = new ArrayList<>();

    String sql =
            "SELECT id_detalle, id_venta, id_producto, "
            + "cantidad, precio, subtotal "
            + "FROM detalle_venta "
            + "WHERE id_venta = ? "
            + "ORDER BY id_detalle";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement ps =
                 conexion.prepareStatement(sql)) {

        ps.setInt(1, idVenta);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            DetalleVenta detalle =
                    new DetalleVenta();

            detalle.setIdDetalle(
                    rs.getInt("id_detalle")
            );

            detalle.setIdVenta(
                    rs.getInt("id_venta")
            );

            detalle.setIdProducto(
                    rs.getInt("id_producto")
            );

            detalle.setCantidad(
                    rs.getInt("cantidad")
            );

            detalle.setPrecio(
                    rs.getDouble("precio")
            );

            detalle.setSubtotal(
                    rs.getDouble("subtotal")
            );

            detalles.add(detalle);
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al listar detalles: "
                + e.getMessage()
        );
    }

    return detalles;
}
    public Venta buscarVentaPorId(int idVenta) {

    Venta venta = null;

    String sql =
            "SELECT id_venta, id_cliente, fecha, total "
            + "FROM ventas "
            + "WHERE id_venta = ?";

    try (Connection conexion = Conexion.conectar();
         PreparedStatement ps =
                 conexion.prepareStatement(sql)) {

        ps.setInt(1, idVenta);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {

            venta = new Venta();

            venta.setIdVenta(
                    rs.getInt("id_venta")
            );

            venta.setIdCliente(
                    rs.getInt("id_cliente")
            );

            venta.setFecha(
                    rs.getTimestamp("fecha")
            );

            venta.setTotal(
                    rs.getDouble("total")
            );
        }

    } catch (SQLException e) {

        System.out.println(
                "Error al buscar venta: "
                + e.getMessage()
        );
    }

    return venta;
}
    
}