package br.com.batista.biblioteca.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Emprestimo;

public class EmprestimoDAO{

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Emprestimo emprestimo) {
		manager.persist(emprestimo);
	}
}
