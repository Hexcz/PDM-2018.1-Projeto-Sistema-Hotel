package com.ifpb.control;
import java.util.ArrayList;
import java.util.List;
import com.ifpb.model.Funcionario;

public class GerenciarFuncionario {
	List<Funcionario> funcionarios;
	public GerenciarFuncionario() {
		funcionarios = new ArrayList<>();
	}
	
	public boolean addFuncionario(Funcionario f) {
		if(!funcionarios.isEmpty() && funcionarios.indexOf(f)>=0) {
			return false;
		}
		return funcionarios.add(f);
	}
	
	public Funcionario buscarFuncionario(String matricula) {
		for(Funcionario f:funcionarios) {
			if(f.getMatricula().equals(matricula)) {
				return f;
			}
		}
		return null;
	}
	
	public boolean removerFuncionario(String matricula) {
		if(funcionarios.isEmpty() && buscarFuncionario(matricula)==null)
			return false;
		return funcionarios.remove(buscarFuncionario(matricula));
	}
	
	public boolean atualizarFuncionario(String matriculaAntiga, Funcionario f) {
		if(buscarFuncionario(matriculaAntiga)!= null && removerFuncionario(matriculaAntiga)==true) {
			return addFuncionario(f);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "CadastrarFuncionario [funcionarios=" + funcionarios + "]";
	}
}
