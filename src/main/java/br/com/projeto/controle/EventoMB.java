package br.com.projeto.controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import be.com.projeto.dao.DAOGenerico;
import br.com.projeto.modelo.Estado;
import br.com.projeto.modelo.Evento;

@ManagedBean
@ViewScoped
public class EventoMB {
	
	  public EventoMB() { // construtor da classe
		   new Evento();//    preencherListaEstado();
		 }

	  
	

		DAOGenerico dao = new DAOGenerico();
	    private Evento objEvento = new Evento();
	    private List<Evento> listaEvento = new ArrayList<Evento>();
	    private List<Evento> listaEventoFiltrado = new ArrayList<Evento>();
		
	    public void criarNovoEvento(){
			  objEvento = new Evento();
		  }
	    
	    
	    public void inserirEvento(){
	    	
	    	if( getObjEvento().getId() == null){
	    		dao.inserir(getObjEvento());
	    	}else{
	    		dao.inserir(getObjEvento());
	    	}
	    }
	    
	    
	    public void excluirEvento(){
	    	dao.excluir(objEvento);
	    }
	    
	    public void alterarEvento(){
	    	dao.alterar(objEvento);
	    }
	    
	    

	    public void carrega(){
	    	listaEvento = dao.listaComStatus(Evento.class);
	    	
	    	
	    }
	    
	    
	    
	    public Evento getObjEvento() {
			return objEvento;
		}
		public void setObjEvento(Evento objEvento) {
			this.objEvento = objEvento;
		}
		public List<Evento> getListaEvento() {
			return listaEvento;
		}
		public void setListaEvento(List<Evento> listaEvento) {
			this.listaEvento = listaEvento;
		}
		public List<Evento> getListaEventoFiltrado() {
			return listaEventoFiltrado;
		}
		public void setListaEventoFiltrado(List<Evento> listaEventoFiltrado) {
			this.listaEventoFiltrado = listaEventoFiltrado;
		}
	   

}

