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
		if(!funcionarios.isEmpty() && funcionarios.get(f.getEmail())==f) {
			return false;
		}
		funcionarios.put(f.getEmail(), f);
		return false;
	}
	
	public Funcionario read(String email) {
		return funcionarios.get(email);
	}
	
	public boolean update(String email, Funcionario f) {
		if(read(email)!= null && delete(email)==true) {
			return create(f);
		}
		return false;
	}
	
	public boolean delete(String email) {
		if(funcionarios.isEmpty() && read(email)==null)
			return false;
		return funcionarios.remove(email, read(email));
	}
	
	public boolean isAutenticado(String email, String senha) {
		Funcionario f = funcionarios.get(email);
		if(f!=null)
			return f.getSenha().equals(senha);
		return false;
	}
	
	@Override
	public String toString() {
		return "[funcionarios=" + funcionarios + "]";
	}
}
