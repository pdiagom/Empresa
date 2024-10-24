<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 24/10/2024
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <link rel="stylesheet" type="text/css" href="../empresa/CSS/styles.css">
</head>
<body>
<h2>Se ha producido un error</h2>
<p class="paginaError">Lo sentimos, ha ocurrido un error en la aplicación.</p>
<p class="error"><strong>Error:</strong> ${errorMessage}</p>
<a class="volver paginaError" href="../empresa/index.jsp">Volver al Menú</a>
</body>
</html>
