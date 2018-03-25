package br.com.batista.biblioteca.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Endereco;

public class EnderecoDAO {

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Endereco endereco) {
		manager.persist(endereco);
	}
}
