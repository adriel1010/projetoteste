package br.com.projeto.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class FacesUtil {

	 public static void msgSucesso(String message){
	        //primeiro é o grau do erro 2 é a mensagem detalhada 3
	        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
	        // camputrar o contexto da aplicação 
	        FacesContext facesContent = FacesContext.getCurrentInstance();
	        // quando precisa capturar coisas do navegador 
	        ExternalContext externalContext = facesContent.getExternalContext();
	        // vai capturar o contexto externo
	        
	        //flax é a memoria q é usada durante as requisição 
	        // a mensagem dura apenas uma requisição 
	        //então precisa falar para ela permanecer
	        //capturar a msg durante o transito de informações 
	        Flash flash = externalContext.getFlash();
	  
	        //diz para a msg prermanecer durante toda a requisição
	        flash.setKeepMessages(true);
	        
	        facesContent.addMessage(null, facesMessage);
	    } 
	    public static void msgErro(String message){
	         FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
	        // camputrar o contexto da aplicação 
	        FacesContext facesContent = FacesContext.getCurrentInstance();
	        
	            ExternalContext externalContext = facesContent.getExternalContext();
	        // vai capturar o contexto externo
	        
	        //flax é a memoria q é usada durante as requisição 
	        // a mensagem dura apenas uma requisição 
	        //então precisa falar para ela permanecer
	        //capturar a msg durante o transito de informações 
	        Flash flash = externalContext.getFlash();
	  
	        //diz para a msg prermanecer durante toda a requisição
	        flash.setKeepMessages(true);
	        facesContent.addMessage(null, facesMessage);
	    }
	    
	    // vai estrair as coisas da url
	    public static String getParam(String nome){
	          FacesContext facesContent = FacesContext.getCurrentInstance();
	          // pegando o contexto externo
	          ExternalContext externalContext = facesContent.getExternalContext();
	          
	         // vem o nome e a chave 
	         Map<String, String> parametros = externalContext.getRequestParameterMap();
	         //pega apenas o nome 
	         String valor = parametros.get(nome);
	         return valor;
	    }


	
}
