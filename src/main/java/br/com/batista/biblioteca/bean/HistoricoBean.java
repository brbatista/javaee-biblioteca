package br.com.batista.biblioteca.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.batista.biblioteca.dao.EmprestimoDAO;
import br.com.batista.biblioteca.modelo.Emprestimo;

@Named
@ViewScoped
public class HistoricoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Emprestimo> emprestimos;

	@Inject
	private EmprestimoDAO emprestimoDao;

	@PostConstruct
	public void carregar() {
		emprestimos = emprestimoDao.listar();
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	public String carregaEmprestimo(Integer id) {
		return "/sistema/devolucao.xhtml?faces-redirect=true&id="+id;
	}

}
