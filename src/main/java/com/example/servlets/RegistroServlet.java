package com.example.servlets;

import java.io.IOException;

import com.example.daos.UsuarioDAO;
import com.example.models.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registro") 
public class RegistroServlet extends HttpServlet{
    private UsuarioDAO clienteD;

    public RegistroServlet() {
        this.clienteD = new UsuarioDAO();
    }
    protected void doPost(HttpServletRequest hsr, HttpServletResponse hsr2) throws ServletException, IOException{
        String nombre = hsr.getParameter("nombre");
        String apellido = hsr.getParameter("apellido");
        int identificacion = Integer.parseInt(hsr.getParameter("identificacion"));
        String contraseña = hsr.getParameter("contraseña");
        Usuario Obj = new Usuario(nombre, apellido, identificacion, contraseña);

        clienteD.insertarUsuario(Obj);
        hsr2.sendRedirect("redireccion.jsp");
    }
}
