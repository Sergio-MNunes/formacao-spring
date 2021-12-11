package br.com.sergio.jpa.testes;

import br.com.sergio.jpa.dao.CategoriaDao;
import br.com.sergio.jpa.dao.ProdutoDao;
import br.com.sergio.jpa.modelo.Categoria;
import br.com.sergio.jpa.modelo.Produto;
import br.com.sergio.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class DeletaRegistro {

    public static void main(String[] args) {
        Categoria comida = new Categoria("COMIDA");
        Produto anaMaria = new Produto("Ana Maria", "Baunilha", new BigDecimal(1.99), comida);

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
        Produto qwe = produtoDao.buscar(1);
        produtoDao.remover(qwe);
        em.getTransaction().commit();
    }
}