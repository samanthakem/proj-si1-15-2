package controllers;

import model.notificacaoModel.GerenciadorDeNotificacoes;
import model.notificacaoModel.Notificacao;
import model.notificacaoModel.Notificacao.ParaTipo;
import model.sessaoModel.SessaoValidador;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Date;
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

    public Result getPassageiroNotificacoes(String matricula, long start, long end, boolean reverse, Integer limite) {
        if (end == -1) end = new Date().getTime();

        return getNotificacoes(matricula, start, end, reverse, limite, ParaTipo.PASSAGEIRO);
    }

    public Result getMotoristaNotificacoes(String matricula, long start, long end, boolean reverse, Integer limite) {
        if (end == -1) end = new Date().getTime();

        return getNotificacoes(matricula, start, end, reverse, limite, ParaTipo.MOTORISTA);
    }

    private Result getNotificacoes(String matricula, long start, long end, boolean reverse, Integer limite, Notificacao.ParaTipo tipo) {
        List<Notificacao> notificacoes = gerenciadorDeNotificacoes.getNotificacoes(matricula, start, end, limite, reverse, tipo);
//q
        return ok(Json.toJson(notificacoes));
    }
}
