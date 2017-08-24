package br.com.fis.camel.res;


import java.util.ArrayList;

import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.FixedFormatOccurs;
import com.ancientprogramming.fixedformat4j.annotation.Record;
import com.ancientprogramming.fixedformat4j.format.impl.CustomCobolOccursFormat;

@Record
public class OutBean {
	
	private String cabecalho;
	private String dsRequest;
	private String chaveRestart;
	private String origem;
	private ArrayList<Cartao> cartoes;
	private String continuacaoRestart;
	private String filler;

	
	@Field(offset = 1, length=137)
	public String getCabecalho() {
		return cabecalho;
	}

	@Field(offset = 138, length=44)
	public String getDsRequest() {
		return dsRequest;
	}

	@Field(offset = 182, length=54)
	public String getChaveRestart() {
		return chaveRestart;
	}

	@Field(offset = 236, length=10)
	public String getOrigem() {
		return origem;
	}

	@Field(offset = 246, length = 3737, formatter = CustomCobolOccursFormat.class)
	@FixedFormatOccurs(occursSize = 37, occursRecord = Cartao.class)
	public ArrayList<Cartao> getCartoes(){
		return cartoes;
	}
	
	@Field(offset = 3983, length=19)
	public String getContinuacaoRestart() {
		return continuacaoRestart;
	}

	@Field(offset = 4002, length=91)
	public String getFiller() {
		return filler;
	}
	
	public void setCabecalho(String cabecalho) {
		this.cabecalho = cabecalho;
	}

	public void setDsRequest(String dsRequest) {
		this.dsRequest = dsRequest;
	}

	public void setChaveRestart(String chaveRestart) {
		this.chaveRestart = chaveRestart;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public void setCartoes(ArrayList<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	public void setContinuacaoRestart(String continuacaoRestart) {
		this.continuacaoRestart = continuacaoRestart;
	}

	public void setFiller(String filler) {
		this.filler = filler;
	}
}
