package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.GerenciadorDePessoas;
import model.HttpException;
import model.Pessoa;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Created by stenio on 4/3/2016.
 */
public class PessoaController extends Controller {

    public Result getPessoa(Integer id) {
        Result result;

        try {
            Pessoa pessoa = GerenciadorDePessoas.getPessoa(id);
            result = ok(pessoa.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }

    public Result addPessoa(Integer id) {
        Result result = ok();
        JsonNode resultJson;

        try {
            GerenciadorDePessoas.addPessoa(id);

            Pessoa pessoa = GerenciadorDePessoas.getPessoa(id);

            result = ok(pessoa.toJson());
        } catch(HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }
}
