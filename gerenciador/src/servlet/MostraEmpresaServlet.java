package servlet;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

@WebServlet(urlPatterns = "/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	Integer id = Integer.valueOf(req.getParameter("id"));
	System.out.println(id.intValue());
	Banco banco = new Banco();
	Empresa empresa = banco.busca(id.intValue());
	
	req.setAttribute("empresa", empresa);
	RequestDispatcher rd = req.getRequestDispatcher("editaEmpresa.jsp");
	rd.forward(req, resp);
	}
}
