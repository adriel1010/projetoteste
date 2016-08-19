
package br.com.projeto.controle;

import be.com.projeto.dao.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.projeto.modelo.*;
import br.com.projeto.util.FacesUtil;


@ManagedBean

@ViewScoped
public class AlunoMB {
    private Aluno objAluno = new Aluno();
    private List<Aluno> listaAluno = new ArrayList<Aluno>();
    private List<Cidade> listaCidade = new ArrayList<Cidade>();
    private DAOGenerico dao= new DAOGenerico(); // instanciando a classe dao generico 

  public AlunoMB() { // construtor da classe
     new Cidade();//    preencherListaEstado();
 }

 
 public void criarNovoObjetoEstado(){
     objAluno = new Aluno();
     
     
     
 }
 public void inserirAluno(){
	 
	 
	 if(objAluno.getCaminho() == null){
		 FacesUtil.msgErro("O campo foto é obrigatório");
		 return;
	 }
	  dao.inserir(objAluno);
	  
	  
	  try{
			 //primeiro ele está salvando e vai retorna 
			Aluno alun = (Aluno) dao.buscarPorId(Aluno.class, 1L);

			 Path origem = Paths.get(objAluno.getCaminho()); // pegando a origem da foto
			 Path destino = Paths.get("C:/instaladores/uploads/" + objAluno.getNome() + ".jpg");
			 
			 Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
			 FacesUtil.msgSucesso("Upload Realizado Com Sucesso !!!");
			 }catch (IOException e) {
				FacesUtil.msgErro("erro ao salvar a imagem" + e);
				e.printStackTrace();
			}
}
 
 
 
 
 public void editarAluno(){
	
	 //pats é o caminho para o arquivo
	 try{
	 Path arquivo = Paths.get("C:/instaladores/uploads/" + objAluno.getNome() + ".jpg");
	 Files.delete(arquivo);
	 }catch (IOException e) {
		
	}
	// objAluno.setCaminho("C:/instaladores/uploads/" + objAluno.getNome() + ".jpg");
	 dao.alterar(objAluno);
	 
	 try{	
		 Path origem = Paths.get(objAluno.getCaminho()); // pegando a origem da foto
		 Path destino = Paths.get("C:/instaladores/uploads/" + objAluno.getNome() + ".jpg");
		 
		 Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
		 FacesUtil.msgSucesso("Upload Realizado Com Sucesso !!!");
		 }catch (IOException e) {
			FacesUtil.msgErro("erro ao salvar a imagem" + e);
			e.printStackTrace();
		}
 }
 
 public void excluirAluno(){
	 dao.excluir(objAluno);
	 
	 //pats é o caminho para o arquivo
	 try{
	 Path arquivo = Paths.get("C:/instaladores/uploads/" + objAluno.getNome() + ".jpg");
	 Files.delete(arquivo);
	 }catch (IOException e) {
		
	}
 }
 
 public void upload(FileUploadEvent evento )  {
	try{	 
	UploadedFile arquivoUpload = evento.getFile(); // representa o arquivo do upload
	Path arquivoTemp = Files.createTempFile(null,null); //1 parametro é o nome temporario / 2 parametro extenção // patvh ele guarda a referenca do arquivo
	Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING); //está fazendo uma copia do arquivo que esta na linha 57 "que é a origem " para a linha 58 que é o destino é a origem do arquivo arquivoUpload.getInputstream()
	objAluno.setCaminho(arquivoTemp.toString());


	
	}catch (IOException e) {
		FacesUtil.msgErro("erro ao realizar upload");
		e.printStackTrace();
	}
	
	
	
 }
 


    public void carrega(){
    	listaAluno = dao.listaComStatus(Aluno.class);
    	listaCidade = dao.listaComStatus(Cidade.class);
    	
    	
    }

public Aluno getObjAluno() {
	return objAluno;
}


public void setObjAluno(Aluno objAluno) {
	this.objAluno = objAluno;
}


public List<Aluno> getListaAluno() {
	return listaAluno;
}


public void setListaAluno(List<Aluno> listaAluno) {
	this.listaAluno = listaAluno;
}





public DAOGenerico getDao() {
	return dao;
}


public void setDao(DAOGenerico dao) {
	this.dao = dao;
}


public List<Cidade> getListaCidade() {
	return listaCidade;
}


public void setListaCidade(List<Cidade> listaCidade) {
	this.listaCidade = listaCidade;
}
    
  


}



