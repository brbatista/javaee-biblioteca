package br.com.batista.biblioteca.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.primefaces.model.DualListModel;

import br.com.batista.biblioteca.dao.EmprestimoDAO;
import br.com.batista.biblioteca.dao.LivroDAO;
import br.com.batista.biblioteca.dao.PessoaDAO;
import br.com.batista.biblioteca.modelo.Emprestimo;
import br.com.batista.biblioteca.modelo.Livro;
import br.com.batista.biblioteca.modelo.Pessoa;

@Model
public class EmprestimoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Emprestimo emprestimo = new Emprestimo();
	private List<Pessoa> pessoas = new ArrayList<>();

	private List<Livro> source;
	private List<Livro> target;
	private DualListModel<Livro> livros;

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
		target = new ArrayList<>();
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
