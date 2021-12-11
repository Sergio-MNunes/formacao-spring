package br.com.sergio.jpa.dao;

import br.com.sergio.jpa.modelo.Categoria;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void persiste(Categoria categoria){
        em.persist(categoria);
    }

    public void atualizar(Categoria categoria) {
        this.em.merge(categoria);
    }

    public void remover(Categoria categoria) {
        categoria = this.em.merge(categoria);
        this.em.remove(categoria);
    }

    public Categoria buscar(long id){
        return this.em.find(Categoria.class, id);
    }

    public List<Categoria> buscarTodas(){
        String jpql = "SELECT c FROM Categoria c";
        return this.em.createQuery(jpql, Categoria.class).getResultList();
    }
}
