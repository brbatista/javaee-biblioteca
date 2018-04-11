package br.com.batista.biblioteca.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Emprestimo;
import br.com.batista.biblioteca.modelo.Devolucao;

public class DevolucaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Devolucao devolucao) {
		manager.persist(devolucao);
	}

}
