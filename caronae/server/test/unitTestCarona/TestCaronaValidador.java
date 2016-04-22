package unitTestCarona;

import static org.junit.Assert.*;
import model.Endereco;
import model.Horario;
import model.caronaModel.Carona;
import model.caronaModel.CaronaValidador;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Rafaella
 *
 */

public class TestCaronaValidador {
	Carona carona1;
	CaronaValidador validador1;
	Endereco endereco1, endereco2;
	Horario horario1; //ainda nao implementado

	@Before
	public void setUp() throws Exception {
		validador1 = new CaronaValidador();
		endereco1 = new Endereco("44", "Rua dos Facheiros", "Malvinas");
		endereco2 = new Endereco("sn", "Avenida Aprígio Veloso", "Bodocongó");
		carona1 = new Carona(null, null, endereco1, endereco2, horario1);
	}

	@Test
	public void testValidador() {
		//testar validador com uma carona null
		
		validador1.validarCadastro(carona1);
		validador1.validarCamposCarona(carona1);
		validador1.validarDestino(endereco1);
		validador1.validarPontoInicial(endereco2);
		validador1.validarQntVagasDisponiveis(3);
		//validar horario
		//validar id
	}

}
