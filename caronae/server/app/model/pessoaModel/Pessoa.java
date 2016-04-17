package model.pessoaModel;

import com.fasterxml.jackson.databind.JsonNode;

import model.Entidade;
import play.libs.Json;

/**
 * Created by stenio on 4/3/2016.
 */
public class Pessoa extends Entidade {

    private String nome,
            bairro,
            rua,
            email,
            telefone,
            senha,
            matricula;

    public Pessoa() {}

    /**
     * Construtor padrão.
     * @param nome o nome da Pessoa
     * @param bairro o bairro da Pessoa
     * @param rua a rua da Pessoa
     * @param email o email da Pessoa
     * @param telefone o telefone da Pessoa
     * @param senha a senha da Pessoa
     * @param matricula a matricula da Pessoa
     */
    public Pessoa(String nome, String bairro, String rua, String email, String telefone, String senha, String matricula) {
        setNome(nome);
        setBairro(bairro);
        setRua(rua);
        setEmail(email);
        setTelefone(telefone);
        setMatricula(matricula);
        setSenha(senha);
    }

    /**
     * Recupera o nome da Pessoa
     * @return o nome da Pessoa
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome da Pessoa, caso o parâmetro seja válido
     * @param nome o novo nome da Pessoa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Recupera o bairro da Pessoa
     * @return o bairro da Pessoa
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Modifica o bairro da Pessoa, caso o parâmetro seja válido
     * @param bairro  o novo bairro da Pessoa
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Recupera a rua da Pessoa
     * @return a rua da Pessoa
     */
    public String getRua() {
        return rua;
    }

    /**
     * Modifica a rua da Pessoa, caso o parâmetro seja válido
     * @param rua a nova rua da Pessoa
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Recupera o email da Pessoa
     * @return o novo email da Pessoa
     */
    public String getEmail() {
        return email;
    }

    /**
     * Modifica o email da Pessoa, caso o parâmetro seja válido
     * @param email o novo email da Pessoa
     */
    public void setEmail(String email) {
    	this.email = email;
    }

    /**
     * Recupera o telefone da Pessoa
     * @return o telefone da Pessoa
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Modifica o telefone da Pessoa, caso o parâmetro seja válido
     * @param telefone o novo telefone da Pessoa
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Recupera a matrícula da Pessoa
     * @return a matrícula da Pessoa
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Modifica a matrícula da Pessoa, caso o parâmetro seja válido
     * @param matricula a nova matrícula da Pessoa
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Recupera a senha da Pessoa
     * @return a senha da Pessoa
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Modifica a senha da Pessoa, caso o parâmetro seja válido
     * @param senha a nova senha da Pessoa
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
