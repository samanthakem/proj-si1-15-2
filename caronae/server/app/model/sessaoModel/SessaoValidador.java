package model.sessaoModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.HttpException;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;

import java.util.Map;

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
}
