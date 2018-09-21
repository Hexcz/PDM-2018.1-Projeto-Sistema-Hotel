package com.ifpb.model;

public class TipoQuarto {
	private int codigo;
	private String descricao;
	private static int id;
	
	public TipoQuarto(String descricao) {
		this.codigo = ++id;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setContador(int id) {
		TipoQuarto.id = id;
	}
	@Override
	public String toString() {
		return "descricao=" + descricao;
	}
}
