package model.passageiroModel;

import com.fasterxml.jackson.databind.JsonNode;
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

    private List<Horario> horariosIda;

    private List<Horario> horariosVolta;

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
        this.horariosIda = new ArrayList<>();
        this.horariosVolta = new ArrayList<>();
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
     * Adiciona um Horario de ida na lista de horarios do Passageiro
     * @param horario Horario
     */
    public void addHorarioIda(Horario horario) {
        if (!existeHorarioIda(horario))
            horariosIda.add(horario);
    }

    /**
     * Reomve um Horario de volta na lista de horarios do Passageiro
     * @param horario Horario
     */
    public void removeHorarioVolta(Horario horario) {
        horariosVolta.remove(horario);
    }

    /**
     * Remove um Horario de ida na lista de horarios do Passageiro
     * @param horario Horario
     */
    public void removeHorarioIda(Horario horario) {
        horariosIda.remove(horario);
    }

    /**
     * Adiciona um Horario de volta na lista de horarios do Passageiro
     * @param horario Horario
     */
    public void addHorarioVolta(Horario horario) {
        if (!existeHorarioVolta(horario))
            horariosVolta.add(horario);
    }

    /**
     * Recupera os horários de ida do Passageiro
     * @return os horários do Passageiro
     */
    public List<Horario> getHorariosIda() {
        return horariosIda;
    }

    /**
     * Recupera os horários de volta do Passageiro
     * @return os horários do Passageiro
     */
    public List<Horario> getHorariosVolta() {
        return horariosVolta;
    }

    /**
     * Verifica se um horário está presente na lista de horarios de ida do Passageiro
     * @param horario id do Horario
     * @return true, se o horarios está na lista, false, caso contrário
     */
    public boolean existeHorarioIda(Horario horario) {
        return horariosIda.contains(horario);
    }

    /**
     * Verifica se um horário está presente na lista de horarios de volta do Passageiro
     * @param horario id do Horario
     * @return true, se o horarios está na lista, false, caso contrário
     */
    public boolean existeHorarioVolta(Horario horario) {
        return horariosVolta.contains(horario);
    }
}
