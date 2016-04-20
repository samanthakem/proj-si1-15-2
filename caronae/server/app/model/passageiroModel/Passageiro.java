package model.passageiroModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.pessoaModel.Pessoa;
import play.libs.Json;

/**
 * @author Stenio Araujo, Samantha Monteiro
 */
public class Passageiro {
	
    private Pessoa pessoa;
    
	private Long idCarona;

    public Passageiro(Pessoa pessoa) {
        this.pessoa = pessoa ;
    }

    public String getMatricula() {
        return pessoa.getMatricula();
    }
    
    public void setMatricula(String matricula) {
    	pessoa.setMatricula(matricula);
    }
    
    private Pessoa getPessoa() {
		return this.pessoa;
	}
    
    public void setIdCarona(Long idCarona) {
		this.idCarona = idCarona;
	}
    
    public Long getIdCarona() {
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
}
