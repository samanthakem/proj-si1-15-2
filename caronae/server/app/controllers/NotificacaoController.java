package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import model.caronaModel.Carona;
import model.caronaModel.GerenciadorDeCaronas;
import model.notificacaoModel.GerenciadorDeNotificacoes;
import model.notificacaoModel.Notificacao;
import model.notificacaoModel.Notificacao.ParaTipo;
import model.notificacaoModel.NotificacaoPedidoCarona;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import model.sessaoModel.SessaoValidador;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.Utils;

import java.util.Date;
import java.util.List;

/**
 * Manipula os routes relacionados as notificacoes
 * @author Stenio Elson
 */
public class NotificacaoController extends Controller {
    private GerenciadorDeNotificacoes gerenciadorDeNotificacoes = GerenciadorDeNotificacoes.getGerenciador();
    private GerenciadorDePessoas gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();
    private GerenciadorDeCaronas gerenciadorDeCaronas = GerenciadorDeCaronas.getGerenciador();
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

    /**
     * Adiciona um passageiro a Carona
     * @param idCarona O id da carona que sera feito o pedido
     * @return Um JSON com as informações da carona
     */
    public Result fazerPedido(String idCarona) {
        JsonNode request = request().body().asJson();

        String idPassageiro  = Utils.getAtributo("passageiro", request);
        String idMotorista = Utils.getAtributo("motorista", request);

        System.out.println(idPassageiro + idMotorista);

        Pessoa de = gerenciadorDePessoas.getPessoa(idPassageiro);
        Pessoa para = gerenciadorDePessoas.getPessoa(idMotorista);
        Carona carona = gerenciadorDeCaronas.getCarona(idCarona);

        NotificacaoPedidoCarona notificacaoPedido = new NotificacaoPedidoCarona(de, para, new Date().getTime(), Notificacao.ParaTipo.MOTORISTA, carona);
        gerenciadorDeNotificacoes.addNotificacao(notificacaoPedido);

        return ok(Json.toJson(notificacaoPedido));
    }

    /**
     * Rejeita um Pedido de carona
     * @param idNotificacao a notificação do pedido de carona
     * @return a notificação atualizada
     */
    public Result rejectPedido(String idNotificacao) {
        NotificacaoPedidoCarona notificacaoPedido = (NotificacaoPedidoCarona) gerenciadorDeNotificacoes.getNotificacao(idNotificacao);
        notificacaoPedido.reject();

        Notificacao notificacao = new Notificacao(notificacaoPedido.getPara(),
                                                  notificacaoPedido.getDe(), "rejeitou o pedido",
                                                  new Date().getTime(), ParaTipo.PASSAGEIRO);
        gerenciadorDeNotificacoes.addNotificacao(notificacao);

        return ok(Json.toJson(notificacao));
    }
}
