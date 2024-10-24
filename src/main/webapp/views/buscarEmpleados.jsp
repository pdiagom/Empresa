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
    <link rel="stylesheet" type="text/css" href="../empresa/CSS/styles.css">
    <script>
        // Función que cambia el input según la opción seleccionada
        function actualizarCampo() {
            const criterio = document.getElementById('criterio').value;
            const entrada = document.getElementById('entrada');


            entrada.innerHTML = '';

            if (criterio === 'sexo') {

                const selectSexo = document.createElement('select');
                selectSexo.name = 'valor';
                selectSexo.id = 'valor';

                const optionM = document.createElement('option');
                optionM.value = 'M';
                optionM.textContent = 'Masculino';

                const optionF = document.createElement('option');
                optionF.value = 'F';
                optionF.textContent = 'Femenino';

                selectSexo.appendChild(optionM);
                selectSexo.appendChild(optionF);

                entrada.appendChild(selectSexo);
            } else {

                const inputText = document.createElement('input');
                inputText.type = 'text';
                inputText.name = 'valor';
                inputText.id = 'valor';
                inputText.required = true;

                entrada.appendChild(inputText);
            }
        }


        window.onload = actualizarCampo;
    </script>
</head>
<body>
<h2>Buscar Empleados</h2>
<form action="empleados" method="POST">
    <input type="hidden" name="opcion" value="listarFiltro">
    <label for="criterio">Buscar por:</label>
    <select name="criterio" id="criterio"  onchange="actualizarCampo()">
        <option value="dni">DNI</option>
        <option value="nombre">Nombre</option>
        <option value="categoria">Categoría</option>
        <option value="sexo">Sexo</option>
        <option value="anyos_trabajados">Años Trabajados</option>
    </select><br><br>

    <label for="valor">Valor de búsqueda:</label>
    <div id="entrada">

        <input type="text" id="valor" name="valor" required>
    </div><br><br>

    <input type="submit" value="Buscar">
    <a class="volver" href="../empresa/index.jsp">Volver al Menú</a>
</form>
</body>
</html>
