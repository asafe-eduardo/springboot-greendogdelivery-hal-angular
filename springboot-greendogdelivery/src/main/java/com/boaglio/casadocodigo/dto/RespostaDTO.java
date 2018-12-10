package com.boaglio.casadocodigo.dto;

public class RespostaDTO {
	
	private Double valorTotal;
	private Long pedido;
	private String mensagem;
	
	public RespostaDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public RespostaDTO(Double valorTotal, Long pedido, String mensagem) {
		super();
		this.valorTotal = valorTotal;
		this.pedido = pedido;
		this.mensagem = mensagem;
	}

	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Long getPedido() {
		return pedido;
	}
	public void setPedido(Long pedido) {
		this.pedido = pedido;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	

}
