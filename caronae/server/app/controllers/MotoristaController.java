package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.motoristaModel.GerenciadorDeMotoristas;
import model.motoristaModel.Motorista;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.Utils;

/**
 * Created by gustavooliveira on 4/28/16.
 */
public class MotoristaController extends Controller {

    private GerenciadorDeMotoristas gerenciadorDeMotoristas;
    private GerenciadorDePessoas gerenciadorDePessoas;

    public MotoristaController() {
        gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();
        gerenciadorDeMotoristas = GerenciadorDeMotoristas.getGerenciador();
    }

    public Result getMotorista(String matricula){
        Motorista motorista = gerenciadorDeMotoristas.getMotorista(matricula);

        return ok(Json.toJson(motorista));
    }

    public Result addMotorista(){
        JsonNode request = request().body().asJson();

        String matricula = Utils.getAtributo("matricula", request);
        String vagas = Utils.getAtributo("vagas", request);

        Pessoa pessoa = gerenciadorDePessoas.getPessoa(matricula);

        Motorista motorista = new Motorista(pessoa, Integer.valueOf(vagas));

        gerenciadorDeMotoristas.addMotorista(motorista);

        return ok(Json.toJson(motorista));
    }

}
