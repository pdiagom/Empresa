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
            connection.setAutoCommit(false);
            sql = "INSERT INTO empleados (dni, nombre, genero, categoria, anyos_trabajados) VALUES(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);

            statement.setString(1, empleado.getDni());
            statement.setString(2, empleado.getNombre());
            statement.setString(3, String.valueOf(empleado.getSexo()));
            statement.setInt(4, empleado.getCategoria());
            statement.setInt(5, empleado.getAnyos());

            estadoOperacion = statement.executeUpdate() > 0;

            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
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

            statement.setString(1, empleado.getDni());
            statement.setString(2, empleado.getNombre());
            statement.setString(3, String.valueOf(empleado.getSexo()));
            statement.setInt(4, empleado.getCategoria());
            statement.setInt(5, empleado.getAnyos());

            estadoOperacion = statement.executeUpdate() > 0;

            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }

        return estadoOperacion;
    }
    public boolean eliminar(String dni) throws SQLException {
        String sql = null;
        estadoOperacion = false;
        connection = obtenerConexion();
        try {
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
                empleado.setNombre(resultSet.getString(2));
                empleado.setSexo(resultSet.getString(3));
                empleado.setCategoria(resultSet.getInt("categoria"));
                empleado.setAnyos(resultSet.getInt("anyos_trabajados"));

                listaEmpleados.add(empleado);
            }

        } catch (SQLException e) {
            e.printStackTrace();
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
                statement.setString(1, empleado.getDni());
                statement.setString(2, empleado.getNombre());
                statement.setString(3, String.valueOf(empleado.getSexo()));
                statement.setInt(4, empleado.getCategoria());
                statement.setInt(5, empleado.getAnyos());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empleado;
    }


    // obtener conexion pool
    private Connection obtenerConexion() throws SQLException {
        return Conexion.getConnection();
    }
}