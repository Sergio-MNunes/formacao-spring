package br.com.sergio.jpa.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

// Mapeamento da entidade Produto

// A tag Entity serve para falarmos para o JPA que esta classe representa uma tabela no nosso banco de dados.

//A tag Table serve para referenciarmos o nome correto da tabela caso ela possua um nome incompatível com os patterns da POO.
// Neste caso, como o nome da classe e da tabela são iguais, coloquei a tag apenas para fins didáticos.
@Entity
@Table(name = "produto")
public class Produto {

//	Assim como a tag Table, temos também uma tag Column(name = "") para apontarmos o nome da 
//	coluna no banco de dados, caso o nome seja incompatível com as boas práticas de POO e Java
//  A tag Id tag indica para o JPA qual coluna é a primary key no banco de dados
//  A tag GeneratedValue indica para o JPA que a primary key é gerada automaticamente pelo
//	banco de dados. No geral, se usa a strategy INDENTITY. Desta forma, podemos passar um id null quando estivermos inserindo registros na tabela

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    @ManyToOne
    private Categoria categoria;

//    Em nossas entidades, colocamos o construtor padrao para que seja possivel utilizar o metodo merge do Entity Manager,
//    para quando quisermos voltar uma entidade do estado detached para managed
    public Produto() {
    }

    public Produto(String nome, String descricao, BigDecimal preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public long getId() {
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
