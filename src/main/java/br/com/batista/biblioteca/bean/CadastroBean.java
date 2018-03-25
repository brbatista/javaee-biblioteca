package br.com.batista.biblioteca.bean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.batista.biblioteca.dao.PessoaDAO;
import br.com.batista.biblioteca.modelo.Endereco;
import br.com.batista.biblioteca.modelo.Pessoa;

@Model
public class CadastroBean {

	private Pessoa pessoa = new Pessoa();
	private Endereco endereco = new Endereco();

	@Inject
	private PessoaDAO dao;

	@Transactional
	public void salvar() {
		dao.salvar(this.pessoa);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}
