package com.ifpb.control;
import java.util.ArrayList;
import java.util.List;
import com.ifpb.model.Funcionario;

public class GerenciarFuncionario {
	List<Funcionario> funcionarios;
	public GerenciarFuncionario() {
		funcionarios = new ArrayList<>();
	}
	
	public boolean createFuncionario(Funcionario f) {
		if(!funcionarios.isEmpty() && funcionarios.indexOf(f)>=0) {
			return false;
		}
		return funcionarios.add(f);
	}
	
	public Funcionario readFuncionario(String matricula) {
		for(Funcionario f:funcionarios) {
			if(f.getMatricula().equals(matricula)) {
				return f;
			}
		}
		return null;
	}
	
	public boolean upadateFuncionario(String matriculaAntiga, Funcionario f) {
		if(readFuncionario(matriculaAntiga)!= null && removeFuncionario(matriculaAntiga)==true) {
			return createFuncionario(f);
		}
		return false;
	}
	
	public boolean removeFuncionario(String matricula) {
		if(funcionarios.isEmpty() && readFuncionario(matricula)==null)
			return false;
		return funcionarios.remove(readFuncionario(matricula));
	}
	
	
	@Override
	public String toString() {
		return "CadastrarFuncionario [funcionarios=" + funcionarios + "]";
	}
}
