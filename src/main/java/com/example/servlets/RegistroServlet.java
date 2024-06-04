package com.example.servlets;

import java.io.IOException;

import com.example.daos.UsuarioDAO;
import com.example.models.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registro") 
public class RegistroServlet extends HttpServlet{
    private UsuarioDAO usuarioD;

    public RegistroServlet() {
        this.usuarioD = new UsuarioDAO();
    }
    protected void doPost(HttpServletRequest hsr, HttpServletResponse hsr2) throws ServletException, IOException{
        
        String nombre = hsr.getParameter("nombre");
        String apellido = hsr.getParameter("apellido");
        int identificacion = Integer.parseInt(hsr.getParameter("identificacion"));
        String contrasena = hsr.getParameter("contrasena");
        Usuario Obj = new Usuario(nombre, apellido, identificacion, contrasena);
        

        usuarioD.insertarUsuario(Obj);
        hsr2.sendRedirect("redireccion.jsp");
    }
}
