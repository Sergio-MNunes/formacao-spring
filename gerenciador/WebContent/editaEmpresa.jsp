<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- import da lib jstl core. -->    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/gerenciador/editaEmpresa" method="post">

    Nome: <input type="text" name="nome" value="${empresa.nome}" />
    Data Abertura: <input type="text" name="data" value="${empresa.data}" />
    <input type="hidden" name="id" value="${empresa.id}"/>
    <input type="submit"/>
    
</body>
</html>