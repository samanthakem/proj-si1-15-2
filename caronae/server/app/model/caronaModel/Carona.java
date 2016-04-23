package model.caronaModel;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import model.Endereco;
import model.Horario;
import play.libs.Json;

/**
 * @author Samantha Monteiro
 */
public class Carona {

	private String id;

	private List<String> idsPassageiros;

	private String idMotorista;

	private int qntVagasDisponiveis = 4;

	private Endereco pontoInicial;

	private Endereco destino;

	private Horario horario;

	public Carona() {
		this.idsPassageiros = new ArrayList<String>();
	}

	/**
	 * Construtor da entidade {@Carona}
	 * 
	 * @param {String} id id da carona sendo criada
	 * @param {String} idMotorista id do motorista responsavel pela carona
	 * @param {Object} pontoInicial ponto inicial da carona
	 * @param {Object} destino destino da carona
	 * @param {Object} horario horario da carona
	 */
	public Carona(String id, String idMotorista, Endereco pontoInicial,
			Endereco destino, Horario horario) {
		this();
		setId(id);
		setIdMotorista(idMotorista);
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

	public JsonNode toJson() {
		return Json.toJson(this);
	}

}
