package br.com.batista.biblioteca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Emprestimo;
import br.com.batista.biblioteca.modelo.Status;

public class EmprestimoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager manager;

	public void salvar(Emprestimo emprestimo) {
		manager.persist(emprestimo);
		Status status = new Status();
		status.setEmprestimo(emprestimo);
		status.setDevolvido(false);
		manager.persist(status);
	}

	public List<Emprestimo> listar() {
		String jpql = "select distinct(e) from Emprestimo e " + "join fetch e.livros";
		return manager.createQuery(jpql, Emprestimo.class).getResultList();
	}

	public Emprestimo buscaPorId(Integer id) {
		String jpql = "select e from Emprestimo e " + "join fetch e.livros "+ "where e.id = :id";
		return manager.createQuery(jpql, Emprestimo.class).setParameter("id", id).getSingleResult();
	}
}
