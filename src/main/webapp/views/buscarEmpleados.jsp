<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 18/10/2024
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Buscar Empleados</title>
</head>
<body>
<h2>Buscar Empleados</h2>
<form action="empleados" method="POST">
    <input type="hidden" name="opcion" value="listarFiltro">
    <label for="criterio">Buscar por:</label>
    <select name="criterio" id="criterio">
        <option value="dni">DNI</option>
        <option value="nombre">Nombre</option>
        <option value="categoria">Categoría</option>
        <option value="sexo">Sexo</option>
        <option value="anyos_trabajados">Años Trabajados</option>
    </select><br><br>

    <label for="valor">Valor de búsqueda:</label>
    <input type="text" id="valor" name="valor" value="" required><br><br>

    <input type="submit" value="Buscar">
</form>
</body>
</html>
