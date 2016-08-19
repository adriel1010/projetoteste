package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import be.com.projeto.dao.DAOGenerico;
import br.com.projeto.modelo.Aluno;


@FacesConverter(value = "alunoConverter", forClass = Aluno.class)
public class ConverterAluno implements Converter
{

	 @Override
	    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
	        if (string != null && !string.isEmpty()) {
	        	DAOGenerico dao = new DAOGenerico();
	        	
	            return  dao.buscarPorId(Aluno.class, Long.parseLong(string));
	        }
	        return null;
	    }

	    @Override
	    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
	        if (o != null && (o instanceof Aluno)) {
	            return String.valueOf(((Aluno) o).getId());
	        }

	        return null;
	    }

}