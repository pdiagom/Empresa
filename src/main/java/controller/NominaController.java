package controller;

import dao.NominaDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(description = "Administra peticiones para la tabla nominas", urlPatterns = {"/nominas"})
public class NominaController extends HttpServlet {
    private NominaDAO nominaDAO = new NominaDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");

        if ("buscarSueldo".equals(opcion)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/buscarSueldo.jsp");
            dispatcher.forward(request, response);
        } else if ("consultarSueldo".equals(opcion)) {
            String dni = request.getParameter("dni");

            if (dni != null && !dni.isEmpty()) {
                try {
                    // Verifica si el empleado existe
                    if (nominaDAO.empleadoExiste(dni)) {
                        double sueldo = nominaDAO.obtenerSueldo(dni);
                        if (sueldo > 0) {
                            request.setAttribute("sueldo", sueldo);
                        } else {
                            request.setAttribute("error", "No se encontró el sueldo para el DNI proporcionado.");
                        }
                    } else {
                        request.setAttribute("error", "El DNI proporcionado no existe.");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    request.setAttribute("error", "Error al consultar el sueldo.");
                }
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/mostrarSueldo.jsp");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("error", "Por favor, ingrese un DNI válido.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/views/buscarSueldo.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            response.sendRedirect("../index.jsp"); // Redirige si la opción es inválida
        }
    }
}
