package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.HttpException;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import model.sessaoModel.SessaoValidador;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;

import java.util.Map;

/**
 * Created by stenio on 4/3/2016.
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
        Result result;

        try {
            Pessoa pessoa = gerenciadorDePessoas.getPessoa(matricula);
            result = ok(pessoa.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }

    /**
     * Adiciona uma pessoa a coleção de pessoas
     * @return Um JSON com as informações da pessoa se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    public Result addPessoa() {
        Http.Request request = request();
        Http.RequestBody body = request.body();
        Map<String, String[]> valores = request.body().asFormUrlEncoded();

//        Pessoa r = form(Pessoa.class).bindFromRequest().get();

        String nome = valores.get("name")[0];
        String bairro = valores.get("address2")[0];
        String rua = valores.get("address1")[0];
        String email = valores.get("email")[0];
        String telefone = valores.get("phone")[0];
        String senha = valores.get("password")[0];
        String matricula = valores.get("studentId")[0];
//
        return addPessoa(nome, bairro, rua, email, telefone, senha, matricula);
    }

    /**
     * Adiciona uma pessoa a coleção de pessoas
     * @param nome o nome da nova pessoa
     * @param bairro o bairro da nova pessoa
     * @param rua a rua da nova pessoa
     * @param email o email da nova pessoa
     * @param telefone o telefone da nova pessoa
     * @param senha a senha da nova pessoa
     * @param matricula a matricula da nova pessoa
     * @return Um JSON com as informações da pessoa se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    private Result addPessoa(String nome, String bairro, String rua, String email, String telefone, String senha, String matricula) {
        Result result;

        try {
            Pessoa pessoa = gerenciadorDePessoas.addPessoa(nome, bairro, rua, email, telefone, senha, matricula);

            result = ok(pessoa.toJson());
        } catch(HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }
}
