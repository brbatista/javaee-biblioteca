package br.com.batista.biblioteca.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Emprestimo;

public class EmprestimoDAO implements Serializable {

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Emprestimo emprestimo) {
		manager.persist(emprestimo);
	}

	public List<Emprestimo> listar() {
		String jpql = "select distinct(e) from Emprestimo e " + "join fetch e.livros";
		return manager.createQuery(jpql, Emprestimo.class).getResultList();
	}

	public Emprestimo buscaPorId(Integer id) {
		String jpql = "select e from Emprestimo e " + "join fetch e.livros " + "where e.id = :id";
		return manager.createQuery(jpql, Emprestimo.class).setParameter("id", id).getSingleResult();
	}
}
