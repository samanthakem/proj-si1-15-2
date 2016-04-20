package model.motoristaModel;

import exceptions.HttpException;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;

import java.util.HashMap;

/**
 * Created by aline on 18/04/2016.
 */
public class MotoristaMock {
	
    private static MotoristaMock motoristaMock;

    private HashMap<String, Motorista> motoristas = new HashMap<>();
    
    private String idMotorista = "3";
    
    private int qntVagas = 4;

    public MotoristaMock()  {
         fillin();
    }

    public static MotoristaMock getMotoristaMock() {
        if (motoristaMock == null)
            motoristaMock = new MotoristaMock();
        return motoristaMock;
    }

    public Motorista get(String matricula) {
        if (!existeMotorista(matricula)) {
            throw new HttpException(404, "Motorista does not exist");
        }
        return motoristas.get(matricula);
    }

    public boolean existeMotorista(String matricula) {
        return motoristas.containsKey(matricula);
    }

    public void add(Motorista motorista) {
        motoristas.put(motorista.getMatricula(), motorista);
    }

    public void atualizarMotorista(Motorista motorista) {
        //TODO
    }

    private void fillin() {
    	Pessoa pessoa = GerenciadorDePessoas.getGerenciador().getPessoa("111111111");
        Motorista motorista = new Motorista(pessoa, idMotorista, qntVagas);
        motoristas.put(pessoa.getMatricula(), motorista);
    }
}
