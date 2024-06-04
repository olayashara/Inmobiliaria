package com.example.servlets;

import java.io.IOException;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.example.daos.UsuarioDAO;
import com.example.models.Usuario;

@WebServlet("/sesion")
public class IniciarSesionServlet extends HttpServlet {
    private UsuarioDAO usuarioD;

    public IniciarSesionServlet() {
        this.usuarioD = new UsuarioDAO();
    }

    protected void doGet(HttpServletRequest hsr, HttpServletResponse hsr2) throws ServletException, IOException{
        HttpSession sesion = hsr.getSession();
        String id = hsr.getParameter("id");
        String contra = hsr.getParameter("contra");

        if (id != null && contra != null){
            int id1 = Integer.parseInt(id);
            Usuario usuario = usuarioD.seleccionarUsuario(id1, contra);
            
            if(usuario != null){
                sesion.setAttribute("usuarioActual", usuario);
                hsr.getRequestDispatcher("/subasta.jsp").forward(hsr, hsr2);
            }
        } else {
            hsr.getRequestDispatcher("/iniciarSesion.jsp").forward(hsr, hsr2);
        }
        
}
}
