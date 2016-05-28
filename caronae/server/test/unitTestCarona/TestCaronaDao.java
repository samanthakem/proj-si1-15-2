package unitTestCarona;

import static org.junit.Assert.*;
import model.Endereco;
import model.Horario;
import model.caronaModel.Carona;
import model.caronaModel.CaronaDAO;
import model.motoristaModel.Motorista;
import model.pessoaModel.Pessoa;

import org.junit.Before;
import org.junit.Test;

import exceptions.DAOException;

/**
 * @author Rafaella
 *
 */

public class TestCaronaDao {
	CaronaDAO carona1;
	Carona carona2;
	
	@Before
	public void setUp() throws Exception {
		carona1 = new CaronaDAO();
	}

	@Test
	public void testGetCaronaDAO() {
		assertEquals(carona1, carona1.getCarona(""));
		
		try {
			carona1.getCarona(null);
			fail();
		} catch (DAOException e) {}		
	}
	
	@Test
	public void testExisteCarona(){
		assertFalse(carona1.existeCarona("João José Joaquim"));
		assertTrue(carona1.existeCarona("Caroneiro Maior da Silva Santos"));
	}
	
	@Test
	public void testPersistirCarona() {
		assertFalse(carona1.existeCarona("Maria da Silva"));
		
		Endereco endereco1 = new Endereco("92", "Sinha Alves",
				"Presidente Medici");
		Endereco endereco2 = new Endereco("sn", "Aprigio Veloso", "Bodocongó");
		Pessoa pessoa1 = new Pessoa("Maria da Silva",
				endereco1, "maria.ds@caronae.com.br", "83999996666",
				"admin1", "123456789");
		Motorista motorista1 = new Motorista(pessoa1, 4);
		Horario horario1 = new Horario();
		carona2 = new Carona(motorista1, endereco1, endereco2, horario1, 4);
		carona1.persistirCarona(carona2);
		
		assertTrue(carona1.existeCarona("Maria da Silva"));
		
		try {
			carona1.persistirCarona(carona2);
			fail();
		} catch (DAOException e) {}
	}
}