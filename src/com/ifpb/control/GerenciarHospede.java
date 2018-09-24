package com.ifpb.control;
import java.util.List;

import com.ifpb.exceptions.ListaHospedeVaziaException;
import com.ifpb.model.Hospede;
import java.util.ArrayList;

public class GerenciarHospede {
	private static List<Hospede> hospedes = new ArrayList<>();
	
	public static boolean create(Hospede hospede) {
		if(!hospedes.isEmpty() && hospedes.indexOf(hospede)>=0) {
			return false;
		}
		return hospedes.add(hospede);
	}
	
	public static List<Hospede> read(String cpfOuNome) {
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
	
	public static Hospede readHospede(String cpf) throws ListaHospedeVaziaException{
		if(hospedes.size()==0) {
			throw new ListaHospedeVaziaException();
		}
		else {
			if(!hospedes.isEmpty()) {
				for(Hospede h:hospedes) {
					if(cpf.equals(h.getCpf())) {
						return h;
					}
				}
			}
			return null;
		}
	}

	public static boolean update(Hospede h) throws ListaHospedeVaziaException{
		if(delete(h.getCpf())) {
			return create(h);
		}
		return false;
	}

	public static boolean delete(String cpf) throws ListaHospedeVaziaException{
		return hospedes.remove(readHospede(cpf));
	}

	
	public static List<Hospede> listarHospedes(){
		return hospedes;
	}
	
	@Override
	public String toString() {
		return "GerenciarHospede [hospedes=" + hospedes + "]";
	}
}
