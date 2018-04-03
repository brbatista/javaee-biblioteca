package br.com.batista.biblioteca.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Emprestimo;
import br.com.batista.biblioteca.modelo.Status;

public class StatusDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Status status) {
		manager.persist(status);
	}
	
	public void atualizar(Status status) {
		manager.merge(status);
	}

	public Status buscaPorEmprestimo(Emprestimo emprestimo) {
		String jpql = "select s from Status s where s.emprestimo = :emprestimo";
		return manager.createQuery(jpql, Status.class).setParameter("emprestimo", emprestimo).getSingleResult();
	}
}
