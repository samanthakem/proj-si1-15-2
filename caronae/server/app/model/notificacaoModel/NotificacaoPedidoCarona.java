package model.notificacaoModel;

import model.caronaModel.Carona;
import model.pessoaModel.Pessoa;

/**
 * Created by stenio on 4/19/2016.
 */
public class NotificacaoPedidoCarona extends Notificacao {
    private boolean accepted = false;
    private Carona carona;

    public NotificacaoPedidoCarona(String idNotificacao, Pessoa de, Pessoa para, String razao, long timestamp, ParaTipo paraTipo) {
        super(idNotificacao, de, para, razao, timestamp, paraTipo);
    }

    public boolean accept() {
        accepted = true;

        return accepted;
    }

    public NotificacaoPedidoCarona setCarona(Carona carona) {
        this.carona = carona;

        return this;
    }

    public Carona getCarona() {
        return this.carona;
    }

    public boolean getStatus() {
        return this.accepted;
    }
}
