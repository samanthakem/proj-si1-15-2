package model.dao;

import model.dao.exceptions.RequisicaoInvalidaBD;
import model.passageiroModel.Passageiro;
import model.pessoaModel.Pessoa;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by aline on 27/05/2016.
 */
public class Passageiro_DAO {

    private static java.sql.Connection conexao = null;
    private static Statement declaracao = null;
    private static String strSql;

    // Para persistir o passageiro, primeiro se faz um Pessoa_DAO.getPessoa("matriculaDaPessoa") também
    public static void persistirPassageiro(Passageiro passageiro) throws RequisicaoInvalidaBD {

        try {
            conexao = model.dao.Connection.getConnection();
            declaracao = conexao.createStatement();

            Pessoa pessoa = Pessoa_DAO.getPessoa(passageiro.getMatricula());

            if(pessoa != null) {
                strSql = "INSERT INTO Passageiro (Pessoa_Associada)" +
                        "VALUES('" + passageiro.getPessoa().getId() + "')";
                declaracao.executeUpdate(strSql);
            } else {
                // Não existe pessoa associada
            }

            declaracao.close();
            conexao.close();

        } catch (Exception e) {
            RequisicaoInvalidaBD exception = new RequisicaoInvalidaBD(e.getMessage());
            exception.setStackTrace(e.getStackTrace());
            throw exception;
        }

    }

    public static Passageiro getPassageiro(String matricula) throws RequisicaoInvalidaBD {
        try {
            ResultSet resultado;
            conexao = model.dao.Connection.getConnection();
            declaracao = conexao.createStatement();
            Passageiro passageiroResp = new Passageiro();

            Pessoa pessoa = Pessoa_DAO.getPessoa(matricula);

            if(pessoa != null) {
                strSql = "SELECT * FROM Passageiro p WHERE p.Pessoa_Associada='" + pessoa.getId() + "';";
                resultado = declaracao.executeQuery(strSql);
                resultado.next();

                passageiroResp.setPessoa(pessoa);
                passageiroResp.setId(resultado.getInt("ID_Passageiro"));
            } else {

            }

            declaracao.close();
            conexao.close();
            return passageiroResp;
        } catch (Exception e) {
            RequisicaoInvalidaBD exception = new RequisicaoInvalidaBD(e.getMessage());
            exception.setStackTrace(e.getStackTrace());
            throw exception;
        }
    }

    public static boolean existePassageiro(String matricula) {
        Passageiro passageiro = getPassageiro(matricula);
        if(passageiro != null) {
            return true;
        } else {
            return false;
        }
    }
}
