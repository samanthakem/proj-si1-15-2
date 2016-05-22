package model.dao;

/**
 * Created by aline on 21/05/2016.
 */
public class ScriptSQL {

    public static String getCreatePessoa() {

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE Pessoa ( ");
        sqlBuilder.append("ID_Pessoa\tSERIAL\tPRIMARY KEY, "); // deixar o ID do BD como primary key msm
        sqlBuilder.append("Nome_Pessoa\tCHAR(32)\tNOT NULL, ");
        sqlBuilder.append("Email_Pessoa\tCHAR(32)\tNOT NULL, ");
        sqlBuilder.append("Telefone_Pessoa\tCHAR(32)\tNOT NULL, ");
        sqlBuilder.append("Senha_Pessoa\tCHAR(8)\tNOT NULL, ");
        sqlBuilder.append("Matricula_Pessoa\tCHAR(32)\tUNIQUE NOT NULL");
        sqlBuilder.append(")");

        return sqlBuilder.toString();
    }

    public static String getCreatePassageiro() {

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE Passageiro ( ");
        sqlBuilder.append("ID_Passageiro\tSERIAL\tPRIMARY KEY, ");
        sqlBuilder.append("Pessoa_Associada\tINT\treferences Pessoa(ID_Pessoa)");
        sqlBuilder.append(")");

        return sqlBuilder.toString();
    }

    public static String getCreateMotorista() {

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE Motorista ( ");
        sqlBuilder.append("ID_Motorista\tSERIAL\tPRIMARY KEY, ");
        sqlBuilder.append("Pessoa_Associada\tINT\treferences Pessoa(ID_Pessoa), ");
        sqlBuilder.append("Qtd_Vagas_Carro\tINT\tNOT NULL");
        sqlBuilder.append(")");

        return sqlBuilder.toString();
    }

    public static String getCreateCarona() {

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE Carona (" );
        sqlBuilder.append("ID_Carona\tSERIAL\tPRIMARY KEY, ");
        sqlBuilder.append("Motorista_Associado\tINT\treferences Motorista(ID_Motorista), ");
        sqlBuilder.append("Qtd_Vagas_Disponiveis\tINT\tNOT NULL, ");
        sqlBuilder.append("Endereco_Inicio\tINT\treferences Endereco(ID_Endereco), ");
        sqlBuilder.append("Endereco_Destino\tINT\treferences Endereco(ID_Endereco), ");
        sqlBuilder.append("Horario_Carona\tINT\treferences Horario(ID_Horario)");
        // passageiros
        sqlBuilder.append(")");

        return sqlBuilder.toString();
    }

    public static String getCreateNotificacao() {

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE Notificacao (" );
        sqlBuilder.append("ID_Notificacao\t\t\tSERIAL\t\tPRIMARY KEY, ");
        sqlBuilder.append("Razao_Notificacao\tCHAR(32)\tNOT NULL, ");
        sqlBuilder.append("Pessoa_Que_Envia\t\tINT\t\t\treferences Pessoa(ID_Pessoa), ");
        sqlBuilder.append("Pessoa_Que_Recebe\t\tINT\t\t\treferences Pessoa(ID_Pessoa), ");
        sqlBuilder.append("Timestemp_Notificacao\tLONG\tNOT NULL");

        // ParaTipo paraTipo;
        sqlBuilder.append(")");

        return sqlBuilder.toString();
    }

    public static String getCreateEndereco() {

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE Endereco ( ");
        sqlBuilder.append("ID_Endereco\t\t\tSERIAL\t\tPRIMARY KEY, ");
        sqlBuilder.append("Rua\t\t\t\t\tCHAR(64)\tNOT NULL, ");
        sqlBuilder.append("Numero\t\t\t\tCHAR(8)\t\tNOT NULL, ");
        sqlBuilder.append("Bairro\t\t\t\tCHAR(16)\tNOT NULL");
        //sqlBuilder.append("Dono_Endereco\t\tINT\t\t\treferences Confeiteiro(ID_Confeiteiro)");
        sqlBuilder.append(")");

        return sqlBuilder.toString();
    }

    public static String getCreateHorario() {

        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE Horario ( ");
        sqlBuilder.append("ID_Horario\t\t\tSERIAL\t\tPRIMARY KEY, ");
        sqlBuilder.append("Hora\t\t\t\t\tCHAR(64)\tNOT NULL, ");
        sqlBuilder.append("Dia\t\t\t\tCHAR(8)\t\tNOT NULL");
        sqlBuilder.append(")");

        return sqlBuilder.toString();
    }

}


