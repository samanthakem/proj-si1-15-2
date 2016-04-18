package model.caronaModel;

import java.util.HashMap;

import exceptions.HttpException;

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

    private void fillin() {
        Carona carona = new Carona();
        caronas.put(carona.getId(), carona);
    }

}
