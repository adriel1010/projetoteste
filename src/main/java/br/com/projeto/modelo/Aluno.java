package br.com.projeto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Aluno {

	 // está dizerndo que será uma chave primaria e será gerada automaticamente
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;

		//tamanho da coluna, não nulo 
		@Column(length = 50, nullable=false)
		private String nome;
		
		@Column(length = 50, nullable=false)
		private char matricula;
	
		@Column(length = 50, nullable=false)
	   private String rua;
	   
		
		@Column(length = 10)
	   private String numero;
	   
		@Column(length=20)
	   private String celular;
	   
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "id_cidade", referencedColumnName = "id", nullable = false)
	   private Cidade cidade;
		
		//é uma variavel do produto porem serve para guardar informações temporarias ou seja ela não gera coluna no banco 
		@Transient 
		private String caminho;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public char getMatricula() {
			return matricula;
		}

		public void setMatricula(char matricula) {
			this.matricula = matricula;
		}

		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public String getNumero() {
			return numero;
		}

		public void setNumero(String numero) {
			this.numero = numero;
		}

		public String getCelular() {
			return celular;
		}

		public void setCelular(String celular) {
			this.celular = celular;
		}

		public Cidade getCidade() {
			return cidade;
		}

		public void setCidade(Cidade cidade) {
			this.cidade = cidade;
		}

		public String getCaminho() {
			return caminho;
		}

		public void setCaminho(String caminho) {
			this.caminho = caminho;
		}
		
	
}
