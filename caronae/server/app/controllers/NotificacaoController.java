package controllers;

import model.notificacaoModel.GerenciadorDeNotificacoes;
import model.notificacaoModel.Notificacao;
import model.notificacaoModel.Notificacao.ParaTipo;
import model.sessaoModel.SessaoValidador;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Manipula os routes relacionados as notificacoes
 * @author Stenio Elson
 */
public class NotificacaoController extends Controller {
    private GerenciadorDeNotificacoes gerenciadorDeNotificacoes = GerenciadorDeNotificacoes.getGerenciador();
    private SessaoValidador sessaoValidador = new SessaoValidador(); //Vai ser usado pra verificar que o usuário logado pode recuperar Notificacoes

    /**
     * Recupera uma notificacao especifica
     * @param {String} matricula
     *                 A matricula da Pessoa relacionada aquela Notificacao
     * @param {String} idNotificacao
     *                 O id da Notificacao a ser recuperada
     * @return {Result}
     *                 Um JSON com as informações da Notificao se foi possível recuperar, caso contrário um erro em formato JSON.
     */
    public Result getNotificacao(String matricula, String idNotificacao) {
        Notificacao notificacao = gerenciadorDeNotificacoes.getNotificacao(idNotificacao);
        return ok(notificacao.toJson());
    }

    public Result getPassageiroNotificacoes(String matricula, Integer limite) {
        return getNotificacoes(matricula, limite, ParaTipo.PASSAGEIRO);
    }

    public Result getMotoristaNotificacoes(String matricula, Integer limite) {
        return getNotificacoes(matricula, limite, ParaTipo.MOTORISTA);
    }

    private Result getNotificacoes(String matricula, Integer limite, Notificacao.ParaTipo tipo) {
        List<Notificacao> notificacoes = gerenciadorDeNotificacoes.getNotificacoes(matricula, limite, tipo);

        return ok(Json.toJson(notificacoes));
    }
}
