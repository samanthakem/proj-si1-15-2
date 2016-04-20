package model.caronaModel;

import model.motoristaModel.Motorista;
import model.motoristaModel.MotoristaService;
import model.passageiroModel.Passageiro;
import model.passageiroModel.PassageiroService;

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
	public Carona getCarona(String id) {
		caronaValidador.validarExistenciaCarona(id);
		Carona carona = dao.getCarona(id);
        return carona;
	}
	
	/**
     * Adiciona uma carona a coleção de caronas
	 * @param {Object} carona
	 * 		Carona que sera adicionada no sistema
     */
	@Override
	public void addCarona(Carona carona) {
        caronaValidador.validarCadastro(carona);
        dao.persistirCarona(carona);
        
        if (carona.getIdMotorista() != null) {
        	String idMotorista = carona.getIdMotorista();
        	Motorista motorista = motoristaService.getMotorista(idMotorista);
        	motoristaService.addMotoristaNaCarona(motorista, carona);
        }
        
        if (!carona.getIdsPassageiros().isEmpty()) {
        	for (String idPassageiro : carona.getIdsPassageiros()) {
				Passageiro passageiro = passageiroService.getPassageiro(idPassageiro);
        		passageiroService.addPassageiroNaCarona(passageiro, carona);
			}
        }
    }
	
	public static void setGerenciador(GerenciadorDeCaronas gerenciador) {
        GerenciadorDeCaronas.gerenciador = gerenciador;
    }
}
