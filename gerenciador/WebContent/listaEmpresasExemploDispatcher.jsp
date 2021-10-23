<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import= "java.util.List, model.Empresa" %> <!-- imports em JSP -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- import da lib jstl core. -->

<!-- Os arquivos JSP possuem duas variaveis fixas, "request" e "out". Elas nao precisam ser declaradas para serem utilizadas aqui. -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<ul>
<c:forEach items="${empresas}" var="empresa">
	<li> ${empresa.nome} </li>
</c:forEach>
</ul>

	Experimente atualizar a pagina. Veja o que acontece!
	A ultima empresa adicionada continua sendo adicionada no banco de dados, né? Isso acontece porque este JSP
	esta recebendo uma requisicao POST do NovaEmpresaExemploDispatcherServlet, portanto, sempre que a pagina eh
	atualizada, o navegador envia uma nova requisicao POST para o servidor, o que resulta em um novo registro
	sendo incluido no banco.

</body>
</html>
