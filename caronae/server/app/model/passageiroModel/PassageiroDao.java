package model.passageiroModel;

import exceptions.HttpException;

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
            passageiro = passageiroMock.get(matricula);
        } catch (HttpException ex) {
            //throw new DAOException();
        }
        return passageiro;
    }

    public void persistirPassageiro(Passageiro passageiro) {
        try {
            passageiroMock.add(passageiro);
        } catch (HttpException ex) {
            //throw new DAOException();
        }
    }

    public boolean existePassageiro(String matricula) {
        return passageiroMock.existePassageiro(matricula);
    }
}
