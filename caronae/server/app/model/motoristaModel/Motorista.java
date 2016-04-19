package model.motoristaModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.caronaModel.Carona;
import model.pessoaModel.Pessoa;
import play.libs.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stenio, aline.
 */
public class Motorista {

    private Pessoa pessoa;

    private int quantidadeVagasCarro;

    private List<Carona> minhasCaronas;

    /**
     * Construtor padrão.
     */
    public Motorista() {}

    /**
     * Construtor que recebe todos os parametros.
     * @param pessoa a Pessoa que é o Motorista
     * @param quantidadeVagasCarro a quantidade de vagas no carro do Motorista
     */
    public Motorista(Pessoa pessoa, int quantidadeVagasCarro) {
        if (pessoa != null) {
            this.pessoa = pessoa;
        }
        setQuantidadeVagasCarro(quantidadeVagasCarro);
        this.minhasCaronas = new ArrayList<>();
    }

    public String getMatricula() {
        return pessoa.getMatricula();
    }

    /**
     * A informação do Motorista em formato JSON
     * @return A informação do Motorista
     */
    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.pessoa.getMatricula() + "\"}");
    }

    /**
     * Recupera a Pessoa que é o Motorista
     * @return a Pessoa que é o Motorista
     */
    public Pessoa getPessoa() {
        return pessoa;
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
        if(quantidadeVagasCarro < 1) {
            throw new IllegalArgumentException("Parâmetro 'quantidadeVagasCarro' deve ser valor positivo");
        }
        this.quantidadeVagasCarro = quantidadeVagasCarro;
    }

    /**
     * Adiciona uma carona na lista de caronas do Motorista, se esta ainda não existir
     * @param carona a carona a ser adicionada
     */
    public void addCarona(Carona carona) {
        if(minhasCaronas.contains(carona)) {
            throw new IllegalArgumentException("A carona já existe para esse motorista");
        }
        minhasCaronas.add(carona);
    }

    /**
     * Recupera todas as caronas relativas ao Motorista
     * @return as caronas do Motorista
     */
    public List<Carona> getCaronas() {
        return minhasCaronas;
    }

    //TODO implementar método getCarona
}