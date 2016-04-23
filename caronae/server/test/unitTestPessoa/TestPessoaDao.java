package unitTestPessoa;

import static org.junit.Assert.*;
import model.Endereco;
import model.pessoaModel.Pessoa;
import model.pessoaModel.PessoaDao;

import org.junit.Before;
import org.junit.Test;

import exceptions.DAOException;

public class TestPessoaDao {
	PessoaDao pessoa1;

	@Before
	public void setUp() {
		pessoa1 = new PessoaDao();
	}

	@Test
	public void testGetPessoa() {
		assertEquals(pessoa1, pessoa1.getPessoa("111111111"));

		try {
			pessoa1.getPessoa("111151111");
			fail("Exceção não lançada");
		} catch (DAOException e) {
		}
	}

	@Test
	public void testPersistirPessoa() {
		PessoaDao pessoa2 = new PessoaDao();
		String matricula = "112345111";

		try {
			pessoa2.getPessoa(matricula);
			fail();
		} catch (DAOException e) {
		}

		Endereco endereco1 = new Endereco("44", "Rua dos Facheiros", "Malvinas");
		Pessoa pessoa3 = new Pessoa("Mariana", endereco1,
				"mariana@ccc.ufcg.edu.br", "33332222", "1234", matricula);

		pessoa1.persistirPessoa(pessoa3);
		assertEquals(pessoa3, pessoa1.getPessoa(matricula));
		
		try {
			pessoa1.persistirPessoa(pessoa3);
			fail();
		} catch (DAOException e) {}
	}
	
	public void testAtualizarPessoa(){
		
	}

}
