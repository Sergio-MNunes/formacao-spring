package br.com.sergio.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.sergio.jpa.modelo.Produto;

public class InsereRegistro {

	public static void main(String[] args) {
		Produto anaMaria = new Produto();
		
		anaMaria.setNome("Ana Maria");
		anaMaria.setDescricao("Baunilha");
		anaMaria.setPreco(new BigDecimal(1.99));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(anaMaria);
		em.getTransaction().commit();
	}
}
