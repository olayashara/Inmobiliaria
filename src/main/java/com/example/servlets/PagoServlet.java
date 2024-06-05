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

@WebServlet("/pago") 
public class PagoServlet extends HttpServlet{
    private UsuarioDAO usuarioD;

    public PagoServlet() {
        this.usuarioD = new UsuarioDAO();
    }
    protected void doPost(HttpServletRequest hsr, HttpServletResponse hsr2) throws ServletException, IOException{
        HttpSession sesion = hsr.getSession();
        double pago = Double.parseDouble(hsr.getParameter("pago"));
        Usuario usuario = (Usuario) sesion.getAttribute("usuarioActual");

        usuarioD.insertarPago(usuario, pago);
        hsr2.sendRedirect("pago2.jsp");
    }
}
