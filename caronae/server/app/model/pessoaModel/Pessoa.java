package model.pessoaModel;

import com.fasterxml.jackson.databind.JsonNode;
import model.Endereco;
import play.libs.Json;

/**
 * Created by stenio on 4/3/2016.
 */
public class Pessoa {

    private String nome;
    
    private String email;
    
    private String telefone;
    
    private String senha;
    
    private String matricula;
    
    private Endereco endereco;

    private int id;

    /**
     * Construtor padrão.
     */
    public Pessoa() {}

    /**
     * Construtor que recebe todos os parâmetros.
     * @param nome o nome da Pessoa
     * @param endereco o endereco da Pessoa
     * @param email o email da Pessoa
     * @param telefone o telefone da Pessoa
     * @param senha a senha da Pessoa
     * @param matricula a matricula da Pessoa
     */
    public Pessoa(String nome, Endereco endereco, String email, String telefone, String senha, String matricula) {
        setNome(nome);
        setEndereco(endereco);
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Recupera o endereco da Pessoa
     * @return o endereco da Pessoa
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Modifica o endereco da Pessoa, caso o parâmetro seja válido
     * @param {Object} endereco 
     * 		 novo endereco da Pessoa
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
    
    @Override
	public boolean equals(Object objeto) {
		if (this == objeto) {
			return true;
		}
		
		if (!(objeto instanceof Pessoa)) {
			return false;
		}
		
		Pessoa outraPessoa = (Pessoa) objeto;
		return this.getMatricula().equals(outraPessoa.getMatricula());
	}
    
    public JsonNode toJson() {
        return Json.toJson(this);
    }

}
