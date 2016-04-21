package model.notificacaoModel;

import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.DAOParameterErrors;
import exceptions.HttpException;

import model.notificacaoModel.Notificacao.ParaTipo;

import java.util.List;

/**
 * Created by stenio on 4/18/2016.
 */
public class NotificacaoDao {
    private NotificacaoMock notificacaoMock = new NotificacaoMock();

    public Notificacao getNotificacao(String idNotificacao) {
        Notificacao notificacao;
        try {
            notificacao = notificacaoMock.get(idNotificacao);
        } catch (HttpException ex) {
            throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO, ex)
                    .addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Notificacoes")
                    .addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, idNotificacao);
        }
        return notificacao;
    }

    public void persistirNotificacao(Notificacao notificacao) {
        try {
            notificacaoMock.add(notificacao);
        } catch (HttpException ex) {
            throw new DAOException(DAOErroMensagem.SALVAR_ENTIDADE_JA_EXISTENTE, ex)
                    .addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, notificacao.getIdNotificacao());
        }
    }

    public List<Notificacao> getNotificacoes(String matricula, int limite, ParaTipo tipo) {
        return notificacaoMock.getNotificacoes(matricula, limite, tipo);
    }


    public List<Notificacao> getNotificacoes(String matricula, long inicio, long fim, int limite, boolean reverse, ParaTipo tipo) {
        return notificacaoMock.getNotificacoes(matricula, inicio, fim, limite, reverse, tipo);
    }
}
