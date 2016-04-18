package model.caronaModel;

import javax.ws.rs.core.Response.Status;
import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.DAOParameterErrors;
import exceptions.ValidacaoErroMensagem;
import exceptions.ValidacaoFieldsException;
import exceptions.ValidacaoParameterErrors;

/**
 * Classe responsavel pela validacao da entidade {@Carona}
 * @author Samantha Monteiro
 *
 */
public class CaronaValidador {
	
	private static final String CARONA = "Carona";
	
	private CaronaDAO dao = new CaronaDAO();
	
	public CaronaValidador() {}
	
	/**
	 * Valida se a carona a ser cadastrada eh valida.
	 * @param {Object} carona
	 * 		Carona a ser validada
	 */
	public void validarCadastro(Carona carona) {
		if (carona == null) {
			throw new ValidacaoFieldsException().addTemplateComParametro(
					ValidacaoErroMensagem.VALOR_NULL,
					ValidacaoParameterErrors.OBJETO, CARONA);
		}
		validarCamposCarona(carona);
	}

	/**
	 * Valida se todos os campos de carona sao validos.
	 * @param {Object} carona
	 * 		Carona cujos campos serao validados
	 */
	private void validarCamposCarona(Carona carona) {
		// TODO Auto-generated method stub
	}

	/**
	 * Valida se a carona ja foi criada.
	 * @param {String} id
	 * 		ID referente a carona a ser procurada
	 */
	public void validarExistenciaCarona(String id) {
		if (id == null) {
			throw new DAOException(DAOErroMensagem.CONSULTA_ID_NULO).setCodigoErro(Status.NOT_FOUND)
				.addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Caronas");
		}
		boolean entidadeExiste = dao.getCarona(id) != null;
		if (!entidadeExiste) {
			throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO).setCodigoErro(Status.NOT_FOUND)
				.addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Caronas")
				.addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, id);
		}
	}
}