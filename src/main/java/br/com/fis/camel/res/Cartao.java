package br.com.fis.camel.res;

import com.ancientprogramming.fixedformat4j.annotation.Field;
import com.ancientprogramming.fixedformat4j.annotation.Record;


@Record
public class Cartao {

	private String nrCartao;
	private String stCartao;
	private String nmPortadorCartao;
	private String blkCode;
	private String flgTitularidade;
	private String dtExpedicao;
	private String logoCartao;
	private String nrContaCartao;
	private String nrCpfCliente;
	private String flgCartaoVirtual;
	private String requestNumber;

	@Field(offset = 1, length=19)
	public String getNrCartao() {
		return nrCartao;
	}

	@Field(offset = 20, length=1)
	public String getStCartao() {
		return stCartao;
	}

	@Field(offset = 21, length=26)
	public String getNmPortadorCartao() {
		return nmPortadorCartao;
	}

	@Field(offset = 47, length=1)
	public String getBlkCode() {
		return blkCode;
	}

	@Field(offset = 48, length=1)
	public String getFlgTitularidade() {
		return flgTitularidade;
	}

	@Field(offset = 49, length=4)
	public String getDtExpedicao() {
		return dtExpedicao;
	}

	@Field(offset = 53, length=3)
	public String getLogoCartao() {
		return logoCartao;
	}

	@Field(offset = 56, length=19)
	public String getNrContaCartao() {
		return nrContaCartao;
	}

	@Field(offset = 75, length=11)
	public String getNrCpfCliente() {
		return nrCpfCliente;
	}

	@Field(offset = 76, length=1)
	public String getFlgCartaoVirtual() {
		return flgCartaoVirtual;
	}

	@Field(offset = 77, length=15)
	public String getRequestNumber() {
		return requestNumber;
	}

	public void setNrCartao(String nrCartao) {
		this.nrCartao = nrCartao;
	}

	public void setStCartao(String stCartao) {
		this.stCartao = stCartao;
	}

	public void setNmPortadorCartao(String nmPortadorCartao) {
		this.nmPortadorCartao = nmPortadorCartao;
	}

	public void setBlkCode(String blkCode) {
		this.blkCode = blkCode;
	}

	public void setFlgTitularidade(String flgTitularidade) {
		this.flgTitularidade = flgTitularidade;
	}

	public void setDtExpedicao(String dtExpedicao) {
		this.dtExpedicao = dtExpedicao;
	}

	public void setLogoCartao(String logoCartao) {
		this.logoCartao = logoCartao;
	}

	public void setNrContaCartao(String nrContaCartao) {
		this.nrContaCartao = nrContaCartao;
	}

	public void setNrCpfCliente(String nrCpfCliente) {
		this.nrCpfCliente = nrCpfCliente;
	}

	public void setFlgCartaoVirtual(String flgCartaoVirtual) {
		this.flgCartaoVirtual = flgCartaoVirtual;
	}

	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}
}
