package unitTestCarona;


import static org.junit.Assert.*;
import model.Endereco;
import model.Horario;
import model.caronaModel.Carona;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rafaella
 *
 */

public class TestCarona {
	Carona carona1, carona2;
	Endereco endereco1, endereco2;
	Horario horario1, horario2; //horário ainda está vazio
	//criar e setar ids de carona e motorista
	
	@Before
	public void setUp() throws Exception {
		endereco1 = new Endereco("44", "Rua dos Facheiros", "Malvinas");
		endereco2 = new Endereco("sn", "Avenida Aprígio Veloso", "Bodocongó");
		carona1 = new Carona();
		carona2 = new Carona(null, null, endereco1, endereco2, horario1);
		
	}

	@Test
	public void testCarona() {
		carona1.setPontoInicial(endereco2);
		carona1.setDestino(endereco2);
		carona1.setHorario(horario2);
		
		assertEquals(endereco1, carona2.getPontoInicial());
		assertEquals(endereco2, carona2.getDestino());
		assertEquals(endereco2, carona1.getPontoInicial());
		assertEquals(endereco1, carona1.getPontoInicial());
	}
	
	//testar get e set id de passageiros (List)
	
	//testar get e set id de motoristas
	
	//testar get e set id (de quem??)
	
	//testar get e set Horario
	
	//testar get qtdade de vagas no carro
	
	//testar toJson (?)

}
