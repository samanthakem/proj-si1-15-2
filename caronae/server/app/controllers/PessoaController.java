package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import exceptions.HttpException;
import model.Endereco;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import model.sessaoModel.SessaoValidador;
import play.mvc.Controller;
import play.mvc.Result;
import util.Utils;

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
            sessaoValidador.registraPessoaLogada(pessoa);
            //System.out.print(session("connected"));
            //System.out.print(session("lastRequest"));
            result = ok(pessoa.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }
        return result;
    }

    public Result logout(){
//        System.out.print(session("connected"));
        session().clear();
//        System.out.print(session("connected"));
        return status(200, "Logged out successfully");
    }

    /**
     * Recupera da sessao o usuario que está logado no momento
     * @return Um JSON com as informações da pessoa se foi possível recuperar, caso contrário a explicação em formato JSON.
     */
    public Result getUsuarioLogado() {
        try {
            return ok(sessaoValidador.getPessoaLogada());
        } catch (HttpException e) {
            return badRequest(e.getJSONMessage());
        }
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
