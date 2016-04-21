package model.notificacaoModel;

import java.util.List;

/**
 * Created by stenio on 4/21/2016.
 */
public interface NotificacaoService {

    /**
     * Recupera uma lista de notificações para um Passageiro/Motorista
     * @param {String} matricula
     *      A matricula da Pessoa
     * @param {Long} inicio
     *      Um timestamp represetando o limite inical de pesquisa das Notificações
     * @param {Long} fim
     *      Um timestamp represetando o limite final de pesquisa das Notificações
     * @param {Integer} limite
     *      A quantidade máxima de Notificações que serão retornadas
     * @param {Boolean} reverse
     *      True se você deseja pegar do mais recente pro mais antigo, False caso contrário.
     * @param {ParaTipo} tipo
     *      Se a notificação esta ligada a Pessoa como MOTORISTA ou como PASSAGEIRO
     * @return {List<Notificacoao>}
     *      Uma lista com as notificações que satisfazem os parâmetros.
     */
    List<Notificacao> getNotificacoes(String matricula, long inicio, long fim, int limite, boolean reverse, Notificacao.ParaTipo tipo);

    /**
     * Retonra uma Notificacao com o id especificado
     * @param {String}
     *      idNotificacao O id da notificacao desejada
     * @return {Notificacao}
     *      A notificacao caso exista
     */
    Notificacao getNotificacao(String idNotificacao);
}
