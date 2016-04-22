package unitTestCarona;

import static org.junit.Assert.*;
import model.caronaModel.CaronaDAO;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rafaella
 *
 */

public class TestCaronaDao {
	CaronaDAO carona1;
	CaronaDAO carona2;
	@Before
	public void setUp() throws Exception {
		carona1 = new CaronaDAO();
		carona2 = new CaronaDAO();
	}

	@Test
	public void test() {

	}
	
	//testar persistir carona
	
	//testar getTotal de caronas (ver onde as caronas estão sendo contadas)
	
	//testar o total de caronas do motorista (List)
	
	//testar o total de caronas do passageiro (List)
}
