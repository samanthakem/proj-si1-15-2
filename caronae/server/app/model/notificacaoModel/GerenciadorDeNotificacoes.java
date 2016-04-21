package model.notificacaoModel;

import model.notificacaoModel.Notificacao.ParaTipo;

import java.util.Date;
import java.util.List;

/**
 * Created by stenio on 4/18/2016.
 */
public class GerenciadorDeNotificacoes implements NotificacaoService {
    private static GerenciadorDeNotificacoes gerenciadorDeNotificacoes;

    private NotificacaoDao dao = new NotificacaoDao();

    /**
     * @return A instancia de GerenciadorDeNotificacoes
     */
    public static GerenciadorDeNotificacoes getGerenciador() {
        if (gerenciadorDeNotificacoes == null)
            gerenciadorDeNotificacoes = new GerenciadorDeNotificacoes();
        return gerenciadorDeNotificacoes;
    }

    /**
     * Retonra uma Notificacao com o id especificado
     * @param {String}
     *      idNotificacao O id da notificacao desejada
     * @return {Notificacao}
     *      A notificacao caso exista
     */
    public Notificacao getNotificacao(String idNotificacao) {
        Notificacao notificacao = dao.getNotificacao(idNotificacao);
        return notificacao;
    }

    /**
     * Recupera as <i>limite</i> últimas notificações.
     * @param {String} matricula
     *      A matricula da Pessoa
     * @param {Integer} limite
     *      A quantidade máxima de Notificações que serão retornadas
     * @param {ParaTipo} tipo
     *      Se a notificação esta ligada a Pessoa como MOTORISTA ou como PASSAGEIRO
     * @return {List<Notificacoao>}
     *      Uma lista com as notificações que satisfazem os parâmetros.
     */
    public List<Notificacao> getNotificacoes(String matricula, int limite, ParaTipo tipo) {
        return getNotificacoes(matricula, 0, new Date().getTime(), limite, true, tipo);
    }

    public List<Notificacao> getNotificacoes(String matricula, long inicio, long fim, int limite, boolean reverse, ParaTipo tipo) {
        return dao.getNotificacoes(matricula, inicio, fim, limite, reverse, tipo);
    }

    /**
     * Adiciona uma Notificação a coleção de Notificações
     * @param {Object} notificacao
     *          a notificacao a ser adicionado
     */
    public void addNotificacao(Notificacao notificacao) {
        //Precisa de validacao? Acho que nao
        dao.persistirNotificacao(notificacao);
    }
}
