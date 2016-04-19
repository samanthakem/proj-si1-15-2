package model.passageiroModel;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Objects;

import model.motoristaModel.Motorista;
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

    public String getMatricula() {
        return pessoa.getMatricula();
    }
    
    private Pessoa getPessoa() {
		return this.pessoa;
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
}
