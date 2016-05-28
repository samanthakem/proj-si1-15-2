package model.passageiroModel;

import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.DAOParameterErrors;
import exceptions.HttpException;
import model.dao.Passageiro_DAO;

/**
 * Created by aline on 18/04/2016.
 */
public class PassageiroDao {

    private PassageiroMock passageiroMock;

    public PassageiroDao() {
        passageiroMock = PassageiroMock.getPassageiroMock();
    }

    public Passageiro getPassageiro(String matricula) {
        Passageiro passageiro = null;
        try {
            //passageiro = passageiroMock.get(matricula);
            passageiro = Passageiro_DAO.getPassageiro(matricula);
        } catch (HttpException ex) {
            throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO, ex)
                    .addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Passageiros")
                    .addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, matricula);
        }
        return passageiro;
    }

    public void persistirPassageiro(Passageiro passageiro) {
        try {
            //passageiroMock.add(passageiro);
            Passageiro_DAO.persistirPassageiro(passageiro);
        } catch (HttpException ex) {
            throw new DAOException(DAOErroMensagem.SALVAR_ENTIDADE_JA_EXISTENTE, ex)
                    .addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, passageiro.getMatricula());
        }
    }

    public boolean existePassageiro(String matricula) {

        //return passageiroMock.existePassageiro(matricula);
        return Passageiro_DAO.existePassageiro(matricula);
    }

    public void atualizarPassageiro(Passageiro passageiro) {
        passageiroMock.atualizarPassageiro(passageiro);
    }
}
