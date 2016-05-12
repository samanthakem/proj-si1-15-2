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

    private static final String RAZAO = "pediu carona";

    private StatusPedido accepted = StatusPedido.WAITING;

    private Carona carona;

    public NotificacaoPedidoCarona(Pessoa de, Pessoa para, long timestamp, ParaTipo paraTipo, Carona carona) {
        super(de, para, RAZAO, timestamp, paraTipo);

        this.carona = carona;
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
