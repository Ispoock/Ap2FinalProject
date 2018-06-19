package com.br.mindwestbank.util;

public class Endereco {
	protected static int geraId = 0;
	protected String id;
	private String tipe = "Residencial";
	private String tipoDeLogradouro;
	private String logadouro;
	private int numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	public Endereco(String tipe, String tipoDeLogradouro, String logadouro, int numero, String bairro, String cidade,
			String estado, String cep) {
		setTipe(tipe);
		setTipoDeLogradouro(tipoDeLogradouro);
		setLogadouro(logadouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setCep(cep);
		geraId++;
		setId();
	}
	public Endereco( String tipoDeLogradouro, String logadouro, int numero, String bairro, String cidade,
			String estado, String cep) {
		setTipoDeLogradouro(tipoDeLogradouro);
		setLogadouro(logadouro);
		setNumero(numero);
		setBairro(bairro);
		setCidade(cidade);
		setEstado(estado);
		setCep(cep);
		geraId++;
		setId();
	}
	private String gerarId() {
		return this.getClass().getSimpleName()+" : "+id;
	}
	public String getId() {
		return id;
	}
	private void setId() {
		this.id = Integer.toString(geraId);
	}
	public String getTipe() {
		return tipe;
	}
	protected void setTipe(String tipe) {
		this.tipe = tipe;
	}
	protected String getTipoDeLogradouro() {
		return tipoDeLogradouro;
	}
	protected void setTipoDeLogradouro(String tipoDeLogradouro) {
		this.tipoDeLogradouro = tipoDeLogradouro;
	}
	public String getLogadouro() {
		return logadouro;
	}
	protected void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}
	public int getNumero() {
		return numero;
	}
	protected void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	protected void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	protected void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	protected void setCep(String cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return "Endereco[Id: "+getId()+" Tipe:"+getTipe()+" Tipo Logadouro:"+getTipoDeLogradouro()+" Logadouro:"+getLogadouro()
						+" Numero: "+getNumero()+" Bairro: "+getBairro()+" Cidade: "+getCidade()+" Estado: "+getEstado()+" Cep: "+getCep()+"]";
	}
}
