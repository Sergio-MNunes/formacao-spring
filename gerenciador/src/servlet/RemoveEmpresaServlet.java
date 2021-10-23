package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;

@WebServlet(urlPatterns = "/removeEmpresa")
public class RemoveEmpresaServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.valueOf(req.getParameter("id"));

		Banco banco = new Banco();
		banco.remove(id.intValue());
		
		resp.sendRedirect("listaEmpresas");
	
	}
}
