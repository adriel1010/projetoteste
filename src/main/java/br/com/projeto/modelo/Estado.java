package br.com.projeto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


//dizendo que esse estado é uma entidade do hibernate "ira gerar uma tabela com o nome da classe"
@Entity

public class Estado {

	// está dizerndo que será uma chave primaria e será gerada automaticamente
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message="O campo sigla é obrigatório")
	@Size(max=2, message="O Campo sigla suporta apenas Dois caracteres")
	//tamanho da coluna, não nulo 
	@Column(length = 2, nullable=false)
	private String sigla;
	
	@NotEmpty(message="O campo Nome é obrigatório")
	@Size(max=50, message="O Campo Nome suporta apenas Dois caracteres")
	@Column(length = 50, nullable=false)
	private String nome;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


}
