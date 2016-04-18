package model.caronaModel;

import java.util.ArrayList;
import java.util.List;
import model.Endereco;
import model.Entidade;
import model.Horario;

/**
 * @author Samantha Monteiro
 */
public class Carona extends Entidade {
	
	private String id;
	
	private List<String> idsPassageiros;

	private String idMotorista;

	private int qntVagasDisponiveis;

	private Endereco pontoInicial;

	private Endereco destino;

	private Horario horario;

	public Carona() {
		this.idsPassageiros = new ArrayList<String>();
	}
	
	/**
	 * Construtor da entidade {@Carona}
	 * @param {String} id
	 * 		id da carona sendo criada
	 * @param {String} idMotorista
	 * 		id do motorista responsavel pela carona
	 * @param {int} qntVagasDisponiveis
	 * 		quantidade de vagas disponiveis para carona
	 * @param {Object} pontoInicial
	 * 		ponto inicial da carona
	 * @param {Object} destino
	 * 		destino da carona
	 * @param {Object} horario
	 * 		horario da carona
	 */
	public Carona(String id, String idMotorista, int qntVagasDisponiveis, Endereco pontoInicial, Endereco destino, Horario horario) {
		this();
		setId(id);
		setIdMotorista(idMotorista);
		setQntVagasDisponiveis(qntVagasDisponiveis);
		setPontoInicial(pontoInicial);
		setDestino(destino);
		setHorario(horario);
	}
	
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
	public Horario getHorario() {
		return horario;
	}
	
	public List<String> getIdsPassageiros() {
		return idsPassageiros;
	}
	
	
	public void setIdsPassageiros(List<String> idsPassageiros) {
		this.idsPassageiros = idsPassageiros;
	}
	
	public void setDestino(Endereco destino) {
		this.destino = destino;
	}
	
	public Endereco getDestino() {
		return destino;
	}
	
	public Endereco getPontoInicial() {
		return pontoInicial;
	}
	
	public void setPontoInicial(Endereco pontoInicial) {
		this.pontoInicial = pontoInicial;
	}
	
	public int getQntVagasDisponiveis() {
		return qntVagasDisponiveis;
	}

	public void setQntVagasDisponiveis(int qntVagasDisponiveis) {
		this.qntVagasDisponiveis = qntVagasDisponiveis;
	}

	public void setIdMotorista(String idMotorista) {
		this.idMotorista = idMotorista;
	}
	
	public String getIdMotorista() {
		return idMotorista;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
}
