package br.com.batista.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Livro;

public class LivroDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void salvar(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> listaLivros(){
		return manager.createQuery("select l from Livro l",Livro.class).getResultList();
	}

}
