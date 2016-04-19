package model.motoristaModel;

import model.pessoaModel.GerenciadorDePessoas;

/**
 * Created by aline on 18/04/2016.
 */
public class MotoristaValidador {

    private GerenciadorDePessoas gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();

    public MotoristaValidador() {}

    public void validarExistenciaMotorista(String matricula) {
        // TODO verificar se existe uma pessoa com a matricula
    }

    public void validarCadastro(Motorista motorista) {
        //TODO verificar que existe uma pessoa com a matricula e que não existe motorista com a matricula
    }
}
