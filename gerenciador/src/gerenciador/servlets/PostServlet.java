package gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/postServlet")
public class PostServlet extends HttpServlet {

	// O metodo doPost aceita apenas requisicoes post. Caso a pagina /gerenciador/postServlet seja chamada por uma requisicao get, dara erro 405 – Method Not Allowed
	// A diferenca do metodo post pro get eh que no post, os parametros da requisicao nao aparecem na url, enquanto que no metodo get elas aparecem
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String usuario = req.getParameter("usuario");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>Usuario " + usuario + " cadastrado com sucesso!</body></html>");
		
	}
}
