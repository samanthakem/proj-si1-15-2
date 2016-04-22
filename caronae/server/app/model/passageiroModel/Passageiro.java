package model.passageiroModel;

import com.fasterxml.jackson.databind.JsonNode;
import exceptions.HttpException;
import model.Horario;
import model.pessoaModel.Pessoa;
import play.libs.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stenio Araujo, Samantha Monteiro
 */
public class Passageiro {
	
    private Pessoa pessoa;
    
	private String idCarona;

    private List<Horario> horarios;

    /**
     * Construtor padrão
     */
    public Passageiro() {}

    /**
     * Construtor da entidade {@Passageiro}
     * @param pessoa a pessoa que é o Passageiro
     */
    public Passageiro(Pessoa pessoa) {
        this.pessoa = pessoa ;
        this.horarios = new ArrayList<>();
    }

    public String getMatricula() {
        return pessoa.getMatricula();
    }
    
    public void setMatricula(String matricula) {
    	pessoa.setMatricula(matricula);
    }
    
    public void setIdCarona(String idCarona) {
		this.idCarona = idCarona;
	}
    
    public String getIdCarona() {
    	return idCarona;
    }
    
    @Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}
		
		if (!(objeto instanceof Passageiro)) {
			return false;
		}
		
		Passageiro outroPassageiro = (Passageiro) objeto;
		return this.getPessoa().equals(outroPassageiro.getPessoa());
	}

	/**
     * A informação do passageiro em formato JSON
     * @return A informação do Passageiro
     */
    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.pessoa.getMatricula() + "\"}");
    }

    /**
     * Recupera a pessoa que é o Passageiro
     * @return a pessoa que é o Passageiro
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * Adiciona um Horario na lista de horarios do Passageiro
     * @param horario Horario
     */
    public void addHorario(Horario horario) {
        if (!existeHorario(horario))
            horarios.add(horario);
        else
            throw new HttpException(409, "Horario ja existe");
    }

    /**
     * Remove um Horario na lista de horarios do Passageiro
     * @param horario Horario
     */
    public void removeHorario(Horario horario) {
        horarios.remove(horario);
    }

    /**
     * Recupera os horários de ida do Passageiro
     * @return os horários do Passageiro
     */
    public List<Horario> getHorariosIda() { return getHorarios(Horario.Tipo.IDA); }

    /**
     * Recupera os horários de volta do Passageiro
     * @return os horários do Passageiro
     */
    public List<Horario> getHorariosVolta() { return getHorarios(Horario.Tipo.VOLTA); }

    public List<Horario> getHorarios(Horario.Tipo tipo) {
        List<Horario> horariosIda = new ArrayList<>();

        for (Horario horario : horarios)
            if (horario.getTipo().equals(tipo))
                horariosIda.add(horario);

        return horariosIda;
    }

    /**
     * Recupera os horários do Passageiro
     * @return os horários do Passageiro
     */
    public List<Horario> getHorarios() { return horarios; }

    public Horario getHorario(String idHorario) {
        Horario horario = null;

        for (Horario h: horarios) {
            if (h.getIdHorario().equals(idHorario)) {
                horario = h;
                break;
            }
        }

        if (horario == null) throw new HttpException(404, "Nao existe horario com esta ID");

        return horario;
    }

    /**
     * Verifica se um horário está presente na lista de horarios do Passageiro
     * @param horario id do Horario
     * @return true, se o horarios está na lista, false, caso contrário
     */
    public boolean existeHorario(Horario horario) {
        return horarios.contains(horario);
    }
}
