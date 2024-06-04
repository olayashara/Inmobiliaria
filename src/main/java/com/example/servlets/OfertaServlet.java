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

@WebServlet("/oferta") 
public class OfertaServlet extends HttpServlet{
    private UsuarioDAO usuarioD;

    public OfertaServlet() {
        this.usuarioD = new UsuarioDAO();
    }
    protected void doPost(HttpServletRequest hsr, HttpServletResponse hsr2) throws ServletException, IOException{
        HttpSession sesion = hsr.getSession();
        double oferta = Double.parseDouble(hsr.getParameter("oferta"));
        Usuario usuario = (Usuario) sesion.getAttribute("usuarioActual");

        usuarioD.insertarOferta(usuario, oferta);
        hsr2.sendRedirect("oferta2.jsp");
    }
}
