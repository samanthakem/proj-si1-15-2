package model.dao;

import model.dao.exceptions.RequisicaoInvalidaBD;
import model.notificacaoModel.Notificacao;
import model.pessoaModel.Pessoa;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by aline on 25/05/2016.
 */
public class Notificacao_DAO {

    private static java.sql.Connection conexao = null;
    private static Statement declaracao = null;
    private static Statement declaracao2 = null;
    private static Statement declaracao3 = null;
    private static String strSql, strSql2, strSql3;

    public static void persistirNotificacao(Notificacao notificacao) throws RequisicaoInvalidaBD {

        try {
            conexao = model.dao.Connection.getConnection();
            declaracao = conexao.createStatement();

            Pessoa pessoaDe = Pessoa_DAO.getPessoa(notificacao.getDe().getMatricula());
            Pessoa pessoaPara = Pessoa_DAO.getPessoa(notificacao.getPara().getMatricula());

            if (pessoaDe != null && pessoaPara != null) {
                strSql = "INSERT INTO Notificacao (Razao_Notificacao, Pessoa_Que_Envia, Pessoa_Que_Recebe, Timestemp_Notificacao)" +
                        "VALUES('" + notificacao.getRazao() + "','" + notificacao.getDe().getId() + "','" + notificacao.getPara().getId() + "','" + notificacao.getTimestamp() + "')";
                declaracao.executeUpdate(strSql);
            } else {
                // Não existe pessoas associadas à notificacao
            }

            declaracao.close();
            conexao.close();

        } catch (Exception e) {
            RequisicaoInvalidaBD exception = new RequisicaoInvalidaBD(e.getMessage());
            exception.setStackTrace(e.getStackTrace());
            throw exception;
        }
    }

    // verificar commo ficam as chamadas q já existem, usando int id
    public static Notificacao getNotificacao(int idNotificacao) throws RequisicaoInvalidaBD {
        try {
            ResultSet resultado, resultado2, resultado3;
            conexao = model.dao.Connection.getConnection();
            declaracao = conexao.createStatement();

            Notificacao notificacaoResp = new Notificacao();

            strSql = "SELECT * FROM Notificacao n WHERE n.ID_Notificacao='" + idNotificacao + "';";
            resultado = declaracao.executeQuery(strSql);
            resultado.next();

            notificacaoResp.setRazao(resultado.getString("Razao_Notificacao"));
            notificacaoResp.setDe(Pessoa_DAO.getPessoa(resultado.getInt("Pessoa_Que_Envia")));
            notificacaoResp.setPara(Pessoa_DAO.getPessoa(resultado.getInt("Pessoa_Que_Recebe")));
            notificacaoResp.setTimestamp(resultado.getInt("Timestemp_Notificacao"));

            declaracao.close();
            conexao.close();
            return notificacaoResp;
        } catch (Exception e) {
            RequisicaoInvalidaBD exception = new RequisicaoInvalidaBD(e.getMessage());
            exception.setStackTrace(e.getStackTrace());
            throw exception;
        }
    }
}

