package com.ifpb.view;
import com.ifpb.control.*;
import com.ifpb.model.*;
public class App {
	public static void main(String[] args) {
		GerenciarFuncionario cf = new GerenciarFuncionario();
		Funcionario f1 = new Funcionario("111.111.111.11", "Zé", "@gmail.com", "telefone", "jfjhkk", "kjghkldff", "1111-1",
				new ContaBancaria("zxc", 1, "zcxv", true), new Endereco("asddasd", "sdfsdf", "sdsdf", 1, "sdfsf"));
		
		Funcionario f2 = new Funcionario("111.111.111.11", "Zé", "@gmail.com", "telefone", "jfjhkk", "kjghkldff", "1111-1",
				new ContaBancaria("zxc", 1, "zcxv", true), new Endereco("asddasd", "sdfsdf", "sdsdf", 1, "sdfsf"));
		
		Funcionario f3 = new Funcionario("111.111.111.11", "Zé", "@gmail.com", "telefone", "jfjhkk", "kjghkldff", "1111-2",
				new ContaBancaria("zxc", 1, "zcxv", true), new Endereco("asddasd", "sdfsdf", "sdsdf", 1, "sdfsf"));
		
		Funcionario f2Editado = new Funcionario("111.111.111.11", "Zé", "@gmail.com", "telefone", "jfjhkk", "kjghkldff", "1111-4",
				new ContaBancaria("zxc", 1, "zcxv", true), new Endereco("asddasd", "sdfsdf", "sdsdf", 1, "sdfsf"));
		
		System.out.println(cf.addFuncionario(f2));
		System.out.println(cf.addFuncionario(f1));
		cf.addFuncionario(f3);
		System.out.println(cf.buscarFuncionario("1111-1"));
		System.out.println(cf.removerFuncionario("1111-2"));
		System.out.println(cf.atualizarFuncionario("1111-1", f2Editado));
		System.out.println(f2Editado);
		
		System.out.println("----------------------------------------------------\n\n\n------------------------------------------------------");
		
		GerenciarHospede gh = new GerenciarHospede();
		Hospede h1 = new Hospede("Zé das Couves", "123.123.123.23", "", "", "", "", "", "", "", "");
		Hospede h2 = new Hospede("Colvinha", "223.123.123.23", "", "", "", "", "", "", "", "");
		Hospede h3 = new Hospede("Shurastei", "323.123.123.23", "", "", "", "", "", "", "", "");
		Hospede h4 = new Hospede("Shurasgou", "723.123.123.23", "", "", "", "", "", "", "", "");
		Hospede h5 = new Hospede("Shurasgou", "723.123.123.23", "", "", "", "", "", "", "", "");//igual
		
		System.out.println(gh.addHospede(h1));
		System.out.println(gh.addHospede(h4));
		System.out.println(gh.addHospede(h5));
		System.out.println(gh.atualizaHospede("123.123.123.23", h3));
		System.out.println(gh.addHospede(h4));
		System.out.println(gh.removeHospede("098.098.098.90"));
		System.out.println(gh.addHospede(h1));
		System.out.println(gh.buscarHospede("123.123.123.23"));
		System.out.println(gh.buscarHospede("Zé das Couves"));
		
		System.out.println(gh.listarHospedes());
	}
}
