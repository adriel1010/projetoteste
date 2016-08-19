
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
 * Anota��o que reflete o nome que usado para chamar essa classe
 * atrav�s da View. resumindo a fun��o do managebean � estar intermediando entre a p�gina e o seu modelo.
 * */
@ManagedBean
/*
 * Este � o escopo da classe, que diz respeito at� quando nosso objeto
 * continuar� persistente em mem�ria. Como utilizamos o ViewScoped ele
 * permanecer� at� o fechamento da View, ou da p�gina, se assim preferir.
 */
@ViewScoped
public class InscreverEventoMB {
	private PresencaEvento objInscEvento = new PresencaEvento();
	// private Estado estado;
	private List<PresencaEvento> listaInscEvento = new ArrayList<PresencaEvento>();
	private List<Aluno> listaAluno = new ArrayList<Aluno>();
	private List<Evento> listaEventos = new ArrayList<Evento>();
	// private List<PresencaEvento> listaInscEvento = new
	// ArrayList<PresencaEvento>();
	private DAOGenerico dao = new DAOGenerico(); // instanciando a classe dao
													// generico

	public InscreverEventoMB() { // construtor da classe
		new Estado();// preencherListaEstado();
	}

	public void criarNovoObjetoEstado() {
		objInscEvento = new PresencaEvento();

	}
	public void carrega() {
		listaEventos = dao.listaComStatus(Evento.class);
		listaAluno = dao.listaComStatus(Aluno.class);
		listaInscEvento = dao.listaComStatus(PresencaEvento.class);
	}

	public void inserirPresencaEvento() {
		dao.inserir(objInscEvento);

	}
	public void alterarPresencaEvento() {
		dao.alterar(objInscEvento);

	}
	
	public void excluirPresencaEvento() {
		dao.excluir(objInscEvento);

	}
	
/*
	public void alterar() {
		dao.alterar(objEstado);
	}

	

	public void carregarCadastro() {
		try {
			String valor = FacesUtil.getParam("codigoEstado");

			if (valor != null) {
				Long codig = Long.parseLong(valor);
				objInscEvento = (Estado) dao.buscarPorId(Estado.class, codig);

			}

		} catch (RuntimeException ex) {

			FacesUtil.msgErro("Erro ao obter Fabricantes :" + ex);
		}

	}*/

	public PresencaEvento getObjInscEvento() {
		return objInscEvento;
	}

	public void setObjInscEvento(PresencaEvento objInscEvento) {
		this.objInscEvento = objInscEvento;
	}

	public List<PresencaEvento> getListaInscEvento() {
		return listaInscEvento;
	}

	public void setListaInscEvento(List<PresencaEvento> listaInscEvento) {
		this.listaInscEvento = listaInscEvento;
	}

	public DAOGenerico getDao() {
		return dao;
	}

	public void setDao(DAOGenerico dao) {
		this.dao = dao;
	}

	public List<Aluno> getListaAluno() {
		return listaAluno;
	}

	public void setListaAluno(List<Aluno> listaAluno) {
		this.listaAluno = listaAluno;
	}

	public List<Evento> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<Evento> listaEventos) {
		this.listaEventos = listaEventos;
	}

}
