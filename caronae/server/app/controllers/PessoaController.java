package controllers;

import model.GerenciadorDePessoas;
import model.HttpException;
import model.Pessoa;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by stenio on 4/3/2016.
 */
public class PessoaController extends Controller {
    private GerenciadorDePessoas gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();

    /**
     * Recupera uma pessoa da coleção de pessoas
     * @param id O id da Pessoa
     * @return Um JSON com as informações da pessoa se foi possível recuperar, caso contrário a explicação em formato JSON.
     */
    public Result getPessoa(Integer id) {
        Result result;

        try {
            Pessoa pessoa = gerenciadorDePessoas.getPessoa(id);
            result = ok(pessoa.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }

    /**
     * Adiciona uma pessoa a coleção de pessoas
     * @param id O id da nova Pessoa
     * @return Um JSON com as informações da pessoa se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    public Result addPessoa(Integer id) {
        Result result;

        try {
            gerenciadorDePessoas.addPessoa(id);

            Pessoa pessoa = gerenciadorDePessoas.getPessoa(id);

            result = ok(pessoa.toJson());
        } catch(HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }
}
