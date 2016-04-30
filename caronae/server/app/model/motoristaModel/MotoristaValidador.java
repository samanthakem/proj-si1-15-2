package model.motoristaModel;

import exceptions.*;
import model.pessoaModel.Pessoa;
import model.pessoaModel.PessoaDao;
import play.mvc.Http.Status;
import util.UtilsValidacao;

/**
 * Created by aline on 18/04/2016.
 */
public class MotoristaValidador {

    private static final String MOTORISTA = "Motorista";
    private static final String PESSOA = "Pessoa";
    private static final String MATRICULA = "Matrícula";
    private static final String ID_CARONA = "Id da carona";
    private static final String QTD_VAGAS_CARRO = "Quantidade de vagas no carro";
    private static final int QTD_MINIMA_VAGAS_CARRO = 1;

    private MotoristaDao motoristaDao = new MotoristaDao();

    private PessoaDao dao = new PessoaDao();

    /**
     * Construtor padrão.
     */
    public MotoristaValidador() {}

    /**
     * Valida se o motorista a ser cadastrado eh valido.
     * @param {Object} motorista
     * 		motorista a ser validado
     */
    public void validarCadastro(Motorista motorista) {
        if (motorista == null) {
            throw new ValidacaoFieldsException().addTemplateComParametro(
                    ValidacaoErroMensagem.VALOR_NULL,
                    ValidacaoParameterErrors.OBJETO, MOTORISTA);
        }
        validarCamposMotorista(motorista);
    }

    /**
     * Verifica se todos os campos do motorista sao validos.
     * @param {Object} motorista
     * 		motorista cujos campos serao validados
     */
    public void validarCamposMotorista(Motorista motorista) {
        validarPessoaCadastrada(motorista.getPessoa());
        validarQtdVagasCarro(motorista.getQuantidadeVagasCarro());
    }
    
    /**
     * Verifica se a quantidade de vagas no carro é válida
     * @param qtdVagasCarro
     */
    public void validarQtdVagasCarro(int qtdVagasCarro) {
        UtilsValidacao.validaCampoNaoPreenchido(Integer.toString(qtdVagasCarro), QTD_VAGAS_CARRO);
        if (qtdVagasCarro < QTD_MINIMA_VAGAS_CARRO) {
            throw new ValidacaoFieldsException().addTemplateComParametro(
                    ValidacaoErroMensagem.VALOR_INVALIDO,
                    ValidacaoParameterErrors.OBJETO, QTD_VAGAS_CARRO);
        }
    }

    /**
     * Verifica se uma pessoa está cadastrada
     * @param pessoa
     */
    public void validarPessoaCadastrada(Pessoa pessoa) {
        if (pessoa == null) {
            throw new ValidacaoFieldsException().addTemplateComParametro(
                    ValidacaoErroMensagem.VALOR_NULL,
                    ValidacaoParameterErrors.OBJETO, PESSOA);
        }
        boolean pessoaExiste = dao.getPessoa(pessoa.getMatricula()) != null;
        if (!pessoaExiste) {
            throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO).setCodigoErro(Status.NOT_FOUND)
                    .addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Pessoas")
                    .addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, pessoa.getMatricula());
        }
    }
    
    /**
     * Verifica se uma ID de carona é válida
     * @param idCarona
     */
    public void validarIdCarona(String idCarona) {
        UtilsValidacao.validaCampoNaoPreenchido(idCarona, ID_CARONA);
    }

    /**
     * Valida se o motorista ja foi criado.
     * @param {String} matricula
     * 		Matricula referente ao motorista a ser pesquisado
     */
    public void validarExistenciaMotorista(String matricula) {
        UtilsValidacao.validaCampoNaoPreenchido(matricula, MATRICULA);
        boolean motoristaExiste = motoristaDao.getMotorista(matricula) != null;
        if (!motoristaExiste) {
            throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO).setCodigoErro(Status.NOT_FOUND)
                    .addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Motoristas")
                    .addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, matricula);
        }
    }

}
