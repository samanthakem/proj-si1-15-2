package unitTestMotorista;

import static org.junit.Assert.*;
import model.Endereco;
import model.motoristaModel.Motorista;
import model.motoristaModel.MotoristaDao;
import model.motoristaModel.MotoristaMock;
import model.pessoaModel.Pessoa;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rafaella
 *
 */
public class TestMotorista {
	public Motorista motorista1;
	public Motorista motorista2; //criar esse motorista com parametros
	public Pessoa pessoa1;
	public Endereco endereco1;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		endereco1 = new Endereco("44", "Rua dos Facheiros", "Malvinas");
		pessoa1 = new Pessoa("Mariana", endereco1, "mariana@ccc.ufcg.edu.br", "33332222", "1234", "111111222");
		
		motorista1 = new Motorista();
		motorista2 = new Motorista(pessoa1,4);
			
	}

	@Test
	public void testMotorista() {
		assertEquals("111111222", motorista2.getMatricula());
		
		motorista2.setMatricula("114210448"); //modificando motorista4
		
		assertEquals("114210448", motorista2.getMatricula());
		assertEquals(4, motorista2.getQuantidadeVagasCarro());
		
		motorista1.setQuantidadeVagasCarro(2); //setando novos atributos pra motorista1
		motorista1.setMatricula("111222333");
		
		assertEquals(2, motorista1.getQuantidadeVagasCarro());
		assertEquals("111222333", motorista1.getMatricula());
	}
	
	public void testPessoa() {
		assertEquals(endereco1, pessoa1.getEndereco());
		assertEquals("Mariana", pessoa1.getNome());
		
		pessoa1.setNome("Juliana");
		assertEquals("Juliana", pessoa1.getNome());
		assertEquals(motorista2.getMatricula(), pessoa1.getMatricula());
		assertEquals(pessoa1.getNome(), motorista2.getPessoa().getNome());
	}
	
	//testar equals
	
	//testar toJson
	
	//testar idCarona

}
