package com.ifpb.view;
import java.awt.List;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ifpb.control.*;
import com.ifpb.exceptions.HospedeInexistenteException;
import com.ifpb.exceptions.ListaHospedeVaziaException;
import com.ifpb.exceptions.PeriodoDataIncorretoException;
import com.ifpb.exceptions.QuartoInvalidoException;
import com.ifpb.model.*;

public class App {
	public static void main(String[] args) {
		
		Scanner ler = new Scanner(System.in);
		GerenciarFuncionario gf = new GerenciarFuncionario();
		TipoQuarto[] tqs = new TipoQuarto[4];
		tqs[0] = new TipoQuarto("É um quarto legal");
		tqs[1] = new TipoQuarto("É um quarto massa");
		tqs[2] = new TipoQuarto("É um quarto Top");
		tqs[3] = new TipoQuarto("É um quarto mais ou menos");
		Funcionario f = new Funcionario("", "", "123", "123", "", "", new ContaBancaria("", 1, "", true), new Endereco(null, null, null, 0, null)); 
		gf.create(f);
		
		int i=0;
		String usuario = null, senha = null;
		boolean interruptor = true;
		LocalDate ld=null;
		LocalDate ld2=null;
		
		while(interruptor) {
			System.out.println("----------------TELA INICIAL--------------");
			
			System.out.print("1-Autenticar        2-Criar nova conta     0-Sair\n>>>>>");

			try {
				i = ler.nextInt();
				if(i == 1) {
					System.out.print("Usuário(email):");
					usuario = ler.next();
					System.out.print("Senha:");
					senha = ler.next();
				}
			}catch(InputMismatchException e){
				System.out.println("Tipo de dados fornecidos incorretos\\n");
				ler.nextLine();
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
						System.out.print("\n1-Adicionar Quarto     2-Remover Quarto     3-Ver Quartos"
								+ "\n4-Atualizar            5-Ver Por Número     0-Sair\n>>>");
						try {
							i = ler.nextInt();
							if(i==1) {
								if(GerenciaQuarto.create(constroiQuarto(ler, tqs)))
									System.out.println("Novo Quarto Criado!");
								else
									System.out.println("Operação não realizada");
							}
							else if(i==2) {
								System.out.print("Informe o numero do quarto:");
								if(GerenciaQuarto.delete(ler.nextInt()))
									System.out.println("Quarto removido!");
								else
									System.out.println("Operação não realizada");
							}
							else if(i==3) {
								System.out.println("Lista de Quartos:");
								System.out.println("\n"+GerenciaQuarto.listar()+"\n");
							}
							else if(i==4){
								System.out.print("Informe o numero do quarto à ser atualizado:");
								if(GerenciaQuarto.update(ler.nextInt(), constroiQuarto(ler, tqs)))
									System.out.println("Quarto atualizado");
								else
									System.out.println("Operação não realizada");
							}
							else if(i==5) {
								System.out.print("Informe o numero do quarto:");
								if(GerenciaQuarto.read(ler.nextInt())!=null)
									System.out.println(GerenciaQuarto.read(ler.nextInt()));
								else
									System.out.println("Quarto não encontrado");
								
							}
						}catch(InputMismatchException e) {
							System.out.println("Tipo de dados fornecidos incorretos\n");
							ler.nextLine();
						}
					}
//------------------------------------------------------------------------------------------------					
					else if(i==2) {
						System.out.print("1-Criar Reserva     2-Fechar Reserva     3-Apagar Reserva"
								+ "\n4-Atualizar Reserva     5-Buscar Reserva     0-Sair\n>>>");
						try {
							i = ler.nextInt();
							String mat = gf.read(usuario).getMatricula();
							Reserva r = null;
							if(i==1 || i==4) {
								r = construirReserva(ler, mat);
								if(r==null) {
									System.out.println("Error ao criar reserva");
									i=0;
								}
							}
							if(i==1) {
								if(GerenciaReserva.create(r))
									System.out.println("Novo Reserva criada\n");
								else
									System.out.println("Operação não realizada\n");
							}
							else if(i==2) {
								System.out.print("Informe o CPF do hóspede:");
								if(GerenciaReserva.fecharReserva(ler.next()))
									System.out.println("Reserva fechada\n");
								else
									System.out.println("Operação não realizada\n");
							}
							else if(i==3) {
								System.out.print("Informe o CPF do hóspede:");
								if(GerenciaReserva.delete(ler.next()))
									System.out.println("Reserva removida\n");
								else
									System.out.println("Operação não realizada");
							}
							else if(i==4){
								System.out.print("Informe o CPF do hóspede:");
								if(GerenciaReserva.update(r))
									System.out.println("Reserva atualizada\n");
								else
									System.out.println("Operação não realizada\n");
							}
							else if(i==5) {
								System.out.print("Informe o CPF do hóspede:");
								if(GerenciaReserva.read(ler.next())!=null)
									System.out.println(GerenciaReserva.read(ler.next()));
								else
									System.out.println("Reserva não encontrada");
								
							}
						}catch(InputMismatchException e) {
							System.out.println("Tipo de Dado informado incorreto!");
							ler.nextLine();
						}
						
						
					}
//------------------------------------------------------------------------------------------------
					else if(i == 3) {
						try {
							System.out.println("Suas informações atuais:\n");
							System.out.println(gf.read(usuario));
							System.out.print("1-Atualizar     2-Deletar     0-Sair\n>>>");
							i = ler.nextInt();
							if(i==1) {
								gf.update(usuario, construirFuncionario(ler)); 
								break;
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
						}catch(InputMismatchException e) {
							System.out.println("Tipo de dado inserido é incorreto");
							ler.nextLine();
						}
					}
//------------------------------------------------------------------------------------------------
					else if(i == 4) {
						System.out.print("1-Cadastrar Hóspede     2-Excluir Hóspede     3-Buscar Hóspede por CPF ou Nome"
								+ "\n4-Listar Hóspedes       5-Atualizar Hóspede   0-Sair\n>>>");
						
						try {
							i = ler.nextInt();
							if(i==1) {
								if(GerenciarHospede.create(construirHospede(ler)))
									System.out.println("Novo Hóspede cadastrado");
								else
									System.out.println("Operação não realizada");
							}
							else if(i==2) {
								System.out.print("Informe o CPF do hospede:");
								if(GerenciarHospede.delete(ler.next()))
									System.out.println("Hóspede removido!");
								else
									System.out.println("Operação não realizada");
							}
							else if(i==3) {
								System.out.print("Informe o nome ou o CPF do hospede:");
								System.out.println(GerenciarHospede.readHospede(ler.next()));
							}
							else if(i==4) {
								System.out.println("Lista de hóspedes: ");
								System.out.println(GerenciarHospede.listarHospedes());
							}
							else if(i==5) {
								if(GerenciarHospede.update(construirHospede(ler)))
									System.out.println("Hóspede atualizado");
								else
									System.out.println("Operação não realizada");
							}
						}catch(ListaHospedeVaziaException e) {
							System.out.println(e.getMessage());
						}catch(InputMismatchException e) {
							System.out.println("Informação incorreta!");
							ler.nextLine();
						}
						
					}
					else if(i == 5){
						try {
							System.out.println("1-Listar todas as Reservas Fechadas             2-Valor por um determinado período"
									+ "\n3-Listar reservas por um determinado período    0-Sair");
							i = ler.nextInt();
							
							if(i == 1) {
								System.out.println("Lista de todas as Reservas fechadas:\n");
								System.out.println(GerenciaReservaEncerrada.listar());
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
								ld2 = construirData(ler);
								Period p = Period.between(ld, ld2);
							 	if(p.getDays()+p.getMonths()+p.getYears()<0)
							 		throw new PeriodoDataIncorretoException();
							 	System.out.println("Reservas no período:");
								System.out.println(GerenciaReservaEncerrada.reservasPeriodo(ld, ld2));
							}
						}catch(InputMismatchException e) {
							System.out.println("Tipo de dado informado é incorreto");
							ler.nextLine();
						}catch(PeriodoDataIncorretoException e) {
							System.out.println(e.getMessage());
						}catch(DateTimeException e) {
							System.out.println("Formato de data incorreto");
						}
						
					}
					else {
						interruptor=false;
					}
				}
			}
//----------------------------------------------------------------------------------------------------------------------------------------------------	
			else if(i == 2) {
				try {
				if(gf.create(construirFuncionario(ler)))
					System.out.println("Novo funcionário criado");
				else
					System.out.println("Falha na operação");
				}catch(InputMismatchException e) {
					System.out.println("Tipo de dado informado é incorreto");
					ler.nextLine();
				}
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
		try {
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
		}catch(InputMismatchException e) {
			System.out.println("Valor incorreto");
		}
		return null;
	 }
	 
	 static Endereco constroiEndereco(Scanner ler) {
		 System.out.print("Informe a cidade:");
		 ler.nextLine();
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
	 static LocalDate construirData(Scanner ler)  {
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
		 ler.nextLine();
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
		 try {
			 int i=0;
			 LocalDate ld1;
			 LocalDate ld2;
			 do {
				System.out.println("Informe a data:\n");
			 	System.out.println("Inicio:\n");
			 	ld1 = construirData(ler);
			 	System.out.println("Fim:\n");
			 	ld2 = construirData(ler);
			 	Period p = Period.between(ld1, ld2);
			 	if(p.getDays()+p.getMonths()+p.getYears()<0)
			 		throw new PeriodoDataIncorretoException();
			 	
			 	ArrayList<Quarto> l = GerenciaQuarto.listarQuartosLivres(ld1, ld2);
			 	System.out.println("\n"+l+"\n");
			 	if(l.size()==0) {
			 		System.out.println("Informe no máximo a quantidade de quartos exibidos na tela");
			 		i=0;
			 	}
			 	System.out.print("Informe quantos quartos para reservar(0 para voltar a informação das datas e -1 para sair):");
			 	i = ler.nextInt();
			 	if(i<0) {
			 		return null;
			 	}
			 	if(i>l.size()) {
			 		System.out.println("Informe no máximo a quantidade de quartos exibidos na tela");
			 		i=0;
			 	}
			 }while(i<=0);
			 int[] quartos = new int[i];
			 System.out.println("Informe os quartos:");
			 for(int k = 0;k < i;k++) {
				 System.out.print(">>>");
				 quartos[k] = ler.nextInt();
				 System.out.println();
			 }
			 System.out.print("Informe o CPF do Hospede:");
			 String h = ler.next();
			 System.out.print("Valor Total:");
		 
			return new Reserva(h, matricula,  quartos, ld1, ld2, new Hospedagem(ler.nextFloat()));
		} catch (QuartoInvalidoException e) {
			return null;
		} catch(ListaHospedeVaziaException e) {
			System.out.println(e.getMessage());
		} catch (HospedeInexistenteException e) {
			return null;
		} catch(PeriodoDataIncorretoException e) {
			System.out.println(e.getMessage());
		} catch(DateTimeException e) {
			System.out.println("Formato de data incorreto");
		}
		return null;
		 
	 }
}