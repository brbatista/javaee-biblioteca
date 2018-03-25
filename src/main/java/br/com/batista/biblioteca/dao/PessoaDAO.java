package br.com.batista.biblioteca.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.batista.biblioteca.modelo.Pessoa;

public class PessoaDAO {

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Pessoa pessoa) {
		manager.persist(pessoa);
	}
	
	public List<Pessoa> listar(){
		return manager.createQuery("select p from Pessoa p", Pessoa.class).getResultList();
	}
}
