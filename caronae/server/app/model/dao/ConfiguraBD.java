package model.dao;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by aline on 21/05/2016.
 */
public class ConfiguraBD {

    private static Statement declaracao = null;
    private static java.sql.Connection conexao = null;

    public static void main( String args[] ) throws SQLException {

        conexao = model.dao.Connection.getConnection();
        declaracao = conexao.createStatement();

        // Drop tables
        dropTables();

        // Create tables
        createTables();

        declaracao.close();
        conexao.close();

        System.out.println("BD configurado com sucesso");
    }

    private static void createTables() throws SQLException {
        declaracao.executeUpdate(ScriptSQL.getCreatePessoa());
        declaracao.executeUpdate(ScriptSQL.getCreatePassageiro());
        declaracao.executeUpdate(ScriptSQL.getCreateMotorista());
        declaracao.executeUpdate(ScriptSQL.getCreateCarona());
        declaracao.executeUpdate(ScriptSQL.getCreateNotificacao());
        declaracao.executeUpdate(ScriptSQL.getCreateEndereco());
        declaracao.executeUpdate(ScriptSQL.getCreateHorario());
    }

    private static void dropTables() throws SQLException {
        declaracao.executeUpdate("DROP TABLE Pessoa");
        declaracao.executeUpdate("DROP TABLE Passageiro");
        declaracao.executeUpdate("DROP TABLE Motorista");
        declaracao.executeUpdate("DROP TABLE Carona");
        declaracao.executeUpdate("DROP TABLE Notificacao");
        declaracao.executeUpdate("DROP TABLE Endereco");
        declaracao.executeUpdate("DROP TABLE Horario");
    }

}


