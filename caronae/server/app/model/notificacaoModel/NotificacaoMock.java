package model.notificacaoModel;

import exceptions.HttpException;
import model.notificacaoModel.Notificacao.ParaTipo;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;

import java.util.*;

/**
 * Created by stenio on 4/18/2016.
 */
public class NotificacaoMock {

    public HashMap<String, Notificacao> notificacoes = new HashMap<>();

    public NotificacaoMock() { fillin(); }

    public Notificacao get(String idNotificacao) {
        if (!contemNotificacao(idNotificacao)) {
            throw new HttpException(404, "Notificacao does not exist");
        }
        return notificacoes.get(idNotificacao);
    }

    public void add(Notificacao notificacao) throws HttpException {
        if (this.contemNotificacao(notificacao.getIdNotificacao())) {
            throw new HttpException(409, "Notificacao already exists");
        }
        notificacoes.put(notificacao.getIdNotificacao(), notificacao);
    }

    public boolean contemNotificacao(String idNotificacao) {
        return this.notificacoes.containsKey(idNotificacao);
    }

    /**
     * Retorna uma lista de <b>limite</b> notificacoes do timestamp inicio, ate o timestamp fim para uma Pessoa
     * @param {String}
     *      matricula A matricula da pessoa para a qual a notificacao eh destinada
     * @param {Long}
     *      inicio O timestamp inicial, este valor deve ser menor ou igual ao final para que possa haver algum item na lista
     * @param {Long}
     *      fim O timestamp final , este valor deve ser maior ou igual ao inicial
     * @param {Long}
     *      limite quantidade maxima de Notificacoes que podem ter na lista
     * @param {Boolean}
     *      reverse A ordem que a Lista tera seus elementos
     * @return {List}
     *      A lista com Notificacoes ordenadas
     */
    public List<Notificacao> getNotificacoes(String matricula, long inicio, long fim, int limite, boolean reverse, ParaTipo tipo) {
        List<Notificacao> notificacoes = new ArrayList<>();

        Notificacao notifTemp;
        for (String id : this.notificacoes.keySet()) {
            notifTemp = this.notificacoes.get(id);

            if (inicio <= notifTemp.getTimestamp() && notifTemp.getTimestamp() <= fim
                    && notifTemp.getPara().getMatricula().equals(matricula)
                    && notifTemp.getParaTipo().equals(tipo)) {
                notificacoes.add(notifTemp);
            }
        }
        Collections.sort(notificacoes, compareByTimestamp(reverse));

        if (limite > notificacoes.size())
            limite = notificacoes.size();

        return notificacoes.subList(0, limite);
    }

    /**
     * Implementa um Comparator de Notificacao
     * @param {Boolean}
     *      reverse True se o comparator for usado para gerar uma lista reversa, falso caso contrario
     * @return {Comparator}
     *      Um comparator para Notificacao que compara pelo timestamp
     */
    private Comparator<Notificacao> compareByTimestamp(boolean reverse) {
        Comparator<Notificacao> comparator = new Comparator<Notificacao>() {
            @Override
            public int compare(Notificacao o1, Notificacao o2) {
                long result = o1.getTimestamp() - o2.getTimestamp();

                if (result > 0)
                    result = 1;
                else if (result < 0)
                    result = -1;
                else
                    result = 0;

                if (reverse)
                    result = -1 * result;

                return (int)result;
            }
        };

        return comparator;
    }

    public void fillin() {
        Pessoa pessoa = GerenciadorDePessoas.getGerenciador().getPessoa("111111111");

        Notificacao notificacao = new Notificacao(Integer.toString(notificacoes.size()), pessoa, pessoa, "Mandou avisar que funcionou",
                new Date().getTime(), ParaTipo.MOTORISTA);
        notificacoes.put(notificacao.getIdNotificacao(), notificacao);

        notificacao = new Notificacao(Integer.toString(notificacoes.size()), pessoa, pessoa, "Mandou avisar que funcionou",
                new Date().getTime()+1, ParaTipo.MOTORISTA);
        notificacoes.put(notificacao.getIdNotificacao(), notificacao);

        NotificacaoPedidoCarona pedidoCarona = new NotificacaoPedidoCarona(Integer.toString(notificacoes.size()), pessoa, pessoa, "Pediu caroninha!",
                new Date().getTime()+2, ParaTipo.MOTORISTA);
        notificacoes.put(pedidoCarona.getIdNotificacao(), pedidoCarona);
    }
}
