package unitTestPessoa;


import static org.junit.Assert.*;
import model.Endereco;
import model.pessoaModel.Pessoa;

import org.junit.Before;
import org.junit.Test;

public class TestPessoa {
	Pessoa pessoa1;
	Pessoa pessoa2;
	Endereco endereco1;

	@Before
	public void setUp() throws Exception {
		endereco1 = new Endereco("44", "Rua dos Facheiros", "Malvinas");
		pessoa1 = new Pessoa();
		pessoa2 = new Pessoa("Mariana", endereco1, "mariana@ccc.ufcg.edu.br", "33332222", "1234", "111111222");
	}

	@Test
	public void test() {
		assertEquals("Mariana", pessoa2.getNome());
		pessoa1.setNome("Jessica");
		assertEquals("Jessica", pessoa1.getNome());
		
		assertEquals(endereco1, pessoa2.getEndereco());
		Endereco endereco2 = new Endereco("51", "Rua Pres Costa e Silva", "Cruzeiro");
		pessoa1.setEndereco(endereco2);
		assertEquals(endereco2, pessoa1.getEndereco());
		
		pessoa1.setEmail("jessica@ccc.ufcg.edu.br");
		assertEquals("mariana@ccc.ufcg.edu.br", pessoa2.getEmail());
		assertEquals("jessica@ccc.ufcg.edu.br", pessoa1.getEmail());
		
		assertNull(pessoa1.getTelefone());
		pessoa1.setTelefone("33222233");
		assertEquals("33222233", pessoa1.getTelefone());
		assertEquals("33332222", pessoa2.getTelefone());
		
		String senha = "ju1234";
		pessoa1.setSenha(senha);
		assertEquals(senha, pessoa1.getSenha());
		assertEquals("4321", pessoa2.getSenha());
		
		pessoa1.setMatricula("116543123");
		assertEquals("116543123", pessoa1.getMatricula());
		assertEquals("111111222", pessoa2.getMatricula());	
	}

}
