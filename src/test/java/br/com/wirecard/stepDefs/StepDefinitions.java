package br.com.wirecard.stepDefs;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.hamcrest.Matchers;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;

import br.com.wirecard.dto.PessoaDto;
import br.com.wirecard.dto.TelefoneDto;
import br.com.wirecard.helpers.FileHelper;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class StepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String pessoa = "";
	private JsonPath path = null;

	public StepDefinitions() {
		baseURI = "https://sandbox.moip.com.br/v2/customers/";
	}

	@Dado("^que eu fiz a leitura do meu arquivo json com o nome \"([^\"]*)\"$")
	public void que_eu_fiz_a_leitura_do_meu_arquivo_json_com_o_nome(String nomeArquivo) throws Throwable {
		pessoa = new FileHelper().lerArquivo(nomeArquivo);
	}

	@Quando("^faco a requisicao para criar o usuario$")
	public void faco_a_requisicao_para_criar_o_usuario() throws Throwable {
		response = given().contentType("application/json;charset=UTF-8").header("Authorization", "Basic Wk5FNU9IQ1lIVFNZRUNCREhHRkRSVUkxRVY2TE4zWkQ6UVlDWERHQk9RT0tCVEoxWVdRQjNRQTc5QldPR1lVRlVGS05MUkRLVg==").body(pessoa).when().post("/");
	}

	@Entao("^o codigo de retorno deve ser (\\d+)$")
	public void o_codigo_de_retorno_deve_ser(int codigo) throws Throwable {
		response.then().statusCode(codigo);
	}

	@E("^verifico o body da reposta de criacao de usuario$")
	public void verifico_o_body_da_reposta_de_criacao() throws Throwable {
		path = response.andReturn().jsonPath();
		Gson gson = new Gson();
		
		PessoaDto pessoaDto = gson.fromJson(pessoa, PessoaDto.class);
 
		HashMap<String, String> phones =path.get("phone");
		HashMap<String, String> address =path.get("shippingAddress");
		HashMap<String, String> documents =path.get("taxDocument");
		String cpf = documents.get("number");
		
		assertEquals(pessoaDto.getOwnId(),path.getString("ownId"));
		assertEquals(pessoaDto.getEmail(),path.getString("email"));
		assertEquals(pessoaDto.getName(), path.getString("fullname"));
		assertEquals(pessoaDto.getBirthDate(), path.getString("birthDate"));
		assertEquals(pessoaDto.getAddress().entrySet(), address.entrySet());
		assertEquals(pessoaDto.getPhones().entrySet(), phones.entrySet());
		assertEquals(cpf, documents.get("number"));
		
		
	}
	
	
}
