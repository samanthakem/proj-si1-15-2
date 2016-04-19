package model.sessaoModel;

import com.fasterxml.jackson.databind.JsonNode;

import exceptions.HttpException;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import play.libs.Json;

import java.util.Map;

import static play.mvc.Controller.session;

/**
 * Created by gustavooliveira on 4/10/16.
 */
public class SessaoValidador {
    GerenciadorDePessoas gerenciadorDePessoas;



    public SessaoValidador() {
        gerenciadorDePessoas =  GerenciadorDePessoas.getGerenciador();
    }

    public Pessoa validaUsuario(JsonNode request) throws HttpException{
        String matricula = request.findPath("studentId").asText();
        String password = request.findPath("password").asText();
        if(matricula.isEmpty() && !(matricula.toCharArray().length == 11)) {
            throw new HttpException(400, "This Matricula does not exist");
        }else if(password.toCharArray().length < 6) {
            throw new HttpException(400, "This password has the wrong length");
        }

        Pessoa pessoa = gerenciadorDePessoas.getPessoa(matricula);

        if( pessoa.getSenha().compareTo(password) != 0 ) {
            throw new HttpException(400, "The password is wrong");
        }

        return pessoa;
    }

    public void registraPessoaLogada(Pessoa pessoa) {
        long timeNow = System.currentTimeMillis()/1000L;
        session("connected", pessoa.toJson().toString());
        session().put("lastRequest", String.valueOf(timeNow));
    }

    public JsonNode getPessoaLogada() throws HttpException{
        JsonNode json;

        if(session().containsKey("connected")) {
            json = Json.parse(session("connected"));
        }
        else {
            throw new HttpException(400, "There is no user connected");
        }

        return json;
    }
}
