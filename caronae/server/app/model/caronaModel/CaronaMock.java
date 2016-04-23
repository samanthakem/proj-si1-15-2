package model.caronaModel;

import exceptions.HttpException;
import model.Endereco;
import model.Horario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Samantha Monteiro
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
		Carona carona = new Carona();
		caronas.put(carona.getId(), carona);
	}

	public List<Carona> getCaronasDeMotorista(String matricula, Integer limite) {
		List<Carona> caronas = new ArrayList<>();
		Carona caronaTemp;
		for (String id : this.caronas.keySet()) {
			caronaTemp = this.caronas.get(id);
			if (caronaTemp.getIdMotorista().equals(matricula)) {
				caronas.add(caronaTemp);
			}
		}
		if (limite > caronas.size()) {
			limite = caronas.size();
		}
		return caronas.subList(0, limite);
	}

	public List<Carona> getCaronas(Endereco origem, Endereco destino,
			Horario horario, Integer limite) {
		List<Carona> caronas = new ArrayList<>();

		for (Carona carona : this.caronas.values()) {
			if (carona.getPontoInicial().equals(origem)
					&& carona.getDestino().equals(destino)
					&& carona.getHorario().equals(horario)) {
				caronas.add(carona);
			}
		}

		if (limite > caronas.size()) {
			limite = caronas.size();
		}

		return caronas.subList(0, limite);
	}

	public List<Carona> getCaronasDePassageiro(String matricula, Integer limite) {
		List<Carona> caronas = new ArrayList<>();
		Carona caronaTemp;
		for (String id : this.caronas.keySet()) {
			caronaTemp = this.caronas.get(id);
			if (caronaTemp.getIdsPassageiros().contains(matricula)) {
				caronas.add(caronaTemp);
			}
		}
		if (limite > caronas.size()) {
			limite = caronas.size();
		}
		return caronas.subList(0, limite);
	}

}
