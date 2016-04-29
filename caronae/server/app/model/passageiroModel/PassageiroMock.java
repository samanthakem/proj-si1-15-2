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
        Endereco endereco = new Endereco("92", "Sinha Alves", "Presidente Medici");
        Pessoa pessoa = new Pessoa("Caroneiro Maior Da Silva Santos", endereco,
                "caroneiro.mss@caronae.com.br", "83999996666", "admin1", "111111111");

        ger.addPessoa(pessoa);

        Passageiro passageiro = new Passageiro(pessoa);
        passageiros.put(pessoa.getMatricula(), passageiro);

        pessoa = ger.getPessoa("111111111");

        passageiro = new Passageiro(pessoa);
        passageiros.put(pessoa.getMatricula(), passageiro);
    }
}
