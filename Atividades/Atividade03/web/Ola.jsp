<%-- 
    Document   : Ola
    Created on : 19/02/2020, 21:40:43
    Author     : jairo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diga Olá</title>
    </head>
    <body>
        <%java.util.Date data = new java.util.Date();%> 
        <%=data%>
        <%
            String nome = request.getParameter("nome");
            if (nome == null || nome.isEmpty()) {
        %>
        <h1>Olá Mundo!</h1>
        <%
        } else {
        %>
        <h1>Olá <%=nome%>!</h1>
        <%
            }
        %>
        <p>Você está acessando uma página JSP.</p>
        }
        }

        }

    </body>
</html>
