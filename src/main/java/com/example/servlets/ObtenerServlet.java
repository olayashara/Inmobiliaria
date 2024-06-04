package com.example.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.example.daos.UsuarioDAO;
import com.example.models.Usuario;

@WebServlet("/lista-usuarios")
public class ObtenerServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    String cedulaParametro = request.getParameter("identificacion");

    String orden = request.getParameter("orden");

    List<Usuario> usuarios = new ArrayList<>();

    if (cedulaParametro != null && !cedulaParametro.isEmpty()) {
      // Si se proporcionó, mostrar solo el usuario con esa cédula
      int identificacion = Integer.parseInt(cedulaParametro);
      Usuario usuario = usuarioDAO.seleccionarUsuario(identificacion);

      // Pasar el usuario al archivo JSP
      request.setAttribute("usuarios", Collections.singletonList(usuario));
    } else {
      usuarios = usuarioDAO.seleccionarTodosUsuarios();

      // Imprimir en consola la lista de usuarios, utiliza método toString()
      // implicitamente.
      System.out.println(usuarios);
      // Pasar la lista de usuarios al archivo JSP
      request.setAttribute("usuarios", usuarios);
    }

    if ("alfabetico".equals(orden)) {
      usuarios.sort(Comparator.comparing(Usuario::getNombre));
      request.setAttribute("usuarios", usuarios);
    }

    request.getRequestDispatcher("/lista-usuarios.jsp").forward(request, response);
  }
  
}