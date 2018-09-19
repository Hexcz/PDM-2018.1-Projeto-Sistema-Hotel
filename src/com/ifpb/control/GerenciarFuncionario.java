package com.ifpb.control;
import java.util.HashMap;
import java.util.Map;

import com.ifpb.model.Funcionario;

public class GerenciarFuncionario {
	private Map<String, Funcionario> funcionarios;
	
	public GerenciarFuncionario() {
		funcionarios = new HashMap<>();
	}
	
	public boolean create(Funcionario f) {
		if(!funcionarios.isEmpty() && funcionarios.get(f.getCpf())==f) {
			return false;
		}
		funcionarios.put(f.getCpf(), f);
		return false;
	}
	
	public Funcionario read(String matricula) {
		return funcionarios.get(matricula);
	}
	
	public boolean update(String matriculaAntiga, Funcionario f) {
		if(read(matriculaAntiga)!= null && delete(matriculaAntiga)==true) {
			return create(f);
		}
		return false;
	}
	
	public boolean delete(String matricula) {
		if(funcionarios.isEmpty() && read(matricula)==null)
			return false;
		return funcionarios.remove(matricula, read(matricula));
	}
	
	public boolean isAutenticado(String email, String senha) {
		Funcionario f = funcionarios.get(email);
		if(f!=null)
			return f.getSenha().equals(senha);
		return false;
	}
	public boolean test() {
		return true;
	}
	
	@Override
	public String toString() {
		return "CadastrarFuncionario [funcionarios=" + funcionarios + "]";
	}
}
