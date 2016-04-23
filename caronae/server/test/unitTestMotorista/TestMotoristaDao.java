package unitTestMotorista;

import static org.junit.Assert.*;
import model.Endereco;
import model.motoristaModel.Motorista;
import model.motoristaModel.MotoristaDao;
import model.pessoaModel.Pessoa;

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
		Pessoa pessoa1 = new Pessoa();
		motorista2 = new Motorista(pessoa1 , 4);
	}

	@Test
	public void testGetMotoristaDao() {
		assertEquals(motorista1, motorista1.getMotorista("111111111"));
		
		try {
			motorista1.getMotorista("111151111");
			fail("Exceção não capturada");
		} catch (DAOException e){}
	}
	
	public void testPersistirMotorista() {
		motorista1.persistirMotorista(motorista2);
		
	}
	
	public void testExistMotorista(){
		assertTrue(motorista1.existeMotorista("111111111"));
		assertFalse(motorista1.existeMotorista("111111119"));
	}
	
	public void testAtualizarMotorista() {
		
	}

}
