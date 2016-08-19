
package br.com.projeto.controle;

import be.com.projeto.dao.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;

import br.com.projeto.modelo.*;
import br.com.projeto.util.FacesUtil;

@ManagedBean

@ViewScoped
public class CidadeMB {
	private Cidade objCidade = new Cidade();
	private List<Cidade> listaCidade = new ArrayList<Cidade>();
	private List<Estado> listaEstado = new ArrayList<Estado>();
	private List<Estado> listaEstFiltrado = new ArrayList<Estado>();
	private List<Cidade> listaCidadeFiltrado = new ArrayList<Cidade>();
	private ArrayList<Estado> comboEstado;
	private DAOGenerico dao = new DAOGenerico(); // instanciando a classe dao
													// generico
	private List<Estado> estadoSelecionado = new ArrayList<>();

	public void setListaCidadeFiltrado(List<Cidade> listaCidadeFiltrado) {
		this.listaCidadeFiltrado = listaCidadeFiltrado;
	}

	public CidadeMB() { // construtor da classe
		new Cidade();// preencherListaEstado();
	}

	public void criarNovoObjetoCidade() {
		objCidade = new Cidade();

	}

	public void inserirCidade() {
		dao.inserir(objCidade);
	}

	public void excluirCidade() {
		dao.excluir(objCidade);
	}

	public void editarCidade() {
		dao.alterar(objCidade);
	}

	public void carrega() {
		listaCidade = dao.listaComStatus(Cidade.class);
		listaEstado = dao.listaComStatus(Estado.class);

	}

	/*
	 * public List<Estado> completeText() {
	 * 
	 * 
	 * 
	 * List<Estado> results = dao.listaComStatus(Estado.class);
	 * 
	 * Estado estado = new Estado(); estado.setNome("testeeee");
	 * results.add(estado);
	 * 
	 * Estado estado1 = new Estado(); estado1.setNome("te");
	 * results.add(estado1);
	 * 
	 * Estado estado2 = new Estado(); estado2.setNome("teee");
	 * results.add(estado2);
	 * 
	 * Estado estado3 = new Estado(); estado3.setNome("eee");
	 * results.add(estado3);
	 * 
	 * return results;
	 * 
	 * }
	 */

	public List<Estado> completeText(String query) {

		listaEstado = dao.listaComStatus(Estado.class);

		List<Estado> results = new ArrayList<>();
		for (Estado e : listaEstado) {
			if (e.getNome().toLowerCase().startsWith(query)) {
				results.add(e);
			}
		}

		return results;
	}

	public Cidade getObjCidade() {
		return objCidade;
	}

	public void setObjCidade(Cidade objCidade) {
		this.objCidade = objCidade;
	}

	public List<Cidade> getListaCidade() {
		return listaCidade;
	}

	public void setListaCidade(List<Cidade> listaCidade) {
		this.listaCidade = listaCidade;
	}

	public ArrayList<Estado> getComboEstado() {
		return comboEstado;

	}

	public void setComboEstado(ArrayList<Estado> comboEstado) {
		this.comboEstado = comboEstado;
	}

	public List<Cidade> getListaCidadeFiltrado() {
		return listaCidadeFiltrado;
	}

	

	public List<Estado> getListaEstado() {
		return listaEstado;
	}

	public void setListaEstado(List<Estado> listaEstado) {
		this.listaEstado = listaEstado;
	}

	public List<Estado> getListaEstFiltrado() {
		return listaEstFiltrado;
	}

	public void setListaEstFiltrado(List<Estado> listaEstFiltrado) {
		this.listaEstFiltrado = listaEstFiltrado;
	}

	public List<Estado> getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(List<Estado> estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	
	

}
