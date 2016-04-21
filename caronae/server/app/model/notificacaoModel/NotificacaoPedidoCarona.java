package model.notificacaoModel;

import model.caronaModel.Carona;
import model.pessoaModel.Pessoa;

/**
 * Created by stenio on 4/19/2016.
 */
public class NotificacaoPedidoCarona extends Notificacao {
    private enum StatusPedido {
        WAITING, ACCEPTED, REJECTED
    }

    private StatusPedido accepted = StatusPedido.WAITING;

    private Carona carona;

    public NotificacaoPedidoCarona(String idNotificacao, Pessoa de, Pessoa para, String razao, long timestamp, ParaTipo paraTipo) {
        super(idNotificacao, de, para, razao, timestamp, paraTipo);
    }

    public void accept() {
        accepted = StatusPedido.ACCEPTED;
    }

    public void reject() {
        accepted = StatusPedido.REJECTED;
    }

    public NotificacaoPedidoCarona setCarona(Carona carona) {
        this.carona = carona;

        return this;
    }

    public Carona getCarona() {
        return this.carona;
    }

    public boolean isAccepted() {
        return accepted == StatusPedido.ACCEPTED;
    }

    public boolean isRejected() {
        return accepted == StatusPedido.REJECTED;
    }

    public boolean isWaiting() {
        return accepted == StatusPedido.WAITING;
    }
}
