package unitTestCarona;

import static org.junit.Assert.*;
import model.caronaModel.CaronaDAO;

import org.junit.Before;
import org.junit.Test;

import exceptions.DAOException;

/**
 * @author Rafaella
 *
 */

public class TestCaronaDao {
	CaronaDAO carona1;
	
	@Before
	public void setUp() throws Exception {
		carona1 = new CaronaDAO();
	}

	@Test
	public void testGetCarona() {
		assertEquals(carona1, carona1.getCarona(""));
		
		try {
			carona1.getCarona(null);
			fail();
		} catch (DAOException e) {}		
	}
	
	
	@Test
	public void testPersistirCarona() {
		assertFalse(carona1.existeCarona("João José Joaquim"));
	}
	
	@Test
	public void testTotalDeCaronas() {
		
	}
	
	@Test
	public void testCaronasMotorista() {
		
	}
	
	@Test
	public void testCaronasPassageiro() {
		
	}

}