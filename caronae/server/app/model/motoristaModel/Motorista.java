package model.motoristaModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.pessoaModel.Pessoa;
import play.libs.Json;

/**
 * Created by stenio, aline.
 */
public class Motorista {

    private Pessoa pessoa;

    private int quantidadeVagasCarro;

	private String idCarona;

    /**
     * Construtor padrão.
     */
    public Motorista() {}

    /**
     * Construtor que recebe todos os parametros.
     * @param pessoa a Pessoa que é o Motorista
     * @param quantidadeVagasCarro a quantidade de vagas no carro do Motorista
     */
    public Motorista(Pessoa pessoa, String idCarona, int quantidadeVagasCarro) {
    	setPessoa(pessoa);
    	setIdCarona(idCarona);
        setQuantidadeVagasCarro(quantidadeVagasCarro);
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

    /**
     * Recupera a Pessoa que é o Motorista
     * @return a Pessoa que é o Motorista
     */
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    public void setPessoa(Pessoa pessoa) {
    	this.pessoa = pessoa;
    }

    /**
     * Recupera a quantidade de vagas no carro do Motorista
     * @return a quantidade de vagas no carro do Motorista
     */
    public int getQuantidadeVagasCarro() {
        return quantidadeVagasCarro;
    }

    /**
     * Modifica a quantidade de vagas no carro do Motorista, caso o parâmetro seja válido
     * @param quantidadeVagasCarro a nova quantidade de vagas no carro do Motorista
     */
    public void setQuantidadeVagasCarro(int quantidadeVagasCarro) {
        this.quantidadeVagasCarro = quantidadeVagasCarro;
    }
    
    /**
     * A informação do Motorista em formato JSON
     * @return A informação do Motorista
     */
    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.pessoa.getMatricula() + "\"}");
    }
    
    @Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}
		
		if (!(objeto instanceof Motorista)) {
			return false;
		}
		
		Motorista outroMotorista = (Motorista) objeto;
		return this.getPessoa().equals(outroMotorista.getPessoa());
	}
}