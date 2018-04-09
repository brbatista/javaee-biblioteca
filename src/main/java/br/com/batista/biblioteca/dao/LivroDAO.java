package br.com.batista.biblioteca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Livro;

public class LivroDAO implements Serializable{
	
	@PersistenceContext
	private EntityManager manager;

	public void salvar(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> listaLivros(){
		String jpql = "select distinct(l) from Livro l join fetch l.autores";
		return manager.createQuery(jpql,Livro.class).getResultList();
	}

	public void remover(Livro livro) {
		Livro objeto = manager.merge(livro);
		manager.remove(objeto);
	}

	public void atualizar(Livro livro) {
		Livro objeto = manager.merge(livro);
		manager.persist(objeto);
		
	}

}
