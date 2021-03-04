package gerenciador.classes;

public class Usuario {
	private int id;
	private String nome;
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
