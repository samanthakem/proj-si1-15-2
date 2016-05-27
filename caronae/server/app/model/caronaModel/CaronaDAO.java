package model.caronaModel;

import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.DAOParameterErrors;
import exceptions.HttpException;
import model.Horario;
import model.motoristaModel.Motorista;
import model.passageiroModel.Passageiro;

import java.util.Set;

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
					.addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, id.toString());
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
			Integer hash = carona.hashCode();
    		throw new DAOException(DAOErroMensagem.SALVAR_ENTIDADE_JA_EXISTENTE, ex)
				.addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, hash.toString());
    	}
	}

	public int getQuantidadeTotalCaronas() {
		return caronaMock.getQuantidadeTotalCaronas();
	}

	public Set<Carona> getCaronasDeMotorista(Motorista motorista) {
		System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Entrou CARONA DAO \n");
		return caronaMock.getCaronasDeMotorista(motorista);
	}
	
	public Set<Carona> getCaronasDePassageiro(Passageiro passageiro) {
		return caronaMock.getCaronasDePassageiro(passageiro);
	}

	public Set<Carona> getCaronas(String bairroOrigem, String bairroDestino, Horario horario) {
		return caronaMock.getCaronas(bairroOrigem, bairroDestino, horario);
	}
	
	public boolean existeCarona(String nome){
		return caronaMock.existeCarona(nome);
	}

}
