package model.passageiroModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.pessoaModel.Pessoa;
import play.libs.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stenio on 4/3/2016.
 */
public class Passageiro {
    private Pessoa pessoa;

    private List<String> idsMeusHorarios;

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
        this.idsMeusHorarios = new ArrayList<>();
    }

    public String getMatricula() {
        return pessoa.getMatricula();
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
     * Adiciona um id de Horario na lista de horarios do Passageiro
     * @param id id de Horario
     */
    public void addHorario(String id) {
        idsMeusHorarios.add(id);
    }

    /**
     * Recupera os horários do Passageiro
     * @return os horários do Passageiro
     */
    public List<String> getIdsHorarios() {
        return idsMeusHorarios;
    }

    /**
     * Verifica se um horário está presente na lista de horarios do Passageiro
     * @param id id do Horario
     * @return true, se o horarios está na lista, false, caso contrário
     */
    public boolean contemHorario(String id) {
        return idsMeusHorarios.contains(id);
    }
}
