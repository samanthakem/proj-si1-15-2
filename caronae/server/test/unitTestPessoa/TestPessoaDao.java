package unitTestPessoa;

import static org.junit.Assert.*;
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
	public void test() {
		assertEquals(pessoa1, pessoa1.getPessoa("111111111"));
		
		try {
			pessoa1.getPessoa("111151111");
			fail("Exceção não lançada");
		} catch (DAOException e){}
	}

}
