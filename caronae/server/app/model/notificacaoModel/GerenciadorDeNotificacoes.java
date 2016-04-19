package model.notificacaoModel;

import model.notificacaoModel.Notificacao.ParaTipo;

import java.util.List;

/**
 * Created by stenio on 4/18/2016.
 */
public class GerenciadorDeNotificacoes {
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

    public List<Notificacao> getNotificacoes(String matricula, int limite, ParaTipo tipo) {
        return dao.getNotificacoes(matricula, limite, tipo);
    }

    public List<Notificacao> getNotificacoes(String matricula, long inicio, long fim, int limite, boolean reverse, ParaTipo tipo) {
        return dao.getNotificacoes(matricula, inicio, fim, limite, reverse, tipo);
    }

    public void addNotificacao(Notificacao notificacao) {
        //Precisa de validacao? Acho que nao
        dao.persistirNotificacao(notificacao);
    }
}
