<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Men� de Opciones</title>
    <link rel="stylesheet" type="text/css" href="CSS/styles.css">
</head>
<body>
<h1>Menu de Opciones Empleados</h1>
<table border="1">
    <tr>
        <td><a href="empresa?modulo=empleados&opcion=crear">Crear un Empleado</a></td>
    </tr>
    <tr>
        <td><a href="empresa?modulo=empleados&opcion=listar">Listar Empleados</a></td>
    </tr>
    <tr>
        <td><a href="empresa?modulo=empleados&opcion=filtrar">Buscar Empleados</a></td>
    </tr>
    <tr>
        <td><a href="empresa?modulo=nominas&opcion=buscarSueldo">Buscar Sueldo de Empleado</a></td>
    </tr>
</table>
</body>
</html>