package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

@WebServlet(urlPatterns = "/editaEmpresa")
public class EditaEmpresaServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));
		String nome = req.getParameter("nome");
		String data = req.getParameter("data");
		Banco banco = new Banco();
		Empresa emp = banco.busca(id.intValue());
		
		emp.setNome(nome);
		emp.setData(data);
	
		resp.sendRedirect("listaEmpresas");
	}
}
