package model.pessoaModel;

/**
 * Created by gustavooliveira on 4/7/16.
 */
public class PessoaDao {
    private PessoaMock pessoaMock;

    public PessoaDao() {
        pessoaMock = PessoaMock.getPessoaMock();
    }

    /**
     * Retorna o objeto {@Pessoa} dado uma matricula.
     * @param matricula A matricula da pessoa
     * @return objeto {@Pessoa} caso exista, caso contrario retorna null
     */
    public Pessoa getPessoa(String matricula) {
        return pessoaMock.get(matricula);
    }

    /**
     * Verifica se existe alguma pessoa com aquele id;
     * @param matricula A matricula da pessoa
     * @return true se existe uma pessoa com o mesmo id, caso contr[ario false
     */
    public boolean existePessoa(String matricula) {
        return pessoaMock.contemPessoa(matricula);
    }

    public void addPessoa(Pessoa pessoa) {
        pessoaMock.add(pessoa);
    }
}
