package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.Horario;
import model.HorarioValidador;
import model.passageiroModel.GerenciadorDePassageiros;
import model.passageiroModel.Passageiro;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.Utils;

import java.util.List;

/**
 * Created by stenio on 4/3/2016.
 */
public class PassageiroController extends Controller {
    private GerenciadorDePassageiros gerenciadorDePassageiros = GerenciadorDePassageiros.getGerenciador();
    private HorarioValidador horarioValidador = new HorarioValidador();

    /**
     * Recupera uma pessoa da coleção de passageiros
     * @param id O id do passageiro
     * @return Um JSON com as informações do passageiro se foi possível recuperar, caso contrário a explicação em formato JSON.
     */
    public Result getPassageiro(String id) {
        Passageiro passageiro = gerenciadorDePassageiros.getPassageiro(id);

        return ok(Json.toJson(passageiro));
    }

    public Result addHorario(String idPassageiro) {
        JsonNode request = request().body().asJson();

        String dia = Utils.getAtributo("dia", request);
        String hora = Utils.getAtributo("hora", request);

        horarioValidador.validarDia(dia);
        horarioValidador.validarHora(hora);

        Horario horario = new Horario(Horario.Dia.valueOf(dia), hora);

        Passageiro passageiro = gerenciadorDePassageiros.getPassageiro(idPassageiro);

        passageiro.addHorario(horario);

        return ok(Json.toJson(horario));
    }

    public Result removeHorario(String idPassageiro, String idHorario) {
        Passageiro passageiro = gerenciadorDePassageiros.getPassageiro(idPassageiro);

        Horario horario = passageiro.getHorario(idHorario);

        passageiro.removeHorario(horario);

        return ok(Json.toJson(horario));
    }

    public Result getHorarios(String idPassageiro) {
        Passageiro passageiro = gerenciadorDePassageiros.getPassageiro(idPassageiro);

        List<Horario> horarios = passageiro.getHorarios();

        return ok(Json.toJson(horarios));
    }

    /**
     * Adiciona um passageiro a coleção de passageiros
     * @return Um JSON com as informações do passageiro se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    public Result addPassageiro() {
        JsonNode request = request().body().asJson();

        String idPessoa = Utils.getAtributo("studentId", request);

        Pessoa pessoa = GerenciadorDePessoas.getGerenciador().getPessoa(idPessoa);

        Passageiro passageiro = new Passageiro(pessoa);

        gerenciadorDePassageiros.addPassageiro(passageiro);

        return ok(Json.toJson(passageiro));
    }

}
