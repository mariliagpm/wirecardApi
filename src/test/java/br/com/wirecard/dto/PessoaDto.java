package br.com.wirecard.dto;

import java.util.HashMap;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import groovy.lang.DelegatesTo.Target;

public class PessoaDto {
	@SerializedName("ownId") String ownId;

	//private String ownId;

	private String fullname;

	private String email;

	private String birthDate;

	private HashMap<String, String> shippingAddress;

	private HashMap<String, String> phone;
	
	private HashMap<String, String> taxDocument;

	
	public void setOwnId(String ownId) {
		this.ownId = ownId;
	}

	public String getOwnId(){
		return ownId;
	}
	
	
	public void setNome(String fullName) {
		this.fullname = fullName;
	}

	public String getName() {
		return fullname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	

	public void setBirthDate(String bday) {
		this.birthDate = bday;
	}

	public String getBirthDate() {
		return birthDate;
	}
	
	public void setAddress(HashMap<String, String> shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public HashMap<String, String> getAddress() {
		return shippingAddress;
	}

	
	public void setPhones(HashMap<String, String> phone) {
		this.phone = phone;
	}

	public HashMap<String, String> getPhones() {
		return phone;
	}
	
	
	public void setDocuments(HashMap<String, String> documents) {
		this.taxDocument = documents;
	}

	public HashMap<String, String> getDocuments() {
		return taxDocument;
	}
	
	
	
	
	

}