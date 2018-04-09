package br.com.batista.biblioteca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Autor;

public class AutorDAO implements Serializable{
	
	@PersistenceContext
	private EntityManager manager;

	public void salvar(Autor autor) {
		manager.persist(autor);
	}

	public List<Autor> listaAutores() {
		return manager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public void remover(Autor autor) {
		manager.remove(manager.merge(autor));
		
	}

	public void atualizar(Autor autor) {
		manager.persist(manager.merge(autor));
		
	}
}
