package controller;

import dao.EmpleadoDAO;
import model.Empleado;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class EmpleadoController
 */
@WebServlet(description = "Administra peticiones para la tabla empleados", urlPatterns = {"/empleados"})
public class EmpleadoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub


        String opcion = request.getParameter("opcion");

        if (opcion.equals("crear")) {
            System.out.println("Usted a presionado la opcion crear");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/crear.jsp");
            requestDispatcher.forward(request, response);
        } else if(opcion.equals("filtrar")) {
            System.out.println("Usted a presionado la opcion filtrar");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarEmpleados.jsp");
            requestDispatcher.forward(request, response);
        }else if (opcion.equals("listar")) {

            EmpleadoDAO empleadoDao = new EmpleadoDAO();
            List<Empleado> lista = new ArrayList<>();
            try {
                lista = empleadoDao.obtenerEmpleados();
                for (Empleado empleado : lista) {
                    empleado.imprime();
                }
                request.setAttribute("lista", lista);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/listar.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                request.setAttribute("errorMessage","Fallo en la base de datos");
                requestDispatcher.forward(request, response);
                e.printStackTrace();
            }

            System.out.println("Usted a presionado la opcion listar");
        } else if (opcion.equals("meditar")) {
            String dni = request.getParameter("dni");
            System.out.println("Editar dni: " + dni);
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            Empleado empleado = new Empleado();
            try {
                empleado = empleadoDAO.obtenerEmpleado(dni);
                empleado.imprime();
                request.setAttribute("empleado", empleado);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/editar.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                request.setAttribute("errorMessage", "Fallo en la base de datos");
                requestDispatcher.forward(request, response);
                e.printStackTrace();
            }

        } else if (opcion.equals("eliminar")) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            String dni = request.getParameter("dni");
            System.out.println(request.getParameter("dni"));
            try {
                empleadoDAO.eliminar(dni);
                System.out.println("Registro eliminado satisfactoriamente...");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                request.setAttribute("errorMessage", "Fallo en la base de datos");
                requestDispatcher.forward(request, response);
                e.printStackTrace();
            }

        }
        // response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String opcion = request.getParameter("opcion");

        if (opcion.equals("guardar")) {
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();
            Empleado empleado = new Empleado();
            empleado.setDni(request.getParameter("dni"));
            empleado.setNombre(request.getParameter("nombre"));
            empleado.setSexo(request.getParameter("sexo"));
            if(request.getParameter("categoria").isEmpty()){
                empleado.setCategoria(1);
            }else {
                empleado.setCategoria(Integer.parseInt(request.getParameter("categoria")));
            }
            if(request.getParameter("anyos").isEmpty()){
                empleado.setAnyos(0);
            }else {
                empleado.setAnyos(Integer.parseInt(request.getParameter("anyos")));
            }
            empleado.imprime();
            try {
                empleadoDAO.guardar(empleado);
                System.out.println("Registro guardado satisfactoriamente...");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request, response);

            } catch (SQLException e) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                request.setAttribute("errorMessage", "Fallo en la base de datos");
                requestDispatcher.forward(request, response);
                e.printStackTrace();
            }
        } else if (opcion.equals("editar")) {
            Empleado empleado = new Empleado();
            EmpleadoDAO empleadoDAO = new EmpleadoDAO();

            empleado.setDni(request.getParameter("dni"));
            empleado.setNombre(request.getParameter("nombre"));
            empleado.setSexo(request.getParameter("sexo"));

            if(request.getParameter("categoria").isEmpty()){
                empleado.setCategoria(1);
            }else {
                empleado.setCategoria(Integer.parseInt(request.getParameter("categoria")));
            }
            if(request.getParameter("anyos").isEmpty()){
                empleado.setAnyos(0);
            }else {
                empleado.setAnyos(Integer.parseInt(request.getParameter("anyos")));
            }
            try {
                empleadoDAO.editar(empleado);
                System.out.println("Registro editado satisfactoriamente...");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException e) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                request.setAttribute("errorMessage", "Fallo en la base de datos");
                requestDispatcher.forward(request, response);
                e.printStackTrace();
            }
        } else if (opcion.equals("listarFiltro")) {
            String criterio = request.getParameter("criterio");
            String valor = request.getParameter("valor");


            if (criterio == null || valor == null) {
                // Si los criterios no están presentes, mostramos el formulario de búsqueda
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/buscarEmpleados.jsp");
                requestDispatcher.forward(request, response);
            } else {
                // Si ya se han ingresado criterios de búsqueda, buscamos y mostramos los resultados
                EmpleadoDAO empleadoDao = new EmpleadoDAO();
                List<Empleado> lista = new ArrayList<>();
                try {
                    lista = empleadoDao.obtenerEmpleadosFiltrados(criterio, valor);
                    for (Empleado empleado : lista) {
                        empleado.imprime();
                    }
                    request.setAttribute("lista", lista);
                    RequestDispatcher requestDispatcher2 = request.getRequestDispatcher("/views/listar.jsp");
                    requestDispatcher2.forward(request, response);
                } catch (SQLException e) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/error.jsp");
                    request.setAttribute("errorMessage", "Fallo en la base de datos");
                    requestDispatcher.forward(request, response);
                    e.printStackTrace();
                }
            }
        }


        // doGet(request, response);
    }

}