package br.com.batista.biblioteca.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.batista.biblioteca.dao.AutorDAO;
import br.com.batista.biblioteca.modelo.Autor;

@Model
public class AdminAutoresBean {

	private Autor autor = new Autor();

	@Inject
	private AutorDAO autorDao;

	@Transactional
	public void salvar() {
		autorDao.salvar(autor);
	}

	public List<Autor> listaAutores() {
		return autorDao.listaAutores();
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
