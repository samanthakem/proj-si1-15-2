package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import exceptions.HttpException;
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
        Result result;
        JsonNode resultJson;

        try {
            Passageiro passageiro = gerenciadorDePassageiros.getPassageiro(id);
            result = ok(passageiro.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }

    public Result addHorario(String idPassageiro) {
        JsonNode request = request().body().asJson();

        String dia = Utils.getAtributo("dia", request);
        String hora = Utils.getAtributo("hora", request);
        String tipo = Utils.getAtributo("tipo", request);

        horarioValidador.validarDia(dia);
        horarioValidador.validarHora(hora);
        horarioValidador.validarTipo(tipo);

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

    public Result getHorarios(String idPassageiro, String tipo) {
        Passageiro passageiro = gerenciadorDePassageiros.getPassageiro(idPassageiro);

        horarioValidador.validarTipo(tipo);

        List<Horario> horarios = passageiro.getHorarios(Horario.Tipo.valueOf(tipo));

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
