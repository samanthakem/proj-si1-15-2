package model.caronaModel;

import model.Horario;
import model.motoristaModel.Motorista;
import model.motoristaModel.MotoristaService;
import model.passageiroModel.Passageiro;
import model.passageiroModel.PassageiroService;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe responsavel por implementar os servicos da entidade {@Carona}
 * 
 * @author Samantha Monteiro
 */
public class GerenciadorDeCaronas implements CaronaService {
	
	private static GerenciadorDeCaronas gerenciador;
	
	private CaronaValidador caronaValidador = new CaronaValidador();
	
	private CaronaDAO dao = new CaronaDAO();
	
	private PassageiroService passageiroService;
	
	private MotoristaService motoristaService;
	
	private GerenciadorDeCaronas() {}
	
	 /**
     * @return A instancia de GerenciadorDeCaronas
     */
    public static GerenciadorDeCaronas getGerenciador() {
        if (gerenciador == null)
            gerenciador = new GerenciadorDeCaronas();
        return gerenciador;
    }
    
    /**
     * Recupera uma carona da coleção de caronas
     * @param {String} id
     * 		ID da carona
     * @return {Object} carona
     * 		Retorna retorna a carona
     */
    @Override
	public Carona getCarona(String id) {
		caronaValidador.validarExistenciaCarona(id);
		Carona carona = dao.getCarona(id);
        return carona;
	}

	@Override
	public Set<Carona> getCaronasDeMotorista(Motorista motorista) {
		Set<Carona> colecaoCaronas = new HashSet<Carona>();
		System.out.print(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Entrou GERENCIADOR MOTORISTA \n");
		colecaoCaronas = dao.getCaronasDeMotorista(motorista);

		return colecaoCaronas;
	}

	/**
     * Adiciona uma carona a coleção de caronas
	 * @param {Object} carona
	 * 		Carona que sera adicionada no sistema
	@Override
	*/
	public void addCarona(Carona carona) {
        caronaValidador.validarCadastro(carona);
        dao.persistirCarona(carona);
	}
	
	/**
	 * Recupera a quantidade total de caronas no sistema.
	 * @return {int} numero de caronas
	 */
	@Override
	public int getQuantidadeTotalCaronas() {
		return dao.getQuantidadeTotalCaronas();
	}
	
	@Override
	public Set<Carona> getCaronasDePassageiro(Passageiro passageiro) {
		return dao.getCaronasDePassageiro(passageiro);
	}

	@Override
	public Set<Carona> getCaronas(String bairroOrigem, String bairroDestino, Horario horario) {
		return dao.getCaronas(bairroOrigem, bairroDestino, horario);
	}

	public static void setGerenciador(GerenciadorDeCaronas gerenciador) {
        GerenciadorDeCaronas.gerenciador = gerenciador;
    }
}
