package com.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Usuario;

public class UsuarioDAO {
    private String URL_DB = "jdbc:mariadb://localhost:3306/inmobiliaria";
    private String USER_DB = "root";
    private String PASSWORD_DB = "root";
    private static final String insertar_usuario = "insert into usuario (nombre, apellido, identificacion, contrasena) values (?,?,?,?)";
    private static final String seleccionar_todos = "select * from usuario";
    private static final String seleccionar_por_identificacion = "select * FROM usuario WHERE identificacion=? AND contrasena = ? ";
    private static final String eliminar_usuario = "DELETE FROM usuarios WHERE cedula = ?";
    private static final String insertar_oferta = "insert into ofertas (usuario, oferta) values (?,?)";
    private static final String insertar_pago = "insert into pagos (nombre, apellido, contrasena, referencia, identificacion) values (?,?,?,?,?)";
    
    protected Connection conectarBase() {
        Connection conexion = null;
        try {
            // Importante esta línea para que el driver sepa que se va a conectar a una base
            // de datos MariaDB
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Conectando a la base de datos...");
            // Le pasamos la URL de la base de datos, el usuario y la contrasena para
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

    public void insertarUsuario(Usuario nuevousuario) {
        try (Connection conexion = conectarBase(); PreparedStatement PS = conexion.prepareStatement(insertar_usuario)) {
            PS.setString(1, nuevousuario.getNombre());
            PS.setString(2, nuevousuario.getApellido());
            PS.setInt(3, nuevousuario.getIdentificacion());
            PS.setString(4, nuevousuario.getContrasena());
            PS.executeUpdate();
        } catch (SQLException e)

        {
            System.out.println("Si este método falla, no se pudo crear un usuario" + e.getMessage());
            // TODO: handle exception
        }

    }

    public void insertarOferta(Usuario usuario, double oferta) {
        try (Connection conexion = conectarBase(); PreparedStatement PS = conexion.prepareStatement(insertar_oferta)) {
            PS.setInt(1, usuario.getConsecutivo());
            PS.setDouble(2, oferta);
            PS.executeUpdate();
        } catch (SQLException e)

        {
            System.out.println("Si este método falla, no se pudo insertar la oferta" + e.getMessage());
            // TODO: handle exception
        }

    }

    public void insertarPago(Usuario usuario, double pago) {
        try (Connection conexion = conectarBase(); PreparedStatement PS = conexion.prepareStatement(insertar_pago)) {
            PS.setInt(1, usuario.getConsecutivo());
            PS.setDouble(2, pago);
            PS.executeUpdate();
        } catch (SQLException e)

        {
            System.out.println("Si este método falla, no se pudo insertar el pago" + e.getMessage());
            // TODO: handle exception
        }

    }
    public Usuario seleccionarUsuario(int identificacion, String contrasena) {
        Usuario usuario = new Usuario();
        try (Connection conexion = conectarBase();
                PreparedStatement PS = conexion.prepareStatement(seleccionar_por_identificacion)) {
            PS.setInt(1, identificacion);
            PS.setString(2, contrasena);
            ResultSet RS = PS.executeQuery();
            if (RS.next()) {
                usuario.setNombre(RS.getString("nombre"));
                usuario.setApellido(RS.getString("apellido"));
                usuario.setIdentificacion(RS.getInt("identificacion"));
                usuario.setConsecutivo(RS.getInt("consecutivo"));
            }
        } catch (SQLException e)

        {
            System.out.println("Si este método falla, no se pudo seleccionar el usuario" + e.getMessage());
            // TODO: handle exception
        }
        return usuario;
    }

    public List<Usuario> seleccionarTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (Connection conexion = conectarBase();
                PreparedStatement PS = conexion.prepareStatement(seleccionar_todos)) {
            ResultSet RS = PS.executeQuery();
            while (RS.next()) {
                Usuario usuario = new Usuario();
                usuario.setNombre(RS.getString("nombre"));
                usuario.setApellido(RS.getString("apellido"));
                usuario.setIdentificacion(RS.getInt("identificacion"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar todos los usuarios: " + e.getMessage());
        }
        return usuarios;
    }

    public void eliminarUsuarioPorCedula(int cedula) {
        try (Connection conexion = conectarBase();
                PreparedStatement PS = conexion.prepareStatement(eliminar_usuario)) {
            PS.setInt(1, cedula);
            PS.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar un usuario por cédula: " + e.getMessage());
        }
    }
}