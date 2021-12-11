package br.com.sergio.jpa.testes;

import br.com.sergio.jpa.dao.CategoriaDao;
import br.com.sergio.jpa.dao.ProdutoDao;
import br.com.sergio.jpa.modelo.Categoria;
import br.com.sergio.jpa.modelo.Produto;
import br.com.sergio.jpa.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class InsereRegistro {

    public static void main(String[] args) {
        Categoria comida = new Categoria("COMIDA");
        Produto anaMaria = new Produto("Ana Maria", "Baunilha", new BigDecimal(1.99), comida);

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

//        Uma entidade JPA pode ter tres estados durante o seu ciclo de vida: transient, maganed e detached
//        Transient: uma entidade esta no estado transient assim que ela eh criada, ou seja, assim que o objeto eh instanciado. Para o JPA,
//        uma entidade no estado transient eh apenas um objeto java comum
//        Managed: assim que usamos o metodo persist do EntityManager, a entidade passa a estar no seu estado de managed. Neste estado, qualquer alteracao
//        que fizermos na entidade (no objeto) sera monitorada pelo JPA e sera refletida no banco de dados assim que fizermos o commit ou um flush, atraves
//        de um update
//        Detached: quando fechamos o Entity Manager com close ou limpamos com o clear, todas as entidades que estavam sendo monitoradas por ele (managed)
//        passarao para detached. Neste estado, as entidades ja foram monitoradas e nao estao mais sendo observadas pelo JPA.
        em.getTransaction().begin();

        categoriaDao.persiste(comida);
        produtoDao.persiste(anaMaria);

        em.getTransaction().commit();
    }
}