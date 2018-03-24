package br.com.batista.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Autor;

public class AutorDAO {
	
	@PersistenceContext
	private EntityManager manager;

	public void salvar(Autor autor) {
		manager.persist(autor);
	}

	public List<Autor> listaAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}
}
