package model.passageiroModel;

import com.avaje.ebean.Model;
import com.fasterxml.jackson.databind.JsonNode;
import exceptions.HttpException;
import model.Horario;
import model.pessoaModel.Pessoa;
import play.libs.Json;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stenio Araujo, Samantha Monteiro
 */
@Entity
public class Passageiro extends Model {
	
    private Pessoa pessoa;
    
	private String idCarona;

    private List<Horario> horarios;

    private int id;

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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
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
