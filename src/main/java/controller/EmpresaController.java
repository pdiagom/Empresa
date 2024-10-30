package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class EmpresaController
 */
@WebServlet(description = "Controlador principal que redirige a controladores de empleados y nóminas", urlPatterns = {"/empresa"})
public class EmpresaController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmpresaController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        manejarRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        manejarRequest(request, response);
    }

    private void manejarRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String modulo = request.getParameter("modulo");
        String opcion = request.getParameter("opcion");

        if ("empleados".equals(modulo)) {
            // Redirige al controlador de empleados
            request.getRequestDispatcher("/empleados?opcion=" + opcion).forward(request, response);
        } else if ("nominas".equals(modulo)) {
            // Redirige al controlador de nóminas
            request.getRequestDispatcher("/nominas?opcion=" + opcion).forward(request, response);
        } else {
            // Página de error si el módulo es inválido
            request.setAttribute("errorMessage", "Módulo no válido.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/error.jsp");
            dispatcher.forward(request, response);
        }
    }
}
