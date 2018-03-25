package br.com.batista.biblioteca.bean;

import java.util.ArrayList;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.batista.biblioteca.dao.EnderecoDAO;
import br.com.batista.biblioteca.dao.PessoaDAO;
import br.com.batista.biblioteca.modelo.Endereco;
import br.com.batista.biblioteca.modelo.Livro;
import br.com.batista.biblioteca.modelo.Pessoa;

@Model
public class CadastroBean {

	private Pessoa pessoa = new Pessoa();
	private Endereco endereco = new Endereco();

	@Inject
	private PessoaDAO pessoaDao;
	
	@Inject
	private EnderecoDAO enderecoDao;

	@Transactional
	public void salvar() {
		enderecoDao.salvar(endereco);
		pessoa.setEndereco(this.endereco);
		pessoaDao.salvar(this.pessoa);
		limpaFormulario();
	}
	
	public void limpaFormulario() {
		this.pessoa = new Pessoa();
		this.endereco = new Endereco();
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
