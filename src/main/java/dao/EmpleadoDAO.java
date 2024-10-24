package dao;

import connection.Conexion;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {
    private Connection connection;
    private PreparedStatement statement;
    private boolean estadoOperacion;

    public boolean guardar(Empleado empleado) throws SQLException {
        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();

        try {
            if(empleado==obtenerEmpleado(empleado.getDni())){

            }else {
                connection.setAutoCommit(false);
                sql = "INSERT INTO empleados (dni, nombre, genero, categoria, anyos_trabajados) VALUES(?,?,?,?,?)";
                statement = connection.prepareStatement(sql);

                statement.setString(1, empleado.getDni());
                statement.setString(2, empleado.getNombre());
                statement.setString(3, empleado.getSexo());
                statement.setInt(4, empleado.getCategoria());
                statement.setInt(5, empleado.getAnyos());

                estadoOperacion = statement.executeUpdate() > 0;

                connection.commit();
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        }

        return estadoOperacion;
    }
    public boolean editar(Empleado empleado) throws SQLException {
        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();

        try {
            connection.setAutoCommit(false);
            sql = "UPDATE empleados SET nombre=?, genero=?, categoria=?, anyos_trabajados=? WHERE dni=?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, empleado.getNombre());
            statement.setString(2, empleado.getSexo());
            statement.setInt(3, empleado.getCategoria());
            statement.setInt(4, empleado.getAnyos());
            statement.setString(5, empleado.getDni());

            estadoOperacion = statement.executeUpdate() > 0;

            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        }

        return estadoOperacion;
    }
    public boolean eliminar(String dni) throws SQLException {
        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();
        try {
            System.out.println(dni);
            connection.setAutoCommit(false);
            sql = "DELETE FROM empleados WHERE dni=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, dni);

            estadoOperacion = statement.executeUpdate() > 0;
            connection.commit();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
            throw e;
        }

        return estadoOperacion;
    }
    public List<Empleado> obtenerEmpleados() throws SQLException {
        ResultSet resultSet = null;
        List<Empleado> listaEmpleados = new ArrayList<>();

        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();

        try {
            sql = "SELECT * FROM empleados";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setDni(resultSet.getString("dni"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setSexo(resultSet.getString("genero"));
                empleado.setCategoria(resultSet.getInt("categoria"));
                empleado.setAnyos(resultSet.getInt("anyos_trabajados"));
                listaEmpleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return listaEmpleados;
    }

    public Empleado obtenerEmpleado(String dni) throws SQLException {
        ResultSet resultSet = null;
        Empleado empleado = new Empleado();

        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();

        try {
            sql = "SELECT * FROM empleados WHERE dni =?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, dni);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                empleado.setDni(resultSet.getString("dni"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setSexo(resultSet.getString("genero"));
                empleado.setCategoria(resultSet.getInt("categoria"));
                empleado.setAnyos(resultSet.getInt("anyos_trabajados"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return empleado;
    }

    public List<Empleado> obtenerEmpleadosFiltrados(String criterio, String valor) throws SQLException {
        ResultSet resultSet = null;
        List<Empleado> listaEmpleados = new ArrayList<>();

        String sql = null;
        if(criterio.equals("dni")){
            sql = "SELECT * FROM empleados WHERE dni='"+valor+"'";
        }else if(criterio.equals("nombre")){
            sql = "SELECT * FROM empleados WHERE nombre='"+valor+"'";
        } else if (criterio.equals("sexo")) {
            sql = "SELECT * FROM empleados WHERE genero='"+valor+"'";
        } else if (criterio.equals("categoria")) {
            sql = "SELECT * FROM empleados WHERE categoria="+valor;
        } else if (criterio.equals("anyos_trabajados")) {
            sql = "SELECT * FROM empleados WHERE anyos_trabajados="+valor;
        }
        estadoOperacion = false;
        connection = obtenerConexion();

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setDni(resultSet.getString("dni"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setSexo(resultSet.getString("genero"));
                empleado.setCategoria(resultSet.getInt("categoria"));
                empleado.setAnyos(resultSet.getInt("anyos_trabajados"));
                listaEmpleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return listaEmpleados;
    }

    // obtener conexion pool
    private Connection obtenerConexion() throws SQLException {
        return Conexion.getConnection();
    }
}