package com.ifpb.control;
import java.util.List;
import com.ifpb.model.Hospede;
import java.util.ArrayList;

public class GerenciarHospede {
	private List<Hospede> hospedes;
	
	public GerenciarHospede() {
		hospedes = new ArrayList<>();
	}
	
	public boolean create(Hospede hospede) {
		if(!hospedes.isEmpty() && hospedes.indexOf(hospede)>=0) {
			return false;
		}
		return hospedes.add(hospede);
	}
	
	public List<Hospede> read(String cpfOuNome) {
		List<Hospede> hospede = new ArrayList<>();
		if(Character.isDigit(cpfOuNome.charAt(0)) && !hospedes.isEmpty()) {
			for(Hospede h:hospedes) {
				if(cpfOuNome.equals(h.getCpf())) {
					hospede.add(h);
					return hospede;
				}
			}
		}
		else if(!hospedes.isEmpty()){
			for(Hospede h:hospedes) {
				if(cpfOuNome.equals(h.getNome())) {
					hospede.add(h);
				}
			}
			if(!hospede.isEmpty())
			return hospede;
		}
		return null;
	}
	
	private Hospede readHospede(String cpf) {
		if(!hospedes.isEmpty()) {
			for(Hospede h:hospedes) {
				if(cpf.equals(h.getCpf())) {
					return h;
				}
			}
		}
		return null;
	}

	public boolean update(String cpf, Hospede h) {
		if(delete(cpf)) {
			return create(h);
		}
		return false;
	}

	public boolean delete(String cpf) {
		return hospedes.remove(readHospede(cpf));
	}

	
	public List<Hospede> listarHospedes(){
		return hospedes;
	}
	
	@Override
	public String toString() {
		return "GerenciarHospede [hospedes=" + hospedes + "]";
	}
}
