import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import be.com.projeto.dao.ConexaoBanco;
import br.com.projeto.controle.CidadeMB;
import br.com.projeto.controle.EstaboMB;
import br.com.projeto.modelo.Aluno;
import br.com.projeto.modelo.Cidade;
import br.com.projeto.modelo.Estado;
import br.com.projeto.modelo.Evento;
import be.com.projeto.dao.*;

public class Teste {

	public static void main(String[] args) {

		/*
		 * // teste inserir estado DAOGenerico dao = new DAOGenerico(); Estado
		 * estado = new Estado(); estado.setNome("test"); estado.setSigla("Ee");
		 * dao.inserir(estado);
		 */
		/*
		 * // teste alterar estado DAOGenerico dao = new DAOGenerico(); Estado
		 * estado = new Estado(); estado.setId(1L); estado.setNome("st");
		 * estado.setSigla("Ee"); dao.alterar(estado);
		 */

		/*
		 * // teste buscar estado DAOGenerico dao = new DAOGenerico(); Estado
		 * estado = new Estado();
		 * 
		 * long valor = dao.buscarPorId(Estado, 1L); erroooo
		 */

		/*
		 * // teste inserir cidade DAOGenerico dao = new DAOGenerico(); Cidade
		 * cidade = new Cidade(); cidade.setNome("cidade de teste");
		 * cidade.setEstado(valor); dao.inserir(estado);
		 * 
		 * 
		 * /* // teste alterar estado DAOGenerico dao = new DAOGenerico();
		 * Estado estado = new Estado(); estado.setId(1L); estado.setNome("st");
		 * estado.setSigla("Ee"); dao.alterar(estado);
		 */

		/*
		 * // teste inserir evento DAOGenerico dao = new DAOGenerico(); Evento
		 * evento = new Evento(); // evento.setData('0208-20-02');
		 * evento.setDescricao("evento de teste"); evento.setHora("18:15");
		 * evento.setLocal("não sei ainda"); dao.inserir(evento);
		 * 
		 */

		/*
		 * // teste alterar evento DAOGenerico dao = new DAOGenerico(); Evento
		 * evento = new Evento(); evento.setId(1); //
		 * evento.setData('0208-20-02'); evento.setDescricao("even teste");
		 * evento.setHora("18:00"); evento.setLocal("já sei ainda");
		 * dao.alterar(evento);
		 * 
		 */
		/*
		 * // teste alterar evento DAOGenerico dao = new DAOGenerico(); Evento
		 * evento = new Evento(); evento.setId(1); //
		 * evento.setData('0208-20-02'); evento.setDescricao("even teste");
		 * evento.setHora("18:00"); evento.setLocal("já sei ainda");
		 * dao.alterar(evento);
		 */
		DAOGenerico dao = new DAOGenerico();
		/*
		 * List <Estado> li = dao.listaComStatus(Estado.class);
		 * 
		 * for(Estado pessoa : li){ System.out.println(pessoa); }
		 */

		// dao.buscarPorId(Estado.class, 1l);

		// dao.listarCondicao(Estado.class,"id=1");

		// dao.listarPorId(Estado.class, 1L);

		// EstaboMB est = new EstaboMB();
		// est.carrega();

		/*
		 * listar por id Estado estado = (Estado) dao.buscarPorId(Estado.class,
		 * 1L); System.out.println(estado.getNome());
		 */

		/*
		 * EstaboMB esta = new EstaboMB(); Estado estado = (Estado)
		 * dao.buscarPorId(Estado.class, 1L);
		 * 
		 * System.out.println(estado.getNome() + estado.getId());
		 */
		/*
		 * dao.apagar(estado);
		 * 
		 */ // esta.excluirEstado(estado);

		/*
		 * Cidade cid = new Cidade(); cid.setNome("testando 23");
		 * cid.setEstado(estado); dao.inserir(cid);
		 */

		/*
		 * Cidade cidade = new Cidade(); cidade.setNome("t");
		 * cidade.setEstado(estado); dao.inserir(cidade);
		 */

		/*
		 * Evento event = new Evento(); event.setDescricao("tes");
		 * dao.inserir(event);
		 */

		/*
		 * Estado estado = (Estado) dao.buscarPorId(Estado.class, 1L);
		 * 
		 * dao.excluir(estado);
		 */
		/*
		 * Evento e = new Evento(); e.setDescricao("teste add");
		 * e.setData("DD/MM/YYYY");
		 * 
		 * 
		 * dao.inserir(e);
		 */
		/*
		 * List<Estado> est = dao.listarPorId(Estado.class, 1L);
		 * 
		 * for(Estado ee : est){ System.out.println(ee.getSigla()); }
		 * 
		 */
	/*	List<Estado> est = dao.listarCondicao(Estado.class, "nome='t'");

		for (Estado ee : est) {
			System.out.println(ee.getSigla());
		}*/
		
		
		List <Aluno> al = dao.listarCondicaoOrdenado(Aluno.class);
		for(Aluno a : al){
		
		System.out.println(a.getId());
		}
		}
	

}
