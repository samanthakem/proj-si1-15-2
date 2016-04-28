package controllers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.HttpException;
import model.Endereco;
import model.caronaModel.Carona;
import model.caronaModel.GerenciadorDeCaronas;
import model.motoristaModel.GerenciadorDeMotoristas;
import model.motoristaModel.Motorista;
import model.passageiroModel.GerenciadorDePassageiros;
import model.passageiroModel.Passageiro;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import model.sessaoModel.SessaoValidador;
import play.mvc.Controller;
import play.mvc.Result;
import util.Utils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Stenio Elson, Samantha Monteiro
 */
public class PessoaController extends Controller {
    private GerenciadorDePessoas gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();
    private GerenciadorDeCaronas gerenciadorDeCaronas = GerenciadorDeCaronas.getGerenciador();
    private GerenciadorDeMotoristas gerenciadorDeMotoristas = GerenciadorDeMotoristas.getGerenciador();
    private GerenciadorDePassageiros gerenciadorDePassageiros = GerenciadorDePassageiros.getGerenciador();

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
        sessaoValidador.registraPessoaLogada(pessoa);
        return ok(pessoa.toJson());
    }

    public Result getCaronas() {
        JsonNode pessoa = sessaoValidador.getPessoaLogada();
        String matricula = pessoa.get("matricula").asText();

        Motorista motorista = gerenciadorDeMotoristas.getMotorista(matricula);
        Passageiro passageiro = gerenciadorDePassageiros.getPassageiro(matricula);

        Set<Carona> caronas = new HashSet<Carona>();

        caronas.addAll(gerenciadorDeCaronas.getCaronasDeMotorista(motorista));
        System.out.print(caronas.size());
        caronas.addAll(gerenciadorDeCaronas.getCaronasDePassageiro(passageiro));
        System.out.print(caronas.size());

        ObjectMapper mapper = new ObjectMapper(new JsonFactory());

        String jsonString;

        try {
            jsonString = mapper.writeValueAsString(caronas);
        } catch (JsonProcessingException e) {
            return badRequest(e.getMessage());
        }
        return ok(jsonString);
    }
}
