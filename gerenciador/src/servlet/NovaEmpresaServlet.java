package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	Banco banco = new Banco();
	String empresaNome = req.getParameter("nome");
	String empresaDataAbertura = req.getParameter("dataAbertura");
	
	Empresa empresa = new Empresa(empresaNome, empresaDataAbertura);
	banco.add(empresa);
	
	resp.sendRedirect("listaEmpresas");
	}
}
