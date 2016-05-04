package model;

public class Endereco {
	
	private String num;
	
	private String bairro;

	private String rua;

	public Endereco(){}

	public Endereco(String num, String rua, String bairro) {
		setNum(num);
		setRua(rua);
		setBairro(bairro);
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getRua() {
		return rua;
	}

	@Override
	public String toString() {
		return "Endereco{" +
				"num='" + num + '\'' +
				", bairro='" + bairro + '\'' +
				", rua='" + rua + '\'' +
				'}';
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
