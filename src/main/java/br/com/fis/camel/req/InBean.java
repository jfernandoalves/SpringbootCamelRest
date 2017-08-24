package br.com.fis.camel.req;

import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;

@Record
public class InBean {
	
	private String orgId;
	private String nrCpf;
	private String nmCliente;
	private String nrCartaoTitular;
	private String nmOrigem;
	private String chaveRestart;
	private String filler;
	
	
	@Field(offset= 1, length = 3)
	public String getOrgId() {
		return orgId;
	}

	@Field(offset = 4, length = 11)
	public String getNrCpf() {
		return nrCpf;
	}
	
	@Field( offset = 15, length = 30)
	public String getNmCliente() {
		return nmCliente;
	}
	
	@Field( offset = 45, length = 19)
	public String getNrCartaoTitular() {
		return nrCartaoTitular;
	}
	
	@Field( offset = 64, length = 10)
	public String getNmOrigem() {
		return nmOrigem;
	}
	
	@Field( offset = 74, length = 73)
	public String getChaveRestart() {
		return chaveRestart;
	}
	
	@Field( offset = 137, length = 3967)
	public String getFiller() {
		return filler;
	}
	
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}
	public void setNrCartaoTitular(String nrCartaoTitular) {
		this.nrCartaoTitular = nrCartaoTitular;
	}
	public void setNmOrigem(String nmOrigem) {
		this.nmOrigem = nmOrigem;
	}
	public void setChaveRestart(String chaveRestart) {
		this.chaveRestart = chaveRestart;
	}
	public void setFiller(String filler) {
		this.filler = filler;
	}


}
