package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import be.com.projeto.dao.DAOGenerico;
import br.com.projeto.modelo.Cidade;


@FacesConverter(value = "converterCidade", forClass = Cidade.class)
public class ConverterCidade implements Converter
{

	 @Override
	    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
	        if (string != null && !string.isEmpty()) {
	        	DAOGenerico dao = new DAOGenerico();
	        	
	            return  dao.buscarPorId(Cidade.class, Long.parseLong(string));
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
	        if (o != null && (o instanceof Cidade)) {
	            return String.valueOf(((Cidade) o).getId());
	        }

	        return null;
	    }

}