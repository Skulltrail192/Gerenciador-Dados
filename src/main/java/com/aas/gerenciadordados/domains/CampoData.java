package com.aas.gerenciadordados.domains;

public class CampoData {
	private String cpf;	
	private String cnh;
	private String canalAtendimento;
	private String codigoOcorrencia;
	private String renach;
	private String codPosto;
	private String local;
	private String email;
	private String dataVencimento;
	private String mensagem;
	private String status;
	
	
	
	public CampoData() {
		super();
	}
	
	public CampoData(String cpf, String cnh, String canalAtendimento, String codigoOcorrencia, String renach,
			String codPosto, String local, String email, String dataVencimento, String mensagem, String status) {
		super();
		this.cpf = cpf;
		this.cnh = cnh;
		this.canalAtendimento = canalAtendimento;
		this.codigoOcorrencia = codigoOcorrencia;
		this.renach = renach;
		this.codPosto = codPosto;
		this.local = local;
		this.email = email;
		this.dataVencimento = dataVencimento;
		this.mensagem = mensagem;
		this.status = status;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCanalAtendimento() {
		return canalAtendimento;
	}

	public void setCanalAtendimento(String canalAtendimento) {
		this.canalAtendimento = canalAtendimento;
	}

	public String getCodigoOcorrencia() {
		return codigoOcorrencia;
	}

	public void setCodigoOcorrencia(String codigoOcorrencia) {
		this.codigoOcorrencia = codigoOcorrencia;
	}

	public String getRenach() {
		return renach;
	}

	public void setRenach(String renach) {
		this.renach = renach;
	}

	public String getCodPosto() {
		return codPosto;
	}

	public void setCodPosto(String codPosto) {
		this.codPosto = codPosto;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
