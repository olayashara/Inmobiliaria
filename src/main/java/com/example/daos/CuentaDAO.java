package com.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.models.Cuenta;

public class CuentaDAO {

    private String URL_DB = "jdbc:mariadb://localhost:3306/inmobiliaria";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";
    private static final String INSERT_CUENTA_SQL = "INSERT INTO cuentas (id_usuario, saldo) VALUES (?, ?)";
    private static final String SELECT_CUENTA_BY_ID = "SELECT * FROM cuentas WHERE id_cuenta = ?";
    private static final String SELECT_CUENTA_BY_USUARIO_ID = "SELECT * FROM cuentas WHERE id_usuario = ?";
    private static final String UPDATE_SALDO_SQL = "UPDATE cuentas SET saldo = ? WHERE id_cuenta = ?";
    private static final String SELECT_SALDO_BY_ID = "SELECT saldo FROM cuentas WHERE id_cuenta = ?";

    protected Connection conectarBase() {
        Connection conexion = null;
        try {
            // Importante esta línea para que el driver sepa que se va a conectar a una base
            // de datos MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Conectando a la base de datos...");
            // Le pasamos la URL de la base de datos, el usuario y la contraseña para
            // conectarnos a la base de datos
            conexion = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            System.out.println(conexion);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: MariaDB JDBC Driver no encontrado.");
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }

    public void insertarCuenta(Cuenta cuenta) throws SQLException {
        try (Connection conexion = conectarBase();
                PreparedStatement preparedStatement = conexion.prepareStatement(INSERT_CUENTA_SQL)) {
            preparedStatement.setInt(1, cuenta.getIdUsuario());
            preparedStatement.setInt(2, cuenta.getSaldo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en CuentaDAO.insertarCuenta: " + e.getMessage());
        }
    }

    public Cuenta seleccionarCuentaPorId(int idCuenta) {
        Cuenta cuenta = null;
        try (Connection conexion = conectarBase();
                PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_CUENTA_BY_ID)) {
            preparedStatement.setInt(1, idCuenta);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                int saldo = rs.getInt("saldo");
                cuenta = new Cuenta (idUsuario, saldo);
                cuenta.setIdCuenta(idCuenta);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar la cuenta" + e.getMessage());
        }
        return cuenta;
    }

    public Cuenta seleccionarCuentaPorUsuarioId(int idUsuario) {
        Cuenta cuenta = null;
        try (Connection conexion = conectarBase();
                PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_CUENTA_BY_USUARIO_ID)) {
            preparedStatement.setInt(1, idUsuario);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCuenta = rs.getInt("id_cuenta");
                int saldo = rs.getInt("saldo");
                cuenta = new Cuenta(idUsuario, saldo);
                cuenta.setIdCuenta(idCuenta);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar la cuenta" + e.getMessage());
        }
        return cuenta;
    }

    public void actualizarSaldo(int idCuenta, int saldo) throws SQLException {
        try (Connection conexion = conectarBase();
                PreparedStatement preparedStatement = conexion.prepareStatement(UPDATE_SALDO_SQL)) {
            preparedStatement.setInt(1, saldo);
            preparedStatement.setInt(2, idCuenta);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al actualizar saldo" + e.getMessage());
        }
    }

    public void transferirDinero(int idCuentaOrigen, int idCuentaDestino, int monto) throws SQLException {
        Connection conexion = null;
        PreparedStatement actualizarCuentaOrigen = null;
        PreparedStatement actualizarCuentaDestino = null;

        try {
            conexion = conectarBase();
            conexion.setAutoCommit(false);

            // Obtener saldo de la cuenta origen
            int saldoOrigen = obtenerSaldo(conexion, idCuentaOrigen);

            // Obtener saldo de la cuenta destino
            int saldoDestino = obtenerSaldo(conexion, idCuentaDestino);

            // Verificar que haya suficiente dinero en la cuenta origen
            if (saldoOrigen < monto) {
                throw new SQLException("Saldo insuficiente en la cuenta origen.");
            }

            // Actualizar saldos
            actualizarCuentaOrigen = conexion.prepareStatement(UPDATE_SALDO_SQL);
            actualizarCuentaDestino = conexion.prepareStatement(UPDATE_SALDO_SQL);

            actualizarCuentaOrigen.setInt(1, saldoOrigen - monto);
            actualizarCuentaOrigen.setInt(2, idCuentaOrigen);

            actualizarCuentaDestino.setInt(1, saldoDestino + monto);
            actualizarCuentaDestino.setInt(2, idCuentaDestino);

            actualizarCuentaOrigen.executeUpdate();
            actualizarCuentaDestino.executeUpdate();

            conexion.commit();
        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (actualizarCuentaOrigen != null) {
                actualizarCuentaOrigen.close();
            }
            if (actualizarCuentaDestino != null) {
                actualizarCuentaDestino.close();
            }
            if (conexion != null) {
                conexion.setAutoCommit(true);
                conexion.close();
            }
        }
    }

    private int obtenerSaldo(Connection conexion, int idCuenta) throws SQLException {
        try (PreparedStatement preparedStatement = conexion.prepareStatement(SELECT_SALDO_BY_ID)) {
            preparedStatement.setInt(1, idCuenta);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("saldo");
            }
        }
        throw new SQLException("Cuenta no encontrada.");
    }
}