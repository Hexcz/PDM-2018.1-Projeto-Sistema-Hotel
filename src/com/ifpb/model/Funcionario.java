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

    public Funcionario(String cpf, String nome, String email, String telefone, String senha, String matricula, ContaBancaria contaBancaria, Endereco endereco) {
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
		return "Funcionario [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", senha=" + senha + ", matricula=" + matricula + ", contaBancaria=" + contaBancaria
				+ ", endereco=" + endereco + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Funcionario f = (Funcionario) obj;
		if(this.matricula.equals(f.getMatricula())) {
			return true;
		}
		return false;
	}
    
    
}
