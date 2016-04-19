package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import exceptions.HttpException;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import model.Endereco;
import model.sessaoModel.SessaoValidador;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import util.Utils;
import play.mvc.Http.Request;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;

/**
 * @author Stenio Elson, Samantha Monteiro
 */
public class PessoaController extends Controller {
    private GerenciadorDePessoas gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();
    private SessaoValidador sessaoValidador = new SessaoValidador();

    /**
     * Realiza login de um usuario no sistema
     * @return Um JSON com as informações da pessoa se foi possível recuperar, caso contrário a explicação em formato JSON.
     */
    public Result login(){
        Result result;
        JsonNode request = request().body().asJson();

        try {
            Pessoa pessoa = sessaoValidador.validaUsuario(request);
            //session("connected", pessoa.toJson().toString());
            long timeNow = System.currentTimeMillis()/1000L;
            session().put("lastRequest", String.valueOf(timeNow));
            //System.out.print(session("connected"));
            //System.out.print(session("lastRequest"));
            result = ok(pessoa.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }
        return result;
    }

    /**
     * Recupera uma pessoa da coleção de pessoas
     * @param matricula A matricula da Pessoa
     * @return Um JSON com as informações da pessoa se foi possível recuperar, caso contrário a explicação em formato JSON.
     */
    public Result getPessoa(String matricula) {
        Pessoa pessoa = gerenciadorDePessoas.getPessoa(matricula);
        return ok(pessoa.toJson());
    }

    /**
     * Adiciona uma pessoa a coleção de pessoas
     * @return Um JSON com as informações da pessoa se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    public Result addPessoa() {
    	JsonNode request = request().body().asJson();
    	
        String matricula = Utils.getAtributo("studentId", request);
        String senha = Utils.getAtributo("password", request);
        String nome = Utils.getAtributo("name", request);
	    String email = Utils.getAtributo("email", request);
	    String telefone = Utils.getAtributo("phone", request);
	    String bairro = Utils.getAtributo("bairro", request);
	    String rua = Utils.getAtributo("rua", request);
	    String num = Utils.getAtributo("num", request);
	    
	    Endereco endereco = new Endereco(num, rua, bairro);
	    
	    Pessoa pessoa = new Pessoa(
	    		nome,
	    		endereco,
	    		email,
	    		telefone,
	    		senha,
	    		matricula);

        gerenciadorDePessoas.addPessoa(pessoa);
        return ok(pessoa.toJson());
    }
}
