package model.motoristaModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.pessoaModel.Pessoa;
import play.libs.Json;

/**
 * Stenio, Samantha, Aline
 */
public class Motorista {

    private Pessoa pessoa;

    private int quantidadeVagasCarro;

    /**
     * Construtor padrão.
     */
    public Motorista() {
    	
    }

    /**
     * Construtor que recebe todos os parametros.
     * @param pessoa a Pessoa que é o Motorista
     * @param quantidadeVagasCarro a quantidade de vagas no carro do Motorista
     */
    public Motorista(Pessoa pessoa, int quantidadeVagasCarro) {
    	setPessoa(pessoa);
        setQuantidadeVagasCarro(quantidadeVagasCarro);
    }
    
    /**
     * Recupera a matrícula da pessoa que é motorista
     * @return matricula
     */
    public String getMatricula() {
        return pessoa.getMatricula();
    }

    /**
     * Recupera a Pessoa
     * @return a Pessoa 
     */
    public Pessoa getPessoa() {
        return pessoa;
    }
    
    /**
     * Modifica a pessoa
     * @param pessoa
     */
    public void setPessoa(Pessoa pessoa) {
    	this.pessoa = pessoa;
    }

    /**
     * Recupera a quantidade de vagas no carro do Motorista
     * @return quantidadeVagasCarro a quantidade de vagas no carro do Motorista
     */
    public int getQuantidadeVagasCarro() {
        return quantidadeVagasCarro;
    }

    /**
     * Modifica a quantidade de vagas no carro do Motorista, caso o parâmetro seja válido
     * @param quantidadeVagasCarro a nova quantidade de vagas no carro do Motorista
     */
    public void setQuantidadeVagasCarro(int quantidadeVagasCarro) {
    	if (quantidadeVagasCarro < 0) {
    		this.quantidadeVagasCarro = 0;
    	}
        this.quantidadeVagasCarro = quantidadeVagasCarro;
    }
    
    /**
     * A informação do Motorista em formato JSON
     * @return Json.parse() A informação do Motorista
     */
    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.pessoa.getMatricula() + "\"}");
    }
    
    /**
     * Sobrescreve a comparação entre motoristas
     * @param objeto
     * @return true se o objeto for motorista e tiver mesma pessoa do objeto, caso contrário false
     */
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
