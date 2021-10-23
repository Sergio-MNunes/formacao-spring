package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//Esta anotacao diz pro compilador que a classe PrimeiroServlet se trata de um servlet
@WebServlet(urlPatterns = "/olaMundo") // Define a url que ira disparar o servlet
public class OlaMundoServlet extends HttpServlet {
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.write("Ola! Este eh o meu primeiro servlet.");
	
	}

}
