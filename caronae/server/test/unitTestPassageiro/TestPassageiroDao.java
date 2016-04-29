package unitTestPassageiro;

import static org.junit.Assert.*;
import model.Endereco;
import model.passageiroModel.Passageiro;
import model.passageiroModel.PassageiroDao;
import model.pessoaModel.Pessoa;

import org.junit.Before;
import org.junit.Test;

import exceptions.DAOException;

public class TestPassageiroDao {
	PassageiroDao passageiro1;

	@Before
	public void setUp() throws Exception {
		passageiro1 = new PassageiroDao();
	}

	@Test
	public void testGetPassageiroDao() {
		assertEquals(passageiro1, passageiro1.getPassageiro("333333333"));
		
		try {
			passageiro1.getPassageiro("111151111");
			fail("Exceção não lançada");
		} catch (DAOException e){}
	}
	
	@Test
	public void testExistePassageiroDao() {
		assertTrue(passageiro1.existePassageiro("333333333"));
		assertFalse(passageiro1.existePassageiro("333333444"));
	}
	
	@Test
	public void testPersistirPassageiro() {
		String matricula = "123456789";
		assertFalse(passageiro1.existePassageiro(matricula));
		
		Endereco endereco1 = new Endereco("92", "Sinha Alves",
				"Presidente Medici");
		Pessoa pessoa1 = new Pessoa("Caroneiro Maior Da Silva Santos",
				endereco1, "caroneiro.mss@caronae.com.br", "83999996666",
				"admin1", matricula);
		Passageiro passageiro2 = new Passageiro(pessoa1);
		
		passageiro1.persistirPassageiro(passageiro2);
		
		try {
			passageiro1.persistirPassageiro(passageiro2);
			fail();
		} catch (DAOException e) {}

		
		
	}
	
	@Test
	public void testAtualizarPassageiro() {
		
	}

}
