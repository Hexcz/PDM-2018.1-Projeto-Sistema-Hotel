package com.ifpb.view;
import java.time.LocalDate;
import java.util.Scanner;

import com.ifpb.control.*;
import com.ifpb.exceptions.QuartoInvalidoException;
import com.ifpb.model.*;

public class App {
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		GerenciarFuncionario gf = new GerenciarFuncionario();
		GerenciarHospede gh = new GerenciarHospede();
		TipoQuarto[] tqs = new TipoQuarto[4];
		tqs[0] = new TipoQuarto("É um quarto legal");
		tqs[1] = new TipoQuarto("É um quarto massa");
		tqs[2] = new TipoQuarto("É um quarto Top");
		tqs[3] = new TipoQuarto("É um quarto mais ou menos");
		Funcionario f = new Funcionario("", "", "123", "123", "", "", new ContaBancaria("", 1, "", true), new Endereco(null, null, null, 0, null)); 
		gf.create(f);
		
		int i;
		String usuario = null, senha = null;
		boolean interruptor = true;
		LocalDate ld=null;
		
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
				ler.nextLine();
				while(interruptor) {
					System.out.print("1-Quartos     2-Reservas     3-Minha Conta"
							+ "\n4-Hóspede     5-Gerência     0-Sair\n>>>>");
					i = ler.nextInt();
//------------------------------------------------------------------------------------------------					
					if(i == 1) {
						System.out.print("1-Adicionar Quarto     2-Remover Quarto     3-Ver Quartos"
								+ "\n4-Atualizar            5-Ver Por Número     0-Sair\n>>>");
						i = ler.nextInt();
						if(i==1) {
							System.out.println(GerenciaQuarto.create(constroiQuarto(ler, tqs)));
						}
						else if(i==2) {
							System.out.print("Informe o numero do quarto:");
							System.out.println(GerenciaQuarto.delete(ler.nextInt()));
						}
						else if(i==3) {
							System.out.println(GerenciaQuarto.listar());
						}
						else if(i==4){
							System.out.print("Informe o numero do quarto à ser atualizado:");
							System.out.println(GerenciaQuarto.update(ler.nextInt(), constroiQuarto(ler, tqs)));
						}
						else if(i==5) {
							System.out.print("Informe o numero do quarto:");
							System.out.println(GerenciaQuarto.read(ler.nextInt()));
							
						}
					}
//------------------------------------------------------------------------------------------------					
					else if(i==2) {
						System.out.println("1-Criar Reserva     2-Fechar Reserva     3-Apagar Reserva"
								+ "\n4-Atualizar Reserva     5-Buscar Reserva     0-Sair");
						
						i = ler.nextInt();
						String mat = gf.read(usuario).getMatricula();
						if(i==1) {
							Reserva r = construirReserva(ler, mat);
							if(r!=null) {
								System.out.println(GerenciaReserva.create(r));
							}
							else System.out.println("false");
						}
						else if(i==2) {
							System.out.print("Informe o CPF do hóspede:");
							System.out.println(GerenciaReserva.fecharReserva(ler.next()));
						}
						else if(i==3) {
							System.out.print("Informe o CPF do hóspede:");
							System.out.println(GerenciaReserva.delete(ler.next()));
						}
						else if(i==4){
							System.out.print("Informe o CPF do hóspede:");
							System.out.println(GerenciaReserva.update(construirReserva(ler, mat)));
						}
						else if(i==5) {
							System.out.print("Informe o CPF do hóspede:");
							System.out.println(GerenciaReserva.read(ler.next()));
							
						}
						
					}
//------------------------------------------------------------------------------------------------
					else if(i == 3) {
						System.out.println("Suas informações atuais:\n");
						System.out.println(gf.read(usuario));
						System.out.print("1-Atualizar     2-Deletar     0-Sair\n>>>");
						i = ler.nextInt();
						if(i==1) {
							gf.update(usuario, construirFuncionario(ler));
						}
						else if(i==2) {
							System.out.print("Tem certeza que deseja apagar todos os seus dados?\n"
									+ "1-Sim     0-Não\n>>>");
							i=ler.nextInt();
							if(i==1) {
								gf.delete(usuario);
								break;
							}
						}
					}
//------------------------------------------------------------------------------------------------
					else if(i == 4) {
						System.out.println("1-Cadastrar Hóspede     2-Excluir Hóspede     3-Buscar Hóspede por CPF"
								+ "4-Listar Hóspedes     5-Atualizar Hóspede     0-Sair");
						i = ler.nextInt();
						
						if(i==1) {
							
						}
						else if(i==2) {
							
						}
						else if(i==3) {
							
						}
						else if(i==4) {
	
						}
						else if(i==5) {
							
						}
						
					}
					else if(i == 5){
						System.out.println("1-Listar todas as Reservas Fechadas             2-Valor por um determinado período"
								+ "\n3-Listar reservas por um determinado período    0-Sair");
						i = ler.nextInt();
						
						if(i == 1) {
							System.out.println("Lista com todas as Reservas fechadas:\n");
							GerenciaReservaEncerrada.listar();
						}
						else if(i == 2) {
							System.out.println("Informe as datas:\n");
							System.out.println("Data inicio:\n");
							ld = construirData(ler);
							System.out.println("Data fim:\n");
							System.out.println(GerenciaReservaEncerrada.ganhoPeriodo(ld, construirData(ler)));
							
						}
						else if(i == 3) {
							System.out.println("Informe as datas:\n");
							System.out.println("Data inicio:\n");
							ld = construirData(ler);
							System.out.println("Data fim:\n");
							System.out.println(GerenciaReservaEncerrada.reservasPeriodo(ld, construirData(ler)));
						}
					}
					else {
						interruptor=false;
					}
				}
			}
