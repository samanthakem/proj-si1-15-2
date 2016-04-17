package model.caronaModel;

/**
 * Classe responsavel por implementar os servicos da entidade {@Carona}
 * 
 * @author Samantha Monteiro
 */
public class GerenciadorDeCaronas implements CaronaService {
	
	private static GerenciadorDeCaronas gerenciador;
	
	private CaronaValidador caronaValidador = new CaronaValidador();
	
	private CaronaDAO dao = new CaronaDAO();
	
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
	public void addCarona(Carona carona) {
        caronaValidador.validarCadastro(carona);
        dao.persistirCarona(carona);
    }
	
	public static void setGerenciador(GerenciadorDeCaronas gerenciador) {
        GerenciadorDeCaronas.gerenciador = gerenciador;
    }
}
