package com.aas.gerenciadordados.util;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.aas.gerenciadordados.domains.CampoData;
import com.fasterxml.jackson.databind.ObjectMapper;


public class RequisicaoHttp {
	
	public String obterToken() throws IOException{
		String s = "http://c360dessgw.datacenter.prodeb:8080/obter-token-crm";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.getForEntity(s, String.class);
		return response.getBody();
	}
	
	
	
	//public ResponseEntity<String> requisicaoHttp(String token, String consulta) throws Exception {
	public String requisicaoHttp(String token, String consulta) throws Exception {
		
		String accessToken = "Bearer "+token; 
		accessToken=accessToken.replaceAll("\n", "");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", accessToken);
		//headers.setBearerAuth(token);
		headers.setAcceptCharset(Arrays.asList(Charset.forName("UTF-8")));
		
		RestTemplate restTemplate = new RestTemplate();
		//ResponseEntity<String> response = restTemplate.getForEntity(consulta, String.class);
		ResponseEntity<String> response = restTemplate.exchange(RequestEntity.get(new URI(consulta)).headers(headers).build(), String.class);

		JSONObject json = new JSONObject(response.getBody());
		String ret = json.getJSONArray("value").getJSONObject(0).getJSONObject("prodeb_PostodeAtendimento").getString("prodeb_contaid");
		//int ret2 = json.getJSONArray("value").getJSONObject(0).getJSONObject("prodeb_PostodeAtendimento").getInt("prodeb_contaid");

		//System.out.println(ret);
		//System.out.println(ret2);
		
		
		//return ResponseEntity.ok().body(ret);
		return ret;
	}
}
