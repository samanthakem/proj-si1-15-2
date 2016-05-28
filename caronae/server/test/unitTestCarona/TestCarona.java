package unitTestCarona;


import static org.junit.Assert.*;
import model.Endereco;
import model.Horario;
import model.caronaModel.Carona;
import model.motoristaModel.Motorista;
import model.pessoaModel.Pessoa;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rafaella
 *
 */

public class TestCarona {
	Carona carona1;
	Endereco endereco1, endereco2;
	Horario horario1, horario2; 
	Pessoa pessoa1;
	Motorista motorista1;
	
	@Before
	public void setUp() throws Exception {
		endereco1 = new Endereco("44", "Rua dos Facheiros", "Malvinas");
		endereco2 = new Endereco("sn", "Avenida Aprígio Veloso", "Bodocongó");
		pessoa1 = new Pessoa("Mariana", endereco1, "mariana@ccc.ufcg.edu.br", "33332222", "1234", "111111222");
		motorista1 = new Motorista(pessoa1, 4);
		carona1 = new Carona(motorista1, endereco1, endereco2, horario1, 4);
		
	}

	@Test
	public void testCarona() {
				
		assertEquals(endereco1, carona1.getPontoInicial());
		assertEquals(endereco2, carona1.getDestino());
		assertEquals(pessoa1, motorista1.getPessoa());
		pessoa1.setMatricula("111111111");
		assertEquals(pessoa1.getMatricula(), motorista1.getMatricula());
		motorista1.setQuantidadeVagasCarro(1);
		assertEquals(1, motorista1.getQuantidadeVagasCarro());
		motorista1.setQuantidadeVagasCarro(-1);
		assertEquals(0, motorista1.getQuantidadeVagasCarro());
	}
	

}
