package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Banco;
import model.Empresa;

@WebServlet(urlPatterns = "/novaEmpresaExemploDispatcher")
public class NovaEmpresaExemploDispatcherServlet extends HttpServlet {

	
	// O metodo doPost aceita apenas requisicoes post. Caso a pagina /gerenciador/postServlet seja chamada por uma requisicao get, dara erro 405 – Method Not Allowed
	// A diferenca do metodo post pro get eh que no post, os parametros da requisicao nao aparecem na url, enquanto que no metodo get elas aparecem
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Pega os parametros recebidos na requisicao HTTP. O metodo getParameter recebe como argumento o nome do parametro recebido pela requisicao.
		// http://localhost:8080/gerenciador/meuServlet?nome=Sergio (parametros em requisicoes GET)
		// Nome: <input type="text" name="nome" /> (parametros em formularios HTML)
		// A linha acima fica no arquivo HTML onde eh configurado o formulario. Para mais detalhes, ver "novaEmpresaForm.html"
		String nome = request.getParameter("nome");
		String dataAbertura = request.getParameter("dataAbertura");
		
		Empresa empresa = new Empresa(nome, dataAbertura);
		Banco banco = new Banco();
		
		banco.add(empresa);
		
		System.out.println("Empresa " + nome + " salva com sucesso.");
		
		request.setAttribute("empresas", banco.getEmpresas()); // Este metodo adiciona o atributo "empresas" na requisicao, contendo a lista de empresas do banco.
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresasExemploDispatcher.jsp"); // O objeto RequestDispatcher recebe em seu construtor o destino da requisicao que sera direcionada pra ele.
		rd.forward(request, response); // O metodo forward dispacha de fato a requisicao para o destino informado no construtor do RequestDispatcher.		
	}
}
