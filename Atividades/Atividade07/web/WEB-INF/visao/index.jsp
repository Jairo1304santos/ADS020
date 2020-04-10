
<%@page import="beans.Aluno" %>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="cabecalho.jsp"%>

        <% String msg = "Olá Mundo!";%>
        <h1><%= msg%></h1>

        <p><%= new Date()%></p>

        <%int x = 12 / 2;%>

        <jsp:useBean id="aluno" class="beans.Aluno"/>

        <jsp:setProperty name="aluno" property="matricula" value="1821"/>
        <jsp:setProperty name="aluno" property="nome" value="JAIRO"/>

        <p>Os atributos do bean Aluno são: <jsp:getProperty name="aluno" property="matricula"/> e 
        <jsp:getProperty name="aluno" property="nome"/></p>

<%@include file="rodape.jsp"%>        

