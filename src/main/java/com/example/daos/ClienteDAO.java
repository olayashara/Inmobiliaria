package com.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Cliente;

public class ClienteDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/inmobiliaria";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";
    private static final String insertar_usuario = "insert into cliente (nombre, apellido, identificacion) values (?,?,?)";
    private static final String seleccionar_todos = "select * from cliente";
    private static final String seleccionar_por_identificacion = "select * from cliente where identificacion=?";

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

    public void insertarUsuario(Cliente nuevocliente) {
        try (Connection conexion = conectarBase(); PreparedStatement PS = conexion.prepareStatement(insertar_usuario)) {
            PS.setString(1, nuevocliente.getNombre());
            PS.setString(2, nuevocliente.getApellido());
            PS.setInt(3, nuevocliente.getIdentificacion());
            PS.executeUpdate();
        } catch (SQLException e)

        {
            System.out.println("Si este método falla, no se pudo crear un usuario" + e.getMessage());
            // TODO: handle exception
        }

    }

    public Cliente seleccionarUsuario(int identificacion) {
        Cliente cliente = new Cliente();
        try (Connection conexion = conectarBase(); PreparedStatement PS = conexion.prepareStatement(seleccionar_por_identificacion)) {
            PS.setInt(1, identificacion);
            ResultSet RS = PS.executeQuery();
            if (RS.next()){
                cliente.setNombre(RS.getString("nombre"));
                cliente.setApellido(RS.getString("apellido"));
                cliente.setIdentificacion(RS.getInt("identificacion"));
            }
        } catch (SQLException e)

        {
            System.out.println("Si este método falla, no se pudo seleccionar el usuario" + e.getMessage());
            // TODO: handle exception
        }
        return cliente;
    }
    public List<Cliente> seleccionar_todos(){
        List<Cliente> lista = new ArrayList<>();

        return lista;
    }
}