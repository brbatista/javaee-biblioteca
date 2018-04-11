package br.com.batista.biblioteca.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.primefaces.model.DualListModel;

import br.com.batista.biblioteca.dao.EmprestimoDAO;
import br.com.batista.biblioteca.dao.LivroDAO;
import br.com.batista.biblioteca.dao.PessoaDAO;
import br.com.batista.biblioteca.modelo.Emprestimo;
import br.com.batista.biblioteca.modelo.Livro;
import br.com.batista.biblioteca.modelo.Pessoa;

@ViewScoped
@Named
public class EmprestimoBean implements Serializable{

	private Emprestimo emprestimo = new Emprestimo();
	private List<Pessoa> pessoas = new ArrayList<>();

	private List<Livro> source = new ArrayList<>();
	private List<Livro> target = new ArrayList<>();
	private DualListModel<Livro> livros;
	
	@Inject
	private FacesContext facesContext;

	@Inject
	private EmprestimoDAO emprestimoDao;

	@Inject
	private LivroDAO livroDao;

	@Inject
	private PessoaDAO pessoaDao;

	@Transactional
	public void salvar() {
		emprestimo.setLivros(livros.getTarget());
		System.out.println("Gravando emprestimo");
		emprestimoDao.salvar(emprestimo);
		facesContext.addMessage(null, new FacesMessage("Empréstimo gravado com sucesso"));
		limpaFormulario();
	}

	private void limpaFormulario() {
		this.emprestimo = new Emprestimo();
		carregar();
	}

	@PostConstruct
	public void carregar() {
		this.pessoas = pessoaDao.listar();
		source = livroDao.listaLivros();
		livros = new DualListModel<Livro>(source, target);
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public DualListModel<Livro> getLivros() {
		return livros;
	}

	public void setLivros(DualListModel<Livro> livros) {
		this.livros = livros;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Livro> getSource() {
		return source;
	}

	public void setSource(List<Livro> source) {
		this.source = source;
	}

	public List<Livro> getTarget() {
		return target;
	}

	public void setTarget(List<Livro> target) {
		this.target = target;
	}

}
