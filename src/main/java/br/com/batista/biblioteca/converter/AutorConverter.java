package br.com.batista.biblioteca.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.batista.biblioteca.modelo.Autor;

@FacesConverter("autorConverter")
public class AutorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String id) {
		if (id == null || id.trim().isEmpty()) {
			return null;
		}
		
		Autor autor = new Autor();
		autor.setId(Integer.valueOf(id));

		return autor;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent component, Object objeto) {
		if (objeto == null) {
			return null;
		}
		
		Autor autor = (Autor) objeto;
		Integer id = autor.getId();
		
		return id.toString();
	}

}
