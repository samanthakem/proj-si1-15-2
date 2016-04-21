package unitTest;

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
	public MotoristaDao motorista2;
	public MotoristaMock motorista3;
	public Motorista motorista4; //criar esse motorista com parametros
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
		motorista2 = new MotoristaDao();
		motorista3 = new MotoristaMock();
		motorista4 = new Motorista(pessoa1,4);
			
	}

	@Test
	public void test() {
		
	}

}
