package br.com.wirecard.dto;

public class TelefoneDto {

	public String area;

	public String code;

	public String number;
	
	
	public void setArea(String codigo) {
		this.area = codigo;
	}

	public String getArea() {
		return area;
	}
	
	
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
	
	
	public void setNumeroTelefone(String number) {
		this.number = number;
	}

	public String getNumeroTelefone() {
		return number;
	}
}