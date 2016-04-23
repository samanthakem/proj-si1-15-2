package unitTestMotorista;

import static org.junit.Assert.*;
import model.Endereco;
import model.motoristaModel.Motorista;
import model.motoristaModel.MotoristaDao;
import model.pessoaModel.Pessoa;
import model.pessoaModel.PessoaMock;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import exceptions.DAOErroMensagem;
import exceptions.DAOException;
import exceptions.HttpException;

public class TestMotoristaDao {
	MotoristaDao motorista1;
	Motorista motorista2;

	@Before
	public void setUp() {
		motorista1 = new MotoristaDao();
	}

	@Test
	public void testGetMotoristaDao() {
		assertEquals(motorista1, motorista1.getMotorista("111111111"));

		try {
			motorista1.getMotorista("111151111");
			fail("Exceção não capturada");
		} catch (DAOException e) {
		}
	}
	
	@Test
	public void testExisteMotorista() {
		assertTrue(motorista1.existeMotorista("111111111"));
		assertFalse(motorista1.existeMotorista("111111119"));
	}
	
	@Test
	public void testPersistirMotorista() {
		assertFalse(motorista1.existeMotorista("123456789"));
		
		Endereco endereco1 = new Endereco("92", "Sinha Alves",
				"Presidente Medici");
		Pessoa pessoa1 = new Pessoa("Caroneiro Maior Da Silva Santos",
				endereco1, "caroneiro.mss@caronae.com.br", "83999996666",
				"admin1", "123456789");
		motorista2 = new Motorista(pessoa1, 4);
		motorista1.persistirMotorista(motorista2);
		
		assertTrue(motorista1.existeMotorista("123456789"));
		
		try {
			motorista1.persistirMotorista(motorista2);
			fail();
		} catch (DAOException e) {}

	}
	
	@Test
	public void testAtualizarMotorista() {
		//TODO
	}

}
