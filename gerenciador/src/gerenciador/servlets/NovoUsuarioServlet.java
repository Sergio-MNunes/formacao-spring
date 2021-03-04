package gerenciador.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import gerenciador.classes.Banco;
import gerenciador.classes.Usuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/adicionaUsuarios")
public class NovoUsuarioServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		Usuario user = new Usuario();
		user.setNome(req.getParameter("nome"));
		
		Banco bd = new Banco();
		bd.adiciona(user);
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("Usuario " + user.getNome() + " cadastrado com sucesso!");
	}
}
