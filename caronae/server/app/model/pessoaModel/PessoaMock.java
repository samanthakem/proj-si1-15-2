package model.pessoaModel;

import java.util.HashMap;

import exceptions.HttpException;
import model.Endereco;

/**
 * Created by gustavooliveira on 4/7/16.
 */
public class PessoaMock {
    private static PessoaMock mock;

    private HashMap<String, Pessoa> pessoas = new HashMap<>();

    public PessoaMock() {
        fillin();
    }

    public static PessoaMock getPessoaMock() {
        if (mock == null)
            mock = new PessoaMock();
        return mock;
    }

    public Pessoa get(String matricula) {
        if (!contemPessoa(matricula)) {
        	throw new HttpException(404, "Pessoa does not exist");
        }
        return pessoas.get(matricula);
    }

    public boolean contemPessoa(String matricula) {
        return pessoas.containsKey(matricula);
    }

    public void add(Pessoa pessoa) throws HttpException {
    	if (this.contemPessoa(pessoa.getMatricula())) {
			throw new HttpException(409, "Pessoa already exists");
		}
        pessoas.put(pessoa.getMatricula(), pessoa);
    }

    private void fillin() {
    	Endereco endereco = new Endereco("92", "Sinha Alves", "Presidente Medici");
        Pessoa pessoa = new Pessoa("Caroneiro Maior Da Silva Santos", endereco,
                "caroneiro.mss@caronae.com.br", "83999996666", "admin1", "111111111");

        pessoas.put(pessoa.getMatricula(), pessoa);
    }

}
