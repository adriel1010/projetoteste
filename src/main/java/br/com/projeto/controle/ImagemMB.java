package br.com.projeto.controle;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped // a imagem será recaregada a cada clik
public class ImagemMB {
	@ManagedProperty("#{param.caminho}") 
	//caminho da foto
	private String caminho;
	//tamanho da foto; classe do primefaces q o grafic usa para guardar os dados 
	private StreamedContent foto;
	
	
	
	
	
	
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public StreamedContent getFoto() throws IOException {
		//isEmpty() -> caminho vazio
		//pega a foto em branco
		if(caminho == null || caminho.isEmpty()){
			 Path path = Paths.get("C:/instaladores/uploads/banco.jpg"); // carregando a foto que não tem nada
			InputStream stream = Files.newInputStream(path);//guarda o fluxo de bits da foto
			foto = new DefaultStreamedContent(stream);// compiando a foto 
		}else{
			//pega a foto verdadeira
			 Path path = Paths.get(caminho); // carregando a foto que não tem nada
				InputStream stream = Files.newInputStream(path);//guarda o fluxo de bits da foto
				foto = new DefaultStreamedContent(stream);// compiando a foto 
		}
		return foto;
	}
	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}

}
