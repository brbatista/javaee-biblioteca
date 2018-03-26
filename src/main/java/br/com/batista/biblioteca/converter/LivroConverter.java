package br.com.batista.biblioteca.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.batista.biblioteca.modelo.Livro;

@FacesConverter("livroConverter")
public class LivroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String id) {
		if (id == null || id.trim().isEmpty()) {
			return null;
		}
		
		Livro livro = new Livro();
		livro.setId(Integer.valueOf(id));

		return livro;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent component, Object objeto) {
		if (objeto == null) {
			return null;
		}
		
		Livro livro = (Livro) objeto;
		Integer id = livro.getId();
		
		return id.toString();
	}

}
