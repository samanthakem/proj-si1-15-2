package model.caronaModel;

import play.mvc.Http.Status;
import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.DAOParameterErrors;
import exceptions.ValidacaoErroMensagem;
import exceptions.ValidacaoFieldsException;
import exceptions.ValidacaoParameterErrors;
import model.Endereco;
import model.Horario;
import util.UtilsValidacao;

/**
 * Classe responsavel pela validacao da entidade {@Carona}
 * @author Samantha Monteiro
 *
 */
public class CaronaValidador {
	
	private static final String CARONA = "Carona";

	private static final String ID_MOTORISTA = "Id do Motorista";

	private static final String QNT_VAGAS = "Quantidade de vagas disponiveis";

	private static final String PONTO_INICIAL = "Ponto Inicial";
	
	private static final String DESTINO = "Destino";
	
	private static final String HORARIO = "Horario";
	
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
	public void validarCamposCarona(Carona carona) {
		validarIdMotorista(carona.getMotorista().getMatricula());
		validarQntVagasDisponiveis(carona.getQntVagasDisponiveis());
		validarPontoInicial(carona.getPontoInicial());
		validarDestino(carona.getDestino());
		validarHorario(carona.getHorario());
	}

	public void validarHorario(Horario horario) {
		if (horario == null) {
			throw new ValidacaoFieldsException().addTemplateComParametro(
					ValidacaoErroMensagem.VALOR_NULL, 
					ValidacaoParameterErrors.OBJETO, HORARIO);
		}
	}

	public void validarDestino(Endereco destino) {
		if (destino == null) {
			throw new ValidacaoFieldsException().addTemplateComParametro(
					ValidacaoErroMensagem.VALOR_NULL, 
					ValidacaoParameterErrors.OBJETO, DESTINO);
		}
	}

	public void validarPontoInicial(Endereco pontoInicial) {
		if (pontoInicial == null) {
			throw new ValidacaoFieldsException().addTemplateComParametro(
					ValidacaoErroMensagem.VALOR_NULL, 
					ValidacaoParameterErrors.OBJETO, PONTO_INICIAL);
		}
	}

	public void validarQntVagasDisponiveis(int qntVagasDisponiveis) {
		UtilsValidacao.validaCampoNaoPreenchido(Integer.toString(qntVagasDisponiveis), QNT_VAGAS);
	}

	public void validarIdMotorista(String idMotorista) {
		UtilsValidacao.validaCampoNaoPreenchido(idMotorista, ID_MOTORISTA);	
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
