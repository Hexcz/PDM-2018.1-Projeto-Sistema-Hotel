package com.ifpb.model;

import java.util.Objects;

public class Hospede {
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private Endereco endereco;

	public Hospede(String nome, String cpf, String telefone, String email, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Hospede)) return false;
		Hospede hospede = (Hospede) o;
		return Objects.equals(getNome(), hospede.getNome()) &&
				Objects.equals(getCpf(), hospede.getCpf()) &&
				Objects.equals(getTelefone(), hospede.getTelefone()) &&
				Objects.equals(getEmail(), hospede.getEmail()) &&
				Objects.equals(getEndereco(), hospede.getEndereco());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getNome(), getCpf(), getTelefone(), getEmail(), getEndereco());
	}

	@Override
	public String toString() {
		return "Hospede{" +
				"nome='" + nome + '\'' +
				", cpf='" + cpf + '\'' +
				", telefone='" + telefone + '\'' +
				", email='" + email + '\'' +
				", endereco=" + endereco +
				'}';
	}
}
