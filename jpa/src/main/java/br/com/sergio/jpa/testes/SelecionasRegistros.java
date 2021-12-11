package br.com.sergio.jpa.testes;

import br.com.sergio.jpa.dao.CategoriaDao;
import br.com.sergio.jpa.dao.ProdutoDao;
import br.com.sergio.jpa.modelo.Produto;
import br.com.sergio.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class SelecionasRegistros {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        List<Produto> produtos = produtoDao.buscarTodos();
        BigDecimal valor = produtoDao.buscarPrecoPorNome("Ana Maria");
        String categoria = produtoDao.buscarCategoriaPorNome("Ana Maria");

        System.out.println(produtos.get(0).getNome());
        System.out.println(valor);
        System.out.println(categoria);


    }
}