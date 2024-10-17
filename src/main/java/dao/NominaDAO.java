package dao;

import connection.Conexion;
import model.Empleado;
import model.Nomina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NominaDAO {
    private Connection connection;
    private PreparedStatement statement;
    public boolean empleadoExiste(String dni) throws SQLException {
        String sql = "SELECT COUNT(*) FROM empleados WHERE dni = ?";
        try (Connection connection = obtenerConexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        }
        return false;
    }
    // Metodo para obtener el sueldo de un empleado
    public double obtenerSueldo(String dni) throws SQLException {
        double sueldo = 0.0;
        String sql = "SELECT sueldo FROM nominas WHERE dni = ?";
        connection = obtenerConexion();

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sueldo = resultSet.getDouble("sueldo");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }

        return sueldo;
    }

    // Metodo para obtener conexión a la base de datos
    private Connection obtenerConexion() throws SQLException {
        return Conexion.getConnection();
    }
}
