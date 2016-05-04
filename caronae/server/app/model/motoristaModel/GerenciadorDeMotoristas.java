package model.motoristaModel;

import model.caronaModel.Carona;

/**
 * Created by stenio, aline.
 */
public class GerenciadorDeMotoristas implements MotoristaService {
    
    private static GerenciadorDeMotoristas gerenciador;

    private MotoristaDao motoristaDao = new MotoristaDao();

    private MotoristaValidador motoristaValidador = new MotoristaValidador();
    
    /**
     * Construtor padrão da classe
     */
    private GerenciadorDeMotoristas() {
    }

    /**
     * @return gerenciador A instância de GerenciadorDeMotoristas
     */
    public static GerenciadorDeMotoristas getGerenciador() {
        if (gerenciador == null)
            gerenciador = new GerenciadorDeMotoristas();

        return gerenciador;
    }
    
    /**
     * Recupera um motorista da coleção de motoristas
     * @param {String} matricula
     *          A matricula do motorista
     * @return {Object} motorista
     *          Retorna null se não existir algum motorista com a mesma matricula que a especificada, caso contrário retorna o motorista
     */
    @Override
    public Motorista getMotorista(String matricula) {
        motoristaValidador.validarExistenciaMotorista(matricula);
        Motorista motorista = motoristaDao.getMotorista(matricula);
        return motorista;
    }

    /**
     * Adiciona um motorista a coleção de motoristas
     * @param {Object} motorista
     *          o motorista a ser adicionado
     */
    public void addMotorista(Motorista motorista) {
       motoristaValidador.validarCadastro(motorista);
       motoristaDao.persistirMotorista(motorista);
    }

    /**
     * Verifica se existe algum motorista cadastrado com aquela matricula;
     * @param matricula A matricula do motorista
     * @return true se existe um motorista com a mesma matricula, caso contrário false
     */
    public boolean existeMotorista(String matricula) {
        return motoristaDao.existeMotorista(matricula);
    }
    
    /**
     * Modifica qual carona o motorista faz parte
     * @param motorista o motorista
     * @param carona a carona do motorista
     */
	@Override
	public void addMotoristaNaCarona(Motorista motorista, Carona carona) {
        //TODO Não foi feita ainda a lsita de caronas no motorista
		//motorista.setIdCarona(carona.getId());
        motoristaDao.atualizarMotorista(motorista);
	}
	
	/**
	 * Modifica o gerenciador de motoristas
	 * @param gerenciador
	 */
    public static void setGerenciador(GerenciadorDeMotoristas gerenciador) {
        GerenciadorDeMotoristas.gerenciador = gerenciador;
    }
}
