package model.motoristaModel;

import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.DAOParameterErrors;
import exceptions.HttpException;
import model.dao.Motorista_DAO;

/**
 * Created by aline on 18/04/2016.
 */
public class MotoristaDao {

    private MotoristaMock motoristaMock;
    
    /**
     * Construtor de MotoristaDao
     */
    public MotoristaDao() {
        motoristaMock = MotoristaMock.getMotoristaMock();
    }
    
    /**
     * Recupera o motorista através da matrícula
     * @param matricula
     * @return motorista
     */
    public Motorista getMotorista(String matricula) {
        Motorista motorista = null;
        try {
            //motorista = motoristaMock.get(matricula);
            motorista = Motorista_DAO.getMotorista(matricula);
        } catch (HttpException ex) {
            throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO, ex)
                    .addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Motoristas")
                    .addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, matricula);
        }
        return motorista;
    }
    
    /**
     * Armazena o novo motorista recebido
     * @param motorista
     */
    public void persistirMotorista(Motorista motorista) {
        try {
            //motoristaMock.add(motorista);
            Motorista_DAO.persistirMotorista(motorista);
        } catch (HttpException ex) {
            throw new DAOException(DAOErroMensagem.SALVAR_ENTIDADE_JA_EXISTENTE, ex)
                    .addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, motorista.getMatricula());
        }
    }
    
    /**
     * Procura um motorista através da matrícula
     * @param matricula
     * @return true se encontra, caso contrário false
     */
    public boolean existeMotorista(String matricula) {

        //return motoristaMock.existeMotorista(matricula);
        return  Motorista_DAO.existeMotorista(matricula);
    }
    
    
    public void atualizarMotorista(Motorista motorista) {
        motoristaMock.atualizarMotorista(motorista);
    }
}
