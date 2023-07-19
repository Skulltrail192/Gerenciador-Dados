package com.aas.gerenciadordados.services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aas.gerenciadordados.domains.CampoData;
import com.aas.gerenciadordados.domains.CampoDataNovo;
import com.aas.gerenciadordados.domains.SacdLog;
import com.aas.gerenciadordados.repositories.SacdLogRepository;
import com.aas.gerenciadordados.util.RequisicaoHttp;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SacdLogService {

	@Autowired
	private SacdLogRepository repo;

	public List<SacdLog> buscarRegistros() {
		return this.repo.buscarRegistros();
	}

	
	public void escreverArquivoBackup(PrintWriter gravarArq, String texto_backup) throws IOException{
		
		
		//BufferedWriter bw = new BufferedWriter(fw);
		
		//gravarArq.printf("+--Resultado--+%n");
		gravarArq.println(texto_backup);
		//gravarArq.printf("+-------------+%n");
//		bw.write(texto_backup);
		//bw.append(texto_backup);
		//bw.newLine();
		//bw.close();
		
	}
	
	public void buscarRegistrosTeste() throws Exception {
		
		FileWriter fwBackup = new FileWriter("d:\\backup-registros.txt");
		FileWriter fwLog = new FileWriter("d:\\log-registros.txt");
		PrintWriter gravarBackup = new PrintWriter(fwBackup);
		PrintWriter gravarLog = new PrintWriter(fwLog);
		
		String texto_backup = "";
		String texto_log = "";
		
		String urlCRM = "https://governodabahia.crm2.dynamics.com/api/data/v9.1/";
		//String urlCRM = "https://governodabahiahmg.crm2.dynamics.com/api/data/v9.1/";
		
		List<SacdLog> sacdLogList = new ArrayList<SacdLog>();
		sacdLogList = this.repo.buscarRegistros();

		// ObjectMapper instantiation
		RequisicaoHttp utilHttp = new RequisicaoHttp();
		String token = utilHttp.obterToken();
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		int size = sacdLogList.size();

		for (int i = 0; i < size; i++) {
			SacdLog sl = new SacdLog();
			sl = sacdLogList.get(i);
			
			CampoData campoData = objectMapper.readValue(sl.getData(), CampoData.class);

			//if (campoData.getCodPosto() != null) {
			if (campoData.getCodPosto() != null && campoData.getCodPosto() == "") {
				
				
				System.out.println( sl.getLog_id() );
				System.out.println( sl.getUuid()  );
				System.out.println( sl.getLog_type() );
				System.out.println( sl.getTag() );
				System.out.println(i + ":: " + sl.getData());
				texto_backup = "UPDATE SACD_LOG SL SET SL.DATA = '" + sl.getData() + "' WHERE LOG_ID = " + sl.getLog_id();
				gravarBackup.println(texto_backup);
				
				//texto_log = sl.getData();
				gravarLog.println("Log_id:: " + sl.getLog_id() + " ::: Data:: " + sl.getData());
				//this.escreverArquivoBackup(gravarBackup, texto_backup);
				
				
				
				
				String consultaCRM = urlCRM+"incidents?$expand=prodeb_PostodeAtendimento($select=accountid,name,createdon,prodeb_contaid)&$filter=incidentid%20eq%20%27"
						+ campoData.getCodigoOcorrencia() + "%27";
				
				// String encoding3 =
				// Base64.getEncoder().encodeToString(utilHttp.obterToken().getBytes(StandardCharsets.UTF_8));
				// utilHttp.requisicaoHttp(encoding3,consultaCRM);

				String ret = utilHttp.requisicaoHttp(token, consultaCRM).toString();
				campoData.setCodPosto(ret);
				
				CampoDataNovo cdn = new CampoDataNovo();
				cdn.setCpf(campoData.getCpf());
				cdn.setCnh(campoData.getCnh());
				cdn.setCanalAtendimento(campoData.getCanalAtendimento());
				cdn.setCodigoOcorrencia(campoData.getCodigoOcorrencia());
				cdn.setRenach(campoData.getRenach());
				cdn.setCodPosto(campoData.getCodPosto());
				cdn.setLocal(campoData.getLocal());
				cdn.setEmail(campoData.getEmail());
				cdn.setDataVencimento(campoData.getDataVencimento());
				
				String json = objectMapper.writeValueAsString(cdn);
				sl.setData(json);
				gravarLog.println("Log_id:: " + sl.getLog_id() + " ::: Data:: " + sl.getData());
				System.out.println(i + ":: " + sl.getData());
				
				//updateDataSacdLog2(sl);
				
				
				//updateDataSacdLog(Long.parseLong( sl.getLog_id() ) , sl.getData());
				//public void updateDataSacdLog( String campoData, Long id);
				
				
			}
		}
		
		gravarBackup.close();
		gravarLog.close();
	}
	
	public void updateDataSacdLog2(SacdLog sl) {
		//repo.save(sl);
	}
	
	public void updateDataSacdLog(Long id, String campoData) {
		//@Param("id") Long id, @Param("data") String campoData
		repo.updateDataSacdLog(campoData, id);
		
	}
}
