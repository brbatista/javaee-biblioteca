package br.com.batista.biblioteca.bean;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.batista.biblioteca.dao.EmprestimoDAO;
import br.com.batista.biblioteca.dao.StatusDAO;
import br.com.batista.biblioteca.modelo.Emprestimo;
import br.com.batista.biblioteca.modelo.Status;

@Model
public class DevolucaoBean {

	private Emprestimo emprestimo;
	private Integer id;
	private Status status;

	@Inject
	private EmprestimoDAO emprestimoDao;

	@Inject
	private StatusDAO statusDao;

	public void carregaEmprestimo() {
		this.emprestimo = emprestimoDao.buscaPorId(id);
		this.status = statusDao.buscaPorEmprestimo(emprestimo);
	}

	@Transactional
	public String efetuaDevolucao() {
		status.setDevolvido(true);
		statusDao.atualizar(status);
		return "/sistema/historico?faces-redirect=true";
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
