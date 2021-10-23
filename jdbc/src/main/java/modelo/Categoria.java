package modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private int id;
	private String nome;
	List<Produto> produtos = new ArrayList<Produto>();

	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public void adicionarProduto(Produto produto) {
		this.produtos.add(produto);
	}


	
	
}
