package br.com.batista.biblioteca.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.batista.biblioteca.dao.AutorDAO;
import br.com.batista.biblioteca.dao.LivroDAO;
import br.com.batista.biblioteca.modelo.Autor;
import br.com.batista.biblioteca.modelo.Livro;

@Model
public class AdminLivrosBean {

	private Livro livro = new Livro();
	private List<Integer> idsAutoresSelecionados = new ArrayList<>();
	private List<Autor> autores = new ArrayList<>();

	@Inject
	private LivroDAO livroDao;

	@Inject
	private AutorDAO autorDao;

	@PostConstruct
	public void carregaAutores() {
		this.autores = autorDao.listaAutores();
	}

	@Transactional
	public void salvar() {
		System.out.println("Salvando livro...");
		adicionaAutoresLivro();
		livroDao.salvar(livro);
		limpaFormulario();
	}

	public List<Livro> listaLivros() {
		return livroDao.listaLivros();
	}

	private void adicionaAutoresLivro() {
		for (Integer id : idsAutoresSelecionados) {
			this.livro.adicionaAutor(new Autor(id));
		}
	}

	public void limpaFormulario() {
		this.livro = new Livro();
		this.idsAutoresSelecionados = new ArrayList<>();
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public List<Integer> getIdsAutoresSelecionados() {
		return idsAutoresSelecionados;
	}

	public void setIdsAutoresSelecionados(List<Integer> idsAutoresSelecionados) {
		this.idsAutoresSelecionados = idsAutoresSelecionados;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
