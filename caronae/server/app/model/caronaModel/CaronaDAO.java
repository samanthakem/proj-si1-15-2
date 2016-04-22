package model.caronaModel;

import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.DAOParameterErrors;
import exceptions.HttpException;
import model.Endereco;
import model.Horario;

import java.util.List;

public class CaronaDAO {
	
	private CaronaMock caronaMock;
    
    public CaronaDAO() {
        caronaMock = CaronaMock.getCaronaMock();
    }
    
    /**
     * Recupera uma carona da coleção de caronas
     * @param {String} id
     * 		ID da carona
     * @return {Object} carona
     * 		Retorna retorna a carona
     */
	public Carona getCarona(String id) {
		Carona carona;
		try {
			carona = caronaMock.get(id);
		} catch (HttpException ex) {
			throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO, ex)
					.addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Caronas")
					.addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, id);
		}
        return carona;
	}
	
	 /**
     * Salva a carona
     * @param {Object} carona
     * 		Carona que sera salva
     */
	public void persistirCarona(Carona carona) {
		try {
    		caronaMock.add(carona);
    	} catch (HttpException ex) {
    		throw new DAOException(DAOErroMensagem.SALVAR_ENTIDADE_JA_EXISTENTE, ex)
				.addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, carona.getId());
    	}
	}

	public int getQuantidadeTotalCaronas() {
		return caronaMock.getQuantidadeTotalCaronas();
	}

	public List<Carona> getCaronasDeMotorista(String matricula, Integer limite) {
		return caronaMock.getCaronasDeMotorista(matricula, limite);
	}
	
	public List<Carona> getCaronasDePassageiro(String matricula, Integer limite) {
		return caronaMock.getCaronasDePassageiro(matricula, limite);
	}

	public List<Carona> getCaronas(Endereco origem, Endereco destino, Horario horario, Integer limite) {
		return caronaMock.getCaronas(origem, destino, horario, limite);
	}

}
