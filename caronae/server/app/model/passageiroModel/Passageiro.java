package model.passageiroModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.pessoaModel.Pessoa;
import play.libs.Json;

/**
 * Created by stenio on 4/3/2016.
 */
public class Passageiro {
    private Pessoa pessoa;

    public Passageiro(Pessoa pessoa) {
        this.pessoa = pessoa ;
    }

    public Integer getMatricula() {
        return pessoa.getMatricula();
    }

    /**
     * A informação do passageiro em formato JSON
     * @return A informação do Passageiro
     */
    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.pessoa.getMatricula() + "\"}");
    }
}
