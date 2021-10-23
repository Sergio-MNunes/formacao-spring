package modelo;

public class Produto {

	// As classes de modelo são as classes que representam as tabelas do nosso banco de dados na nossa aplicação. São as ENTIDADES do nosso sistema.
	// De forma geral, existe uma classe modelo para cada tabela do banco de dados.
	private int id;
	private String nome;
	private String descricao;
	private int idCategoria;
	
	public Produto(String nome, String descricao, int idCategoria) {
		this.nome = nome;
		this.descricao = descricao;
		this.idCategoria = idCategoria;
	}
	
	public Produto(int id, String nome, String descricao, int idCategoria) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.idCategoria = idCategoria;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public int getIdCategoria() {
		return idCategoria;
	}
	
	@Override
	public String toString() {
		return "ID " + id + ": " + nome + ", " + descricao + ", categoria " + idCategoria;
	}
}
