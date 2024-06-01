package com.example.servlets;

import java.io.IOException;

import com.example.daos.ClienteDAO;
import com.example.models.Cliente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registro") 
public class RegistroServlet extends HttpServlet{
    private ClienteDAO clienteD;

    public RegistroServlet() {
        this.clienteD = new ClienteDAO();
    }
    protected void doPost(HttpServletRequest hsr, HttpServletResponse hsr2) throws ServletException, IOException{
        String nombre = hsr.getParameter("nombre");
        String apellido = hsr.getParameter("apellido");
        int identificacion = Integer.parseInt(hsr.getParameter("identificacion"));
        Cliente Obj = new Cliente(nombre, apellido, identificacion);

        clienteD.insertarUsuario(Obj);
        hsr2.sendRedirect("redireccion.jsp");
    }
}
