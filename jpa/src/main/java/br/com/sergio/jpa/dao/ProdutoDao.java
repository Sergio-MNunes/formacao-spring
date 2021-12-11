package br.com.sergio.jpa.dao;

import br.com.sergio.jpa.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void persiste(Produto produto) {
        em.persist(produto);
    }

//    Por padrao, os projetos costumam ter o metodo de atualizar uma entidade em sua DAO correspondente. Este metodo utiliza o merge do Entity Manager,
//    para mudar o estado da entidade de volta para managed (assumimos que, quando usamos o metodo atualizar, ele recebera uma entidade no estado detached).
//    Isso pode ser confuso, pois o metodo merge nao altera o estado do objeto recebido como parametro para managed, ele na verdade devolve um novo objeto no
//    estado managed, e o que foi passado como parametro continua no estado detached. Entao por que o metodo atualizar eh void? Porque, por padrao, ele recebe
//    como parametro uma entidade que JA ESTA com os atributos alterados, e, assim, quando houver a alteracao de estado desta entidade para managed, o JPA ja
//    identificara as alteracoes e elas serao commitadas, independente de guardarmos ou nao a referencia a esta entidade em estado managed. Na verdade, a
//    referencia eh perdida, pois a intencao do metodo atualizar eh somente fazer o update dos atributos ja alterados na entidade passada como parametro, e
//    nao armazenar a nova entidade para fazermos outras alteracoes. Espera-se que as alteracoes ja recebidas sejam as unicas a ser realizadas e pronto.
    public void atualizar(Produto produto) {
        this.em.merge(produto);
    }


//    Incluir comentários a respeito dos métodos remover, buscar e buscarTodos
    public void remover(Produto produto) {
        produto = this.em.merge(produto);
        this.em.remove(produto);
    }

    public Produto buscar(long id){
        return this.em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos(){
        String jpql = "SELECT p FROM Produto p";
        return this.em.createQuery(jpql, Produto.class).getResultList();
    }

    public BigDecimal buscarPrecoPorNome(String nome) {
        String jpql = "select p.preco from Produto p where p.nome = :nome";
        return this.em.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }

    public String buscarCategoriaPorNome(String nome){
        String jpql = "select p.categoria.nome from Produto p where p.nome = :nome";
        return this.em.createQuery(jpql, String.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
