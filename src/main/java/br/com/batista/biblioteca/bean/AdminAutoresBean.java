package br.com.batista.biblioteca.bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.batista.biblioteca.dao.AutorDAO;
import br.com.batista.biblioteca.modelo.Autor;

@ViewScoped
@Named
public class AdminAutoresBean implements Serializable {

	private Autor autor = new Autor();

	@Inject
	private AutorDAO autorDao;

	@Inject
	private FacesContext facesContext;

	@Transactional
	public void salvar() {
		if (autor.getId() == null) {
			autorDao.salvar(autor);
			limpaFormulario();
			facesContext.addMessage(null, new FacesMessage("Autor salvo com sucesso"));
		} else {
			autorDao.atualizar(autor);
			limpaFormulario();
			facesContext.addMessage(null, new FacesMessage("Autor atualizado com sucesso"));
		}
	}

	@Transactional
	public void remover(Autor autor) {
		autorDao.remover(autor);
		facesContext.addMessage(null, new FacesMessage("Autor removido"));
	}

	public void editar(Autor autor) {
		this.autor = autor;
	}

	public void limpaFormulario() {
		this.autor = new Autor();
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
