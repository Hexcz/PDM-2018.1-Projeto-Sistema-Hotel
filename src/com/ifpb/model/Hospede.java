package com.ifpb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hospede {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private Endereco endereco;
	private List<CartaoCredito> cartoes;

	public Hospede(String nome, String cpf, String telefone, String email, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.cartoes = new ArrayList<>();
	}
	
	private CartaoCredito buscarCartao(CartaoCredito cartaoCredito) {
		if(!cartoes.isEmpty())
			for(int i = 0;i<cartoes.size();i++)
				if(cartoes.get(i).equals(cartaoCredito))
					return cartoes.get(i);
		return null;
	}
	
	public boolean createCartao(CartaoCredito cc) {
		if(buscarCartao(cc)!=null)
			return cartoes.add(cc);
		return false;
	}
	
	public boolean removeCartao(CartaoCredito cc) {
		if(!cartoes.isEmpty() && buscarCartao(cc)!=null)
			return cartoes.remove(cc);
		return false;
	}
	
	public List<CartaoCredito> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<CartaoCredito> cartoes) {
		this.cartoes = cartoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospede other = (Hospede) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hospede [nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", email=" + email + ", endereco="
				+ endereco + ", cartoes=" + cartoes + "]";
	}

}