//----------------------------------------------------------------------------------------------------------------------------------------------------	
			else if(i == 2) {
				gf.create(construirFuncionario(ler));
			}else if (i==0){
				System.out.println("Fim do programa");
				break;
			
			} 
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
	 static Quarto constroiQuarto(Scanner ler, TipoQuarto[] tqs) {
		 System.out.print("Informe o numero do quarto:");
		 int i = ler.nextInt();
		 System.out.println("\nInforme o tipo do quarto:\n");
		 for(int k=1;k<5;k++) {
			 System.out.println(k+"-"+tqs[k-1]+"\n");
		 }
		 System.out.print(">>>");
		 return new Quarto(i, tqs[ler.nextInt() - 1]);
	 }
	 static LocalDate construirData(Scanner ler) {
			System.out.print("Informe o ano:");
			int ano = ler.nextInt();
			System.out.print("Informe o mês:");
			int mes = ler.nextInt();
			System.out.print("Informe o dia do mês:");
			int dia = ler.nextInt();
			return LocalDate.of(ano, mes, dia);
	 }
	 static Hospede construirHospede(Scanner ler) {
		 System.out.print("Informe o nome:");
		 String nome = ler.nextLine();
		 System.out.print("Informe CPF:");
		 String cpf = ler.next();
		 System.out.print("Informe telefone:");
		 String telefone = ler.next();
		 System.out.print("Informe email:");
		 String email = ler.next();
		 System.out.println("Informe endereço:");
		 Endereco e = constroiEndereco(ler);
		 return new Hospede(nome, cpf, telefone, email, e);
	 }
	 
	 
	 static Reserva construirReserva(Scanner ler, String matricula) {
		 int i=0;
		 LocalDate ld1;
		 LocalDate ld2;
		 do {
			System.out.println("Informe a data:\n");
		 	System.out.println("Inicio:\n");
		 	ld1 = construirData(ler);
		 	System.out.println("Fim:\n");
		 	ld2 = construirData(ler);
		 	System.out.println(GerenciaQuarto.listarQuartosLivres(ld1, ld2));
		 	System.out.print("Informe quantos quartos para reservar(0 para voltar a informação das datas):");
		 	i = ler.nextInt();
		 }while(i<=0);
		 int[] quartos = new int[i];
		 System.out.println("Informe os quartos:");
		 for(int k = 0;k < i;k++) {
			 System.out.print(">>>");
			 quartos[k] = ler.nextInt();
			 System.out.println();
		 }
		 System.out.println("Informe o CPF do Hospede:\n");
		 String h = ler.next();
		 System.out.println("Valor Total:\n");
		 try {
			return new Reserva(h, matricula,  quartos, ld1, ld2, new Hospedagem(ler.nextFloat()));
		} catch (QuartoInvalidoException e) {
			return null;
		}
		 
	 }
}

