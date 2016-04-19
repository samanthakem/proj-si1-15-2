package model.motoristaModel;

import model.caronaModel.Carona;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;

import java.util.HashMap;

import exceptions.HttpException;

/**
 * Created by stenio on 4/3/2016.
 */
public class GerenciadorDeMotoristas implements MotoristaService {
	
    private HashMap<Integer, Motorista> motoristas = new HashMap<>();
    
    private static GerenciadorDeMotoristas gerenciador;
    
    private MotoristaDAO dao = new MotoristaDAO();
    
    private GerenciadorDePessoas gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();

    private GerenciadorDeMotoristas() {};

    /**
     * @return A instancia de GerenciadorDeMotoristas
     */
    public static GerenciadorDeMotoristas getGerenciador() {
        if (gerenciador == null)
            gerenciador = new GerenciadorDeMotoristas();

        return gerenciador;
    }
    
    /**
     * Recupera um motorista da coleção de motoristas
     * @param id O id do motorista
     * @return retorna null se o não existir algum passgeiro com a mesma id que a id especificada, caso contrário retorna o passgeiro
     */
    public Motorista getMotorista(Integer id) throws HttpException {
        Motorista motorista = motoristas.get(id);

        if (motorista == null) {
            throw new HttpException(404, "motorista does not exist");
        }

        return motorista;
    }

    /**
     * Adiciona um motorista a coleção de motoristas
     * @param id O id do novo motorista
     * @return retorna false se não for possível adicionar o motorista a coleção, caso contrário retorna true.
     */
    public void addMotorista(Integer id) throws HttpException {
//        if (motoristas.containsKey(id)) {
//            throw new HttpException(409, "Motorista already exists");
//        } else if (!gerenciadorDePessoas.existePessoa(id)) {
//            throw new HttpException(404, "There is no Pessoa with this id. It is necessary to create a person before creating a motorista.");
//        } else {
//            Pessoa pessoa = gerenciadorDePessoas.getPessoa(id);
//
//            motoristas.put(id, new Motorista(pessoa));
//        }
    }

    /**
     * Verifica se existe algum motorista com aquele id;
     * @param id O id do motorista
     * @return true se existe um motorista com o mesmo id, caso contr[ario false
     */
    public boolean existeMotorista(Integer id) {
        return motoristas.containsKey(id);
    }

	@Override
	public Motorista getMotorista(String idMotorista) {
		//return dao.getMotorista(idMotorista);
		return null;
	}

	@Override
	public void addMotoristaNaCarona(Motorista motorista, Carona carona) {
		//motorista.setIdMotorista(carona.getId());
		//dao.atualizarMotorista(motorista);
	}
}
