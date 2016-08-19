
package br.com.projeto.controle;

import be.com.projeto.dao.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.projeto.modelo.*;
import br.com.projeto.util.FacesUtil;

/*
 * Anotação que reflete o nome que usado para chamar essa classe
 * através da View. resumindo a função do managebean é estar intermediando entre a página e o seu modelo.
 * */
@ManagedBean
/*
 * Este é o escopo da classe, que diz respeito até quando nosso objeto
 * continuará persistente em memória. Como utilizamos o ViewScoped ele
 * permanecerá até o fechamento da View, ou da página, se assim preferir.
 * */
@ViewScoped
public class EstaboMB {
    private Estado objEstado = new Estado();
    private Estado estado;
    private List<Estado> listaEstado = new ArrayList<Estado>();
    private List<Estado> listaEstadoPorCondicao = new ArrayList<Estado>();
    private List<Estado> listaEstadoFiltrado = new ArrayList<Estado>();
    private DAOGenerico dao= new DAOGenerico(); // instanciando a classe dao generico 
    
    
  public EstaboMB() { // construtor da classe
   new Estado();//    preencherListaEstado();
 }

 
 public void criarNovoObjetoEstado(){
     objEstado = new Estado();
     
 }
public void inserirEstado(){
    if( getObjEstado().getId() == null){
        dao.inserir(getObjEstado());
    }else{
        dao.inserir(getObjEstado());
    }
}
 
public void removerEstado(){
	dao.excluir(getObjEstado());
}


public void alterar(){
	dao.alterar(objEstado);
}


    public void carrega(){
    	listaEstado = dao.listaComStatus(Estado.class);
   }
    
    
 public void carregarCadastro(){
         try{
        	String valor = FacesUtil.getParam("codigoEstado");
        	
        	if(valor != null){
        		Long codig = Long.parseLong(valor);
        	objEstado = (Estado) dao.buscarPorId(Estado.class, codig);
        
        	}
         
     }catch(RuntimeException ex){
                 
         FacesUtil.msgErro("Erro ao obter Fabricantes :" + ex);
     } 
       
   }
 
 public void buscarPorNome(){
	 listaEstado =  dao.listarCondicao(Estado.class, "nome='"+objEstado.getNome()+"'");
	
	
 }
    
    
    public Estado getObjEstado() {
        return objEstado;
    }

    public void setObjEstado(Estado objEstado) {
        this.objEstado = objEstado;
    }

   
    public List<Estado> getListaEstado() {
        return listaEstado;
    }

  
    public void setListaEstado(List<Estado> listaEstado) {
        this.listaEstado = listaEstado;
    }
    

    
    public List<Estado> getListaEstadoFiltrado() {
		return listaEstadoFiltrado;
	}


	public void setListaEstadoFiltrado(List<Estado> listaEstadoFiltrado) {
		this.listaEstadoFiltrado = listaEstadoFiltrado;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public List<Estado> getListaEstadoPorCondicao() {
		return listaEstadoPorCondicao;
	}


	public void setListaEstadoPorCondicao(List<Estado> listaEstadoPorCondicao) {
		this.listaEstadoPorCondicao = listaEstadoPorCondicao;
	}
   
	




}



