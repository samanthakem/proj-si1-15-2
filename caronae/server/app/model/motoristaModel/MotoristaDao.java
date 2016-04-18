package model.motoristaModel;

import exceptions.HttpException;

/**
 * Created by aline on 18/04/2016.
 */
public class MotoristaDao {

    private MotoristaMock motoristaMock;

    public MotoristaDao() {
        motoristaMock = MotoristaMock.getMotoristaMock();
    }

    public Motorista getMotorista(String matricula) {
        Motorista motorista = null;
        try {
            motorista = motoristaMock.get(matricula);
        } catch (HttpException ex) {
            //throw new DAOException();
        }
        return motorista;
    }

    public void persistirMotorista(Motorista motorista) {
        try {
            motoristaMock.add(motorista);
        } catch (HttpException ex) {
            //throw new DAOException();
        }
    }

    public boolean existeMotorista(String matricula) {
        return motoristaMock.existeMotorista(matricula);
    }
}
