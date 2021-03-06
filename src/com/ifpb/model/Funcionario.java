package com.ifpb.model;

public class Funcionario {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private String matricula;
    private ContaBancaria contaBancaria;
    private Endereco endereco;

    public Funcionario(String cpf, String nome, String email, String senha, String telefone, String matricula, ContaBancaria contaBancaria, Endereco endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;
        this.matricula = matricula;
        this.contaBancaria = contaBancaria;
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public ContaBancaria getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(ContaBancaria contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

	@Override
	public String toString() {
		return "cpf=" + cpf + "\nnome=" + nome + "\nemail=" + email + "\ntelefone=" + telefone + "\nsenha=" + senha + "\nmatricula=" + matricula + "\ncontaBancaria=" + contaBancaria
				+ "\nendereco=" + endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	
    
    
}
