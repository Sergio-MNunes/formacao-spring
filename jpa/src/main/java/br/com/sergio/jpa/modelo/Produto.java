package br.com.sergio.jpa.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Mapeamento da entidade Produto

// A tag Entity serve para falarmos para o JPA que esta classe representa uma tabela no nosso banco de dados.

//A tag Table serve para referenciarmos o nome correto da tabela caso ela possua um nome incompat�vel com os patterns da POO.
// Neste caso, como o nome da classe e da tabela s�o iguais, coloquei a tag apenas para fins did�ticos.
@Entity
@Table(name = "produto")
public class Produto {

//	Assim como a tag Table, temos tamb�m uma tag Column(name = "") para apontarmos o nome da 
//	coluna no banco de dados, caso o nome seja incompat�vel com as boas pr�ticas de POO e Java
//  A tag Id tag indica para o JPA qual coluna � a primary key no banco de dados
//  A tag GeneratedValue indica para o JPA que a primary key � gerada automaticamente pelo
//	banco de dados. No geral, se usa a strategy INDENTITY. Desta forma, podemos passar um id null quando estivermos inserindo registros na tabela
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String descricao;
	private BigDecimal preco;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
}
