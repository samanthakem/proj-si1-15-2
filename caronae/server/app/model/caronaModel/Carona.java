package model.caronaModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.Endereco;
import model.Horario;
import model.motoristaModel.Motorista;
import model.passageiroModel.Passageiro;
import play.libs.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samantha Monteiro, Gustavo Oliveira
 */
public class Carona {

	private String id;

	private List<Passageiro> passageiros;

	private Motorista motorista;

	private int qntVagasDisponiveis = 4;

	private Endereco pontoInicial;

	private Endereco destino;

	private Horario horario;

	private Carona() {}

	/**
	 * Construtor da entidade {@Carona}
	 * 
	 * @param {String} id id da carona sendo criada
	 * @param {String} idMotorista id do motorista responsavel pela carona
	 * @param {Object} pontoInicial ponto inicial da carona
	 * @param {Object} destino destino da carona
	 * @param {Object} horario horario da carona
	 */
	public Carona(String id, Motorista motorista, Endereco pontoInicial, Endereco destino, Horario horario) {
		this.passageiros = new ArrayList<Passageiro>();
		setId(id);
		setIdMotorista(motorista);
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

	public List<Passageiro> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(List<Passageiro> pssageiros) {
		this.passageiros = passageiros;
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

	public void setIdMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Motorista getMotorista() {
		return motorista;
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
