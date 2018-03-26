package br.com.batista.biblioteca.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Emprestimo;

public class EmprestimoDAO implements Serializable{

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Emprestimo emprestimo) {
		manager.persist(emprestimo);
	}
}
