package com.ifpb.control;
import java.util.ArrayList;
import java.util.List;
import com.ifpb.model.Funcionario;

public class GerenciarFuncionario {
	List<Funcionario> funcionarios;
	public GerenciarFuncionario() {
		funcionarios = new ArrayList<>();
	}
	
	public boolean create(Funcionario f) {
		if(!funcionarios.isEmpty() && funcionarios.indexOf(f)>=0) {
			return false;
		}
		return funcionarios.add(f);
	}
	
	public Funcionario read(String matricula) {
		for(Funcionario f:funcionarios) {
			if(f.getMatricula().equals(matricula)) {
				return f;
			}
		}
		return null;
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
		return funcionarios.remove(read(matricula));
	}
	
	
	@Override
	public String toString() {
		return "CadastrarFuncionario [funcionarios=" + funcionarios + "]";
	}
}
