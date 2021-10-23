<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List, model.Empresa" %> <!-- imports em JSP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- import da lib jstl core. -->    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresas cadastradas</title>
</head>
<body>
<ul>

<c:forEach items = "${empresas}" var = "empresa">
	<li>
	${ empresa.nome }
	<a href="/gerenciador/mostraEmpresa?id=${empresa.id}">editar</a>
	<a href="/gerenciador/removeEmpresa?id=${empresa.id}">remover</a>
	</li>
</c:forEach>

</ul>
</body>
</html>