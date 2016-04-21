package model.sessaoModel;

import model.pessoaModel.Pessoa;

/**
 * Created by gustavooliveira on 4/10/16.
 */
public class GerenciadorDeSessao {

    private Pessoa pessoa_logada;

    private static GerenciadorDeSessao gerenciador;

    public GerenciadorDeSessao() {}

    /**
     * @return A instancia de GerenciadorDePessoas
     */
    public static GerenciadorDeSessao getGerenciador() {
        if (gerenciador == null)
            gerenciador = new GerenciadorDeSessao();
        return gerenciador;
    }

    public Pessoa getPessoa_logada() {
        return pessoa_logada;
    }

    public void setPessoa_logada(Pessoa pessoa_logada) {
        this.pessoa_logada = pessoa_logada;
    }
}
