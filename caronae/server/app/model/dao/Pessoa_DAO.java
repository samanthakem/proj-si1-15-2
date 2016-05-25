package model.dao;

import java.sql.ResultSet;
import model.dao.exceptions.RequisicaoInvalidaBD;
import model.pessoaModel.Pessoa;
import java.sql.Statement;

/**
 * Created by aline on 24/05/2016.
 */
public class Pessoa_DAO {

    private static java.sql.Connection conexao = null;
    private static Statement declaracao = null;
    private static String strSql;

    public static void persistirPessoa(Pessoa pessoa) throws RequisicaoInvalidaBD {

        try {
            conexao = model.dao.Connection.getConnection();
            declaracao = conexao.createStatement();

            strSql = "INSERT INTO Pessoa (Nome_Pessoa, Email_Pessoa, Telefone_Pessoa, Senha_Pessoa, Matricula_Pessoa)" +
                    "VALUES('" + pessoa.getNome() + "','" + pessoa.getEmail() + "','" + pessoa.getTelefone() + "','" +
                            pessoa.getSenha() + "','" + pessoa.getMatricula() + "')";

            declaracao.executeUpdate(strSql);
            declaracao.close();
            conexao.close();

        } catch (Exception e) {
            RequisicaoInvalidaBD exception = new RequisicaoInvalidaBD(e.getMessage());
            exception.setStackTrace(e.getStackTrace());
            throw exception;
        }
    }

    public static Pessoa getPessoa(String matricula) throws RequisicaoInvalidaBD {
        try {
            ResultSet resultado;
            conexao = model.dao.Connection.getConnection();
            declaracao = conexao.createStatement();
            strSql = "SELECT * FROM Pessoa c WHERE c.Matricula_Pessoa='" + matricula + "';";
            resultado = declaracao.executeQuery(strSql);

            Pessoa pessoaResp = new Pessoa();

            resultado.next();
            pessoaResp.setNome(resultado.getString("Nome_Pessoa"));
            pessoaResp.setEmail(resultado.getString("Email_Pessoa"));
            pessoaResp.setTelefone(resultado.getString("Telefone_Pessoa"));
            pessoaResp.setSenha(resultado.getString("Senha_Pessoa"));
            pessoaResp.setMatricula(resultado.getString("Matricula_Pessoa"));

            declaracao.close();
            conexao.close();
            return pessoaResp;
        } catch (Exception e) {
            RequisicaoInvalidaBD exception = new RequisicaoInvalidaBD(e.getMessage());
            exception.setStackTrace(e.getStackTrace());
            throw exception;
        }
    }
}
