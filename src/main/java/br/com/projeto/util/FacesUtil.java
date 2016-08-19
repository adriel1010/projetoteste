package br.com.projeto.util;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;

public class FacesUtil {

	 public static void msgSucesso(String message){
	        //primeiro � o grau do erro 2 � a mensagem detalhada 3
	        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
	        // camputrar o contexto da aplica��o 
	        FacesContext facesContent = FacesContext.getCurrentInstance();
	        // quando precisa capturar coisas do navegador 
	        ExternalContext externalContext = facesContent.getExternalContext();
	        // vai capturar o contexto externo
	        
	        //flax � a memoria q � usada durante as requisi��o 
	        // a mensagem dura apenas uma requisi��o 
	        //ent�o precisa falar para ela permanecer
	        //capturar a msg durante o transito de informa��es 
	        Flash flash = externalContext.getFlash();
	  
	        //diz para a msg prermanecer durante toda a requisi��o
	        flash.setKeepMessages(true);
	        
	        facesContent.addMessage(null, facesMessage);
	    } 
	    public static void msgErro(String message){
	         FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
	        // camputrar o contexto da aplica��o 
	        FacesContext facesContent = FacesContext.getCurrentInstance();
	        
	            ExternalContext externalContext = facesContent.getExternalContext();
	        // vai capturar o contexto externo
	        
	        //flax � a memoria q � usada durante as requisi��o 
	        // a mensagem dura apenas uma requisi��o 
	        //ent�o precisa falar para ela permanecer
	        //capturar a msg durante o transito de informa��es 
	        Flash flash = externalContext.getFlash();
	  
	        //diz para a msg prermanecer durante toda a requisi��o
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
