package model.passageiroModel;

import exceptions.*;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import model.pessoaModel.PessoaDao;
import play.mvc.Http.Status;
import util.UtilsValidacao;

/**
 * Created by aline on 19/04/2016.
 */
public class PassageiroValidador {

    private static final String PASSAGEIRO = "Passageiro";
    private static final String PESSOA = "Pessoa";
    private static final String ID_CARONA = "Id da carona";
    private static final String ID_HORARIO = "Id do horario";
    private static final String MATRICULA = "Matrícula";

    private PassageiroDao passageiroDao = new PassageiroDao();

    private PessoaDao dao = new PessoaDao();


    /**
     * Construtor padrão
     */
    public PassageiroValidador() {}

    /**
     * Valida se o passageiro a ser cadastrado eh valido.
     * @param {Object} passageiro
     * 		passageiro a ser validado
     */
    public void validarCadastro(Passageiro passageiro) {
        if (passageiro == null) {
            throw new ValidacaoFieldsException().addTemplateComParametro(
                    ValidacaoErroMensagem.VALOR_NULL,
                    ValidacaoParameterErrors.OBJETO, PASSAGEIRO);
        }
        validarPessoaCadastrada(passageiro.getPessoa());
    }

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

    public void validarIdCarona(String idCarona) {
        UtilsValidacao.validaCampoNaoPreenchido(idCarona, ID_CARONA);
    }

    public void validarIdHorario(String idHorario) {
        UtilsValidacao.validaCampoNaoPreenchido(idHorario, ID_HORARIO);
    }

    /**
     * Valida se o passageiro ja foi criado.
     * @param {String} matricula
     * 		Matricula referente ao passageiro a ser pesquisado
     */
    public void validarExistenciaPassageiro(String matricula) {
        UtilsValidacao.validaCampoNaoPreenchido(matricula, MATRICULA);
        boolean passageiroExiste = passageiroDao.getPassageiro(matricula) != null;
        if (!passageiroExiste) {
            throw new DAOException(DAOErroMensagem.CONSULTA_ID_NAO_ENCONTRADO).setCodigoErro(Status.NOT_FOUND)
                    .addParametroParaMensagem(DAOParameterErrors.NOME_ARRAY, "Lista de Passageiros")
                    .addParametroParaMensagem(DAOParameterErrors.ID_DA_ENTIDADE, matricula);
        }
    }
}
