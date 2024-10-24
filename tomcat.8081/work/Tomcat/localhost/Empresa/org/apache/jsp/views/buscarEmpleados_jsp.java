/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.100
 * Generated at: 2024-10-24 10:58:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class buscarEmpleados_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Buscar Empleados</title>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=\"../empresa/CSS/styles.css\">\r\n");
      out.write("    <script>\r\n");
      out.write("        // Función que cambia el input según la opción seleccionada\r\n");
      out.write("        function actualizarCampo() {\r\n");
      out.write("            const criterio = document.getElementById('criterio').value;\r\n");
      out.write("            const entrada = document.getElementById('entrada');\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            entrada.innerHTML = '';\r\n");
      out.write("\r\n");
      out.write("            if (criterio === 'sexo') {\r\n");
      out.write("\r\n");
      out.write("                const selectSexo = document.createElement('select');\r\n");
      out.write("                selectSexo.name = 'valor';\r\n");
      out.write("                selectSexo.id = 'valor';\r\n");
      out.write("\r\n");
      out.write("                const optionM = document.createElement('option');\r\n");
      out.write("                optionM.value = 'M';\r\n");
      out.write("                optionM.textContent = 'Masculino';\r\n");
      out.write("\r\n");
      out.write("                const optionF = document.createElement('option');\r\n");
      out.write("                optionF.value = 'F';\r\n");
      out.write("                optionF.textContent = 'Femenino';\r\n");
      out.write("\r\n");
      out.write("                selectSexo.appendChild(optionM);\r\n");
      out.write("                selectSexo.appendChild(optionF);\r\n");
      out.write("\r\n");
      out.write("                entrada.appendChild(selectSexo);\r\n");
      out.write("            } else {\r\n");
      out.write("\r\n");
      out.write("                const inputText = document.createElement('input');\r\n");
      out.write("                inputText.type = 'text';\r\n");
      out.write("                inputText.name = 'valor';\r\n");
      out.write("                inputText.id = 'valor';\r\n");
      out.write("                inputText.required = true;\r\n");
      out.write("\r\n");
      out.write("                entrada.appendChild(inputText);\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        window.onload = actualizarCampo;\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>Buscar Empleados</h2>\r\n");
      out.write("<form action=\"empleados\" method=\"POST\">\r\n");
      out.write("    <input type=\"hidden\" name=\"opcion\" value=\"listarFiltro\">\r\n");
      out.write("    <label for=\"criterio\">Buscar por:</label>\r\n");
      out.write("    <select name=\"criterio\" id=\"criterio\"  onchange=\"actualizarCampo()\">\r\n");
      out.write("        <option value=\"dni\">DNI</option>\r\n");
      out.write("        <option value=\"nombre\">Nombre</option>\r\n");
      out.write("        <option value=\"categoria\">Categoría</option>\r\n");
      out.write("        <option value=\"sexo\">Sexo</option>\r\n");
      out.write("        <option value=\"anyos_trabajados\">Años Trabajados</option>\r\n");
      out.write("    </select><br><br>\r\n");
      out.write("\r\n");
      out.write("    <label for=\"valor\">Valor de búsqueda:</label>\r\n");
      out.write("    <div id=\"entrada\">\r\n");
      out.write("\r\n");
      out.write("        <input type=\"text\" id=\"valor\" name=\"valor\" required>\r\n");
      out.write("    </div><br><br>\r\n");
      out.write("\r\n");
      out.write("    <input type=\"submit\" value=\"Buscar\">\r\n");
      out.write("    <a class=\"volver\" href=\"../empresa/index.jsp\">Volver al Menú</a>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
