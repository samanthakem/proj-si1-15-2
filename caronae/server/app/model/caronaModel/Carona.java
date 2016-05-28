package model.caronaModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.Endereco;
import model.Horario;
import model.motoristaModel.Motorista;
import model.passageiroModel.Passageiro;
import play.data.validation.Constraints;
import play.libs.Json;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Samantha Monteiro, Gustavo Oliveira
 */
public class Carona {

	private String idCarona;

	private Set<Passageiro> passageiros;

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
	public Carona(Motorista motorista, Endereco pontoInicial, Endereco destino, Horario horario,int vagas) {
		this.passageiros = new HashSet<Passageiro>();
		setIdMotorista(motorista);
		setPontoInicial(pontoInicial);
		setDestino(destino);
		setHorario(horario);
		setQntVagasDisponiveis(vagas);
		setIdCarona(motorista.getMatricula() + horario.toString());
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Horario getHorario() {
		return horario;
	}

	public Set<Passageiro> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(Set<Passageiro> pssageiros) {
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

	public void setQntVagasDisponiveis(int qntVagasDisponiveis) {
		if (qntVagasDisponiveis < 0) {
			this.qntVagasDisponiveis = 0;
		}
		this.qntVagasDisponiveis = qntVagasDisponiveis;
	}

	public void setIdMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Motorista getMotorista() {
		return motorista;
	}


	public String getIdCarona() {
		return idCarona;
	}

	public void setIdCarona(String idCarona) {
		this.idCarona = idCarona;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Carona carona = (Carona) o;

		return idCarona.equals(carona.idCarona);

	}

	@Override
	public int hashCode() {
		return idCarona.hashCode();
	}
}
