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
	
	@Override
	public String toString() {
		return "CadastrarFuncionario [funcionarios=" + funcionarios + "]";
	}
}
