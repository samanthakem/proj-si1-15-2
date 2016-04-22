package unitTestPassageiro;


import static org.junit.Assert.*;
import model.Endereco;
import model.passageiroModel.Passageiro;
import model.pessoaModel.Pessoa;

import org.junit.Before;
import org.junit.Test;

public class TestPassageiro {
	public Passageiro passageiro1;
	Pessoa pessoa1;
	Endereco endereco1;

	@Before
	public void setUp() throws Exception {
		passageiro1 = new Passageiro(pessoa1);
		endereco1 = new Endereco("51", "Rua Dulcelina Falcone de Carvalho", "Cruzeiro");
		pessoa1 = new Pessoa ("Jorge", endereco1, "jorge@ccc.ufcg.edu.br", "33331111", "4321", "117654890");
	}

	@Test
	public void test() {
		
	}

}
