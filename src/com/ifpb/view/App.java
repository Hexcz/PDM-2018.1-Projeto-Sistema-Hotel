package com.ifpb.view;
import java.util.Scanner;

import com.ifpb.control.*;
import com.ifpb.model.*;

public class App {
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		GerenciaQuarto gq = new GerenciaQuarto();
		GerenciarFuncionario gf = new GerenciarFuncionario();
		GerenciarHospede gh = new GerenciarHospede();
		
		int i;
		String usuario = null, senha = null;
		boolean interruptor = true;
		
		while(interruptor) {
			System.out.println("----------------TELA INICIAL--------------");
			
			System.out.print("1-Autenticar        2-Criar nova conta     0-Sair\n>>>>>");
			i = ler.nextInt();
			
			if(i == 1) {
				System.out.print("Usuário(email):");
				usuario = ler.next();
				System.out.print("Senha:");
				senha = ler.next();
			}
			
			
			
//---------------------------------------------------------------------------------------------------------------------------------------------------	
			if(i == 1 && gf.isAutenticado(usuario, senha)) {
				while(interruptor) {
					System.out.print("1-Opções Funcioanrio     2-Mesas     3-Minha Conta"
							+ "\n4-Cozinha     5-Gerência     0-Sair\n>>>>");
					i = ler.nextInt();
//------------------------------------------------------------------------------------------------					
					if(i == 1) {
						
					}
//------------------------------------------------------------------------------------------------					
					else if(i==2) {
						
					}
//------------------------------------------------------------------------------------------------
					else if(i == 3) {
						
					}
//------------------------------------------------------------------------------------------------
					else if(i == 4) {
						
					}
					else if(i == 5){
						
					}
					else {
						interruptor=false;
					}
				}
			}
//----------------------------------------------------------------------------------------------------------------------------------------------------	
			else if(i == 2) {
				gf.create(construirFuncionario(ler));
			}else {System.out.println("Fim do programa"); break;}
//---------------------------------------------------------------------------------------------------------------------------------------------------			
			interruptor = true;
		}
		
	}
	static Funcionario construirFuncionario(Scanner ler) {
		System.out.print("Informe o CPF:");
		String cpf = ler.next();
		System.out.print("Informe o nome:");
		ler.nextLine();
		String nome = ler.nextLine();
		System.out.print("Informe o E-mail:");
		String email = ler.next();
		System.out.print("Informe a senha:");
		String senha = ler.next();
		System.out.print("Informe o telefone:");
		ler.nextLine();
		String telefone = ler.nextLine();
		System.out.print("Informe a matricula:");
		String matricula = ler.next();
		ler.nextLine();
		return new Funcionario(cpf, nome, email, senha, telefone, matricula, constroiConta(ler), constroiEndereco(ler));
	}
	static ContaBancaria constroiConta(Scanner ler) {
		 System.out.print("Informe o Titular:");
		 
		 String titular = ler.nextLine();
		 
		 System.out.print("Informe a agência:");
		 int agencia = ler.nextInt();
		 
		 System.out.print("Informe o número da conta:");
		 String numeroConta = ler.next();
		 
		 int n;
		 do {
			 System.out.print("Conta corrente?\n1-sim     0-não\n>>>>");
			 n = ler.nextInt(); 
		 }while(n < 0 || n > 1);
		 boolean contaCorrente = (n == 1) ? true : false;
		 ler.nextLine();
		 return new ContaBancaria(titular, agencia, numeroConta, contaCorrente);
	 }
	 
	 static Endereco constroiEndereco(Scanner ler) {
		 System.out.print("Informe a cidade:");
		 String cidade = ler.nextLine();
		 System.out.print("Informe o bairro:");
		 String bairro = ler.nextLine();
		 System.out.print("Informe a rua:");
		 String rua = ler.nextLine();
		 System.out.print("Informe o numero:");
		 int numero = ler.nextInt();
		 System.out.print("Informe o CEP:");
		 ler.nextLine();
		 String cep = ler.nextLine();
		 return new Endereco(cidade, bairro, rua, numero, cep);
	 }
}

