package model.pessoaModel;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by stenio on 4/3/2016.
 */
public class Pessoa {

    private String nome,
            bairro,
            rua,
            email,
            telefone,
            senha,
            matricula;

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
     * A informação da Pessoa em formato JSON
     * @return A informação da Pessoa
     */
    public JsonNode toJson() {
        return Json.parse("{\"id\":\"" + this.matricula + "\"}");
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
        if(nome == null || nome.equals("")) {
            throw new IllegalArgumentException("Parâmetro 'nome' recebendo valores inválidos");
        }
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
        if(bairro == null || bairro.equals("")) {
            throw new IllegalArgumentException("Parâmetro 'bairro' recebendo valores inválidos");
        }
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
        if(rua == null || rua.equals("")) {
            throw new IllegalArgumentException("Parâmetro 'rua' recebendo valores inválidos");
        }
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
        if(email == null || email.equals("") || !isEmailValid(email)) {
            throw new IllegalArgumentException("Parâmetro 'email' recebendo valores inválidos");
        } else if (isEmailValid(email)) {
            this.email = email;
        }
    }

    /**
     * Verifica se o email passado como parâmetro é válido
     * @param email o email a ser verificado
     * @return true se o email é válido e false, caso contrário
     */
    private boolean isEmailValid(String email) {
        boolean isValid = false;
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
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
        if(telefone == null || telefone.equals("")) {
            throw new IllegalArgumentException("Parâmetro 'telefone' recebendo valores inválidos");
        }
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
        if(matricula.length() != 9) {
            throw new IllegalArgumentException("Parâmetro 'matrícula' deve conter exatamente 9 dígitos");
        }
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
        int tamanhoMinimo = 6;
        if(senha == null || senha.equals("") || senha.length() < tamanhoMinimo) {
            throw new IllegalArgumentException("Parâmetro 'senha' recebendo valores inválidos");
        }
        this.senha = senha;
    }
}
