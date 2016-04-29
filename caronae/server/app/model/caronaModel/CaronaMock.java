package model.caronaModel;

import java.util.*;

import model.Horario;

import model.Horario;
import model.motoristaModel.Motorista;
import model.Endereco;
import model.motoristaModel.MotoristaDao;
import model.passageiroModel.Passageiro;
import model.pessoaModel.Pessoa;

/**
 * @author Samantha Monteiro, Gustavo Oliveira
 */
public class CaronaMock {
	private static CaronaMock mock;

	private HashMap<String, Carona> caronas = new HashMap<>();

	public CaronaMock() {
		fillin();
	}

	public static CaronaMock getCaronaMock() {
		if (mock == null)
			mock = new CaronaMock();
		return mock;
	}

	public Carona get(String id) {
		if (!contemCarona(id)) {
			throw new HttpException(404, "Carona does not exist");
		}
		return caronas.get(id);
	}

	public boolean contemCarona(String id) {
		return caronas.containsKey(id);
	}

	public void add(Carona carona) throws HttpException {
		if (this.contemCarona(carona.getId())) {
			throw new HttpException(409, "Carona already exists");
		}
		caronas.put(carona.getId(), carona);
	}

	public int getQuantidadeTotalCaronas() {
		return caronas.size();
	}

	private void fillin() {
		Pessoa pessoa =  new Pessoa("Caroneiro Maior Da Silva Santos", new Endereco("92", "Sinha Alves", "Presidente Medici"),
				"caroneiro.mss@caronae.com.br", "83999996666", "admin1", "111111111");
		Motorista motorista = new Motorista(pessoa, 4);
		Endereco destino = new Endereco("0","UFCG","Bodocongo");
		Horario horario = new Horario(Horario.Dia.SEGUNDA, "7:00");
		Carona carona = new Carona("100", motorista, motorista.getPessoa().getEndereco(), destino, horario);
		caronas.put(carona.getId(), carona);
	}

	public Set<Carona> getCaronasDeMotorista(Motorista motorista) {
		 Set<Carona> caronas = new HashSet<Carona>();
		Carona caronaTemp;
		for (String id : this.caronas.keySet()) {
			caronaTemp = this.caronas.get(id);
			 Motorista motoristaTemp = caronaTemp.getMotorista();
			 if (motoristaTemp.getMatricula().equals(motorista.getMatricula())) {
				caronas.add(caronaTemp);
			}
		}

		 return caronas;
	}

	public Set<Carona> getCaronasDePassageiro(Passageiro passageiro) {
		 Set<Carona> caronas = new HashSet<>();
		Carona caronaTemp;
		for (String id : this.caronas.keySet()) {
			caronaTemp = this.caronas.get(id);
			 List<Passageiro> passageirosTemp = caronaTemp.getPassageiros();
			 for(Passageiro passAux: passageirosTemp){
				 if (passAux.getMatricula().contains(passageiro.getMatricula())) {
					 caronas.add(caronaTemp);
				 }
			 }
		}

		 return caronas;
	}

}
