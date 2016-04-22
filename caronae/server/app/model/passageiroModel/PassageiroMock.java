package model.passageiroModel;

import exceptions.HttpException;
import model.Endereco;
import model.pessoaModel.GerenciadorDePessoas;
import model.pessoaModel.Pessoa;

import java.util.HashMap;

/**
 * Created by aline on 19/04/2016.
 */
public class PassageiroMock {

    private static PassageiroMock passageiroMock;

    private HashMap<String, Passageiro> passageiros = new HashMap<>();

    public PassageiroMock()   {
        fillin();
    }

    public static PassageiroMock getPassageiroMock() {
        if (passageiroMock == null)
            passageiroMock = new PassageiroMock();
        return passageiroMock;
    }

    public void add(Passageiro passageiro) {
        passageiros.put(passageiro.getMatricula(), passageiro);
    }

    public void atualizarPassageiro(Passageiro passageiro) {
        //TODO
    }

    public Passageiro get(String matricula) {
        if (!existePassageiro(matricula)) {
            throw new HttpException(404, "Passageiro does not exist");
        }
        return passageiros.get(matricula);
    }

    public boolean existePassageiro(String matricula) {
        return passageiros.containsKey(matricula);
    }

    private void fillin() {
        GerenciadorDePessoas ger = GerenciadorDePessoas.getGerenciador();

        Endereco meuEndereco = new Endereco("00", "Rua dos bobos", "Centro");
        Pessoa pessoa = new Pessoa("Passageiro Maior Da Silva Sauro", meuEndereco,
                "passageiro.meupassageiro@caronae.com.br", "83999996666", "admin3", "333333333");

        ger.addPessoa(pessoa);

        Passageiro passageiro = new Passageiro(pessoa);
        passageiros.put(pessoa.getMatricula(), passageiro);

        pessoa = ger.getPessoa("111111111");

        passageiro = new Passageiro(pessoa);
        passageiros.put(pessoa.getMatricula(), passageiro);
    }
}
