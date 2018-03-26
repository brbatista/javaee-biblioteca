package br.com.batista.biblioteca.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.batista.biblioteca.modelo.Pessoa;

@FacesConverter("pessoaConverter")
public class PessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent component, String id) {
		if (id == null || id.trim().isEmpty()) {
			return null;
		}

		Pessoa pessoa = new Pessoa();
		pessoa.setId(Integer.valueOf(id));

		return pessoa;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent component, Object objeto) {
		if (objeto == null) {
			return null;
		}

		Pessoa pessoa = (Pessoa) objeto;
		Integer id = pessoa.getId();

		return id.toString();
	}

}
