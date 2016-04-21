package model.motoristaModel;

import exceptions.DAOException;
import exceptions.HttpException;

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
            motorista = motoristaMock.get(matricula);
        } catch (HttpException ex) {
            //throw new DAOException();
        }
        return motorista;
    }
    
    /**
     * Armazena o novo motorista recebido
     * @param motorista
     */
    public void persistirMotorista(Motorista motorista) {
        try {
            motoristaMock.add(motorista);
        } catch (HttpException ex) {
            throw new DAOException(null);
        }
    }
    /**
     * Procura um motorista através da matrícula
     * @param matricula
     * @return true se encontra, caso contrário false
     */
    public boolean existeMotorista(String matricula) {
        return motoristaMock.existeMotorista(matricula);
    }
}
