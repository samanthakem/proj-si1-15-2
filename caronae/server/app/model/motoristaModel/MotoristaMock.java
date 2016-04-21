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
    
    /**
     * Construtor da classe
     */
    public MotoristaMock()  {
         fillin();
    }
    
    /**
     * Recupera o MotoristaMock
     * @return motoristaMock
     */
    public static MotoristaMock getMotoristaMock() {
        if (motoristaMock == null)
            motoristaMock = new MotoristaMock();
        return motoristaMock;
    }
    
    /**
     * Recupera um motorista através da matrícula
     * @param matricula
     * @return
     */
    public Motorista get(String matricula) {
        if (!existeMotorista(matricula)) {
            throw new HttpException(404, "Motorista does not exist");
        }
        return motoristas.get(matricula);
    }
    
    /**
     * Verifica se um motorista existe através da matrícula
     * @param matricula
     * @return true se existir o motorista, caso contrário false
     */
    public boolean existeMotorista(String matricula) {
        return motoristas.containsKey(matricula);
    }
    
    /**
     * Adiciona um motorista e a matrícula numa lista de motoristas
     * @param motorista
     */
    public void add(Motorista motorista) {
        motoristas.put(motorista.getMatricula(), motorista);
    }
    
    private void fillin() {
    	Pessoa pessoa = GerenciadorDePessoas.getGerenciador().getPessoa("111111111");
        Motorista motorista = new Motorista(pessoa, idMotorista, qntVagas);
        motoristas.put(pessoa.getMatricula(), motorista);
    }
}
