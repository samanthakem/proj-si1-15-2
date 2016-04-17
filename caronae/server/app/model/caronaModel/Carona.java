package model.caronaModel;

import model.Entidade;

/**
 * @author Samantha Monteiro
 */
public class Carona extends Entidade {
	
	private String id;

	public Carona() {}
	
	public Carona(String id) {
		setId(id);
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}
	
}
