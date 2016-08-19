package be.com.projeto.dao;

import java.lang.reflect.Method;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import br.com.projeto.modelo.Aluno;
import br.com.projeto.modelo.Estado;
import br.com.projeto.util.FacesUtil;

public class DAOGenerico {
	private static EntityManager entityManager;
	EntityManager em = Persistence.createEntityManagerFactory("ProjetoUp").createEntityManager();

	public void inserir(Object objeto) {
		try {
			em.getTransaction().begin();
			if (!em.getTransaction().isActive()) {
				em.getTransaction().begin();
			}
			em.persist(objeto);
			em.getTransaction().commit();
			FacesUtil.msgSucesso(objeto.getClass().getSimpleName() + "Cadastrado com Sucesso !!!");
		} catch (Exception e) {
			FacesUtil.msgErro("Erro ao Cadastrar o " + objeto.getClass().getSimpleName());
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}


	public void alterar(Object objeto) {
		entityManager = ConexaoBanco.getConexao().getEm();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(objeto);
			entityManager.getTransaction().commit();
			FacesUtil.msgSucesso("Alterado com Sucesso !!!");
		} catch (Exception e) {
			FacesUtil.msgErro("Erro ao Alterar o ");
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public List listaComStatus(Class classe) {
		Query query = null;
		try {
			entityManager = ConexaoBanco.getConexao().getEm();
			entityManager.getTransaction().begin();
			query = entityManager.createQuery("from " + classe.getSimpleName() + "");
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}

	public List listarCondicao(Class classe, String condicao) {
		Query query = null;
		try {
			entityManager = ConexaoBanco.getConexao().getEm();
			entityManager.getTransaction().begin();
			query = entityManager.createQuery("from " + classe.getSimpleName() + " where " + condicao);
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}
	public List listarCondicaoOrdenado(Class classe) {
		Query query = null;
		try {
			entityManager = ConexaoBanco.getConexao().getEm();
			entityManager.getTransaction().begin();
			query = entityManager.createQuery("from " + classe.getSimpleName() + " order by nome DESC LIMIT 1");
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}
	
	public List listaPorNome(Class classe, Long nome) {
		Query query = null;
		try {
			entityManager = ConexaoBanco.getConexao().getEm();
			entityManager.getTransaction().begin();
			query = entityManager.createQuery("from " + classe.getSimpleName() + "where id=" + nome);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}

	public List listarPorId(Class classe, Long id) {
		Query query = null;
		try {
			entityManager = ConexaoBanco.getConexao().getEm();
			entityManager.getTransaction().begin();
			query = entityManager.createQuery("from " + classe.getSimpleName() + " where id=" + id);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
		}
		return query.getResultList();
	}

	public Object buscarPorId(Class classe, Long id) {
		Object retornando = null;
		try {
			entityManager = ConexaoBanco.getConexao().getEm();
			// entityManager.getTransaction().begin();
			retornando = entityManager.find(classe, id);
			// entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// entityManager.getTransaction().rollback();
		}

		return retornando;
	}

	public void excluir(Object objeto) {
		
		try {
			
			entityManager = ConexaoBanco.getConexao().getEm();
			entityManager.getTransaction().begin();
	    	entityManager.remove(objeto);
			entityManager.getTransaction().commit();
			FacesUtil.msgSucesso(objeto.getClass().getSimpleName() + " Removido com Sucesso !!!");
		} catch (Exception e) {
			
			
			FacesUtil.msgErro("Registro não pode ser removido");
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			
			
		}
	}

}
