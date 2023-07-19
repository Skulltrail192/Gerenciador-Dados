package com.aas.gerenciadordados.resources;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aas.gerenciadordados.domains.SacdLog;
import com.aas.gerenciadordados.services.SacdLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;




@RestController
@RequestMapping(value = "/sacdlog")
public class SacdLogResource {
	
	@Autowired
	private SacdLogService serv;
	
	@RequestMapping(value="/buscarRegistros", method=RequestMethod.GET)
	public ResponseEntity<?> buscarRegistros(){
		List<SacdLog> lista = this.serv.buscarRegistros();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value="/buscarRegistrosTeste", method=RequestMethod.GET)
	public void buscarRegistrosTeste() throws Exception {
		this.serv.buscarRegistrosTeste();
	}
	
}
