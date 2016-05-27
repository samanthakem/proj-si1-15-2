package model.dao;

import model.Endereco;
import model.dao.exceptions.RequisicaoInvalidaBD;
import model.motoristaModel.GerenciadorDeMotoristas;
import model.motoristaModel.Motorista;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by aline on 24/05/2016.
 */
public class Motorista_DAO {

    private static java.sql.Connection conexao = null;
    private static Statement declaracao = null;
    private static String strSql;

    // Para persistir o motorista, primeiro se faz um Pessoa_DAO.getPessoa("matriculaDaPessoa")
    public static void persistirMotorista(Motorista motorista) throws RequisicaoInvalidaBD {

        try {
            conexao = model.dao.Connection.getConnection();
            declaracao = conexao.createStatement();

            Pessoa pessoa = Pessoa_DAO.getPessoa(motorista.getMatricula());

            if(pessoa != null) {
                strSql = "INSERT INTO Motorista (Pessoa_Associada, Qtd_Vagas_Carro)" +
                        "VALUES('" + motorista.getPessoa().getId()  + "','" + motorista.getQuantidadeVagasCarro() + "')";
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

    public static Motorista getMotorista(String matricula) throws RequisicaoInvalidaBD {
        try {
            ResultSet resultado;
            conexao = model.dao.Connection.getConnection();
            declaracao = conexao.createStatement();
            Motorista motoristaResp = new Motorista();

            Pessoa pessoa = Pessoa_DAO.getPessoa(matricula);

            if(pessoa != null) {
                strSql = "SELECT * FROM Motorista m WHERE m.Pessoa_Associada='" + pessoa.getId() + "';";
                resultado = declaracao.executeQuery(strSql);
                resultado.next();

                motoristaResp.setPessoa(pessoa);
                motoristaResp.setQuantidadeVagasCarro(resultado.getInt("Qtd_Vagas_Carro"));
                motoristaResp.setId(resultado.getInt("ID_Motorista"));
            } else {

            }

            declaracao.close();
            conexao.close();
            return motoristaResp;
        } catch (Exception e) {
            RequisicaoInvalidaBD exception = new RequisicaoInvalidaBD(e.getMessage());
            exception.setStackTrace(e.getStackTrace());
            throw exception;
        }
    }

    public static boolean existeMotorista(String matricula) {
        Motorista moto = getMotorista(matricula);
        if(moto != null) {
            return true;
        } else {
            return false;
        }
    }
}
