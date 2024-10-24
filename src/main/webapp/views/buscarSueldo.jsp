<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 17/10/2024
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>Buscar Sueldo de Empleado</title>
  <link rel="stylesheet" type="text/css" href="../empresa/CSS/styles.css">
</head>
<body>
<h1>Buscar Sueldo de Empleado</h1>
<form action="nominas" method="post">
  <input type="hidden" name="opcion" value="consultarSueldo">
  <label for="dni">Ingrese el DNI del empleado:</label>
  <input type="text" id="dni" name="dni" required>
  <button type="submit">Buscar Sueldo</button>
  <a class="volver" href="../empresa/index.jsp">Volver al Menú</a>
</form>

</body>
</html>
