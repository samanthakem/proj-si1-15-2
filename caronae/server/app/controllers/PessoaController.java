package controllers;

import model.HttpException;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;
import play.mvc.Controller;
import play.mvc.Result;

import static play.data.Form.form;

/**
 * Created by stenio on 4/3/2016.
 */
public class PessoaController extends Controller {
    private GerenciadorDePessoas gerenciadorDePessoas = GerenciadorDePessoas.getGerenciador();

    /**
     * Recupera uma pessoa da coleção de pessoas
     * @param matricula A matricula da Pessoa
     * @return Um JSON com as informações da pessoa se foi possível recuperar, caso contrário a explicação em formato JSON.
     */
    public Result getPessoa(String matricula) {
        Result result;

        try {
            System.out.print(matricula);
            Pessoa pessoa = gerenciadorDePessoas.getPessoa(matricula);
            result = ok(pessoa.toJson());
        } catch (HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }

    /**
     * Adiciona uma pessoa a coleção de pessoas
     * @return Um JSON com as informações da pessoa se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    public Result addPessoa() {
        Pessoa r = form(Pessoa.class).bindFromRequest().get();

        String nome = r.getNome();
        String bairro = r.getBairro();
        String rua = r.getRua();
        String email = r.getEmail();
        String telefone = r.getTelefone();
        String senha = r.getSenha();
        String matricula = r.getMatricula();

        return addPessoa(nome, bairro, rua, email, telefone, senha, matricula);
    }

    /**
     * Adiciona uma pessoa a coleção de pessoas
     * @param nome o nome da nova pessoa
     * @param bairro o bairro da nova pessoa
     * @param rua a rua da nova pessoa
     * @param email o email da nova pessoa
     * @param telefone o telefone da nova pessoa
     * @param senha a senha da nova pessoa
     * @param matricula a matricula da nova pessoa
     * @return Um JSON com as informações da pessoa se foi possível adicionar, caso contrário a explicação em formato JSON.
     */
    private Result addPessoa(String nome, String bairro, String rua, String email, String telefone, String senha, String matricula) {
        Result result;

        try {
            Pessoa pessoa = gerenciadorDePessoas.addPessoa(nome, bairro, rua, email, telefone, senha, matricula);

            result = ok(pessoa.toJson());
        } catch(HttpException e) {
            result = status(e.getStatus(), e.getJSONMessage());
        }

        return result;
    }
}
