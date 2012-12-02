package SegSistemaBancario;

import java.util.Scanner;


public class Principal {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Agencia a = new Agencia();
		int numero, opcao = -1;
		String proprietario;
		float valor = 0, limite = 0;
		byte tipo;
		
		sc.useDelimiter(System.getProperty("line.separator"));
				
		while (opcao != 0){
			try{
				System.out.println ("SISTEMA BANCARIO");
				System.out.println ("0 - SAIR.");
				System.out.println ("1 - CRIAR CONTA.");
				System.out.println ("2 - CANCELAR CONTA.");
				System.out.println ("3 - DEPOSITAR.");
				System.out.println ("4 - SACAR.");
				System.out.println ("5 - LISTAR CONTAS EXISTENTES. (GRATUITO)");
				System.out.println ("6 - CONSULTAR DADOS DA CONTA (TARIFADO P/POUPANCA)");
				System.out.println ("7 - REAJUSTAR POUPANCA");
				System.out.println ("8 - COBRAR TAFIFA CC OU ESPECIAL");
				System.out.println ("9 - COBRAR JUROS CONTA ESPECIAL");
				System.out.print ("Opcao: ");
				opcao = sc.nextInt();
				
				switch (opcao){
						case 0:
							System.out.println ("Sistema Finalizado.");
							break;
					
						case 1:
							try{
							System.out.print ("TIPO DE CONTA\n" +
									"1 - Pounpança \n" +
									"2 - Corrente \n" +
									"3 - Especial \n" +
									"Tipo: ");
							tipo = sc.nextByte();
							
							System.out.print ("Digite os dados da conta a ser criada: \n"+
												"Numero: ");
							numero = sc.nextInt();
							
							System.out.print ("Nome proprietario: ");
							proprietario = sc.next();
							
							
							System.out.print ("Saldo: ");
							valor = sc.nextFloat();
							
								
							if (tipo == 1 || tipo ==2 ){
								a.criarConta (proprietario, numero, valor, tipo, limite);
								System.out.println("Conta criada com sucesso!");
								break;
							} else {
								if (tipo == 3){
									System.out.print ("Entre com o limite da conta especial: ");
									limite = sc.nextFloat();
									a.criarConta (proprietario, numero, valor, tipo, limite);
									System.out.println("Conta criada com sucesso!");
									break;
								} else {
									throw new ExcecaoOpcaoInvalida ("Opção Invalida.");
								}
								
								
							}
					} catch (ExcecaoContaExistente m){
						System.out.println ("Ocorreu um erro na criação da conta.");
						System.out.println ("Detalhe do erro: "+m);
						break;
					}
							
						case 2:
							try{
								System.out.println ("Digite os dados da conta a ser cancelada: ");
								System.out.print ("Numero: ");
								numero = sc.nextInt();
								a.cancelarConta(numero);
								break;
							} catch (ExcecaoContaInexistente m){
								System.out.println ("Ocorreu um erro no cancelamento da conta.");
								System.out.println ("Detalhe do erro: "+m);
								break;
							}
						case 3:
							try{
								System.out.println ("DEPOSITO");
								System.out.print ("Numero: ");
								numero = sc.nextInt();
								System.out.print ("Valor: ");
								valor = sc.nextFloat();
								float r = a.depositar(numero, valor);
								System.out.println ("Deposito realizado com sucesso. Novo Saldo: "+r);
								break;
							} catch (ExcecaoValorNegativo m){
								System.out.println ("Ocorreu um erro no deposito.");
								System.out.println ("Detalhe do erro: "+m);
								break;
							} catch (ExcecaoContaInexistente m){
								System.out.println ("Ocorreu um erro no deposito.");
								System.out.println ("Detalhe do erro: "+m);
								break;
							}
							
						case 4:
							try{
								System.out.println ("SAQUE: ");
								System.out.print ("Numero: ");
								numero = sc.nextInt();
								System.out.print ("Valor: ");
								valor = sc.nextFloat();
								float r = a.sacar(numero, valor);
								System.out.println ("Saque realizado com sucesso. Novo Saldo: "+r);
								break;
							} catch (ExcecaoSaqueInvalido m){
								System.out.println ("Ocorreu um erro no saque.");
								System.out.println ("Detalhe do erro: "+m);
								break;
							}  catch (ExcecaoContaInexistente m){
								System.out.println ("Ocorreu um erro no saque.");
								System.out.println ("Detalhe do erro: "+m);
								break;
							}
						
						case 5:
							System.out.println (a.listarDados());
							break;
						
						case 6:
							
							break;
							
						case 7:
							
							break;
							
						case 8:
							
							break;
							
						case 9:
							
							break;
						default:
							System.out.println ("Opção inválida. Tente novamente");
						
					}
			} catch (ExcecaoOpcaoInvalida m){
				System.out.println ("Ocorreu um erro na validacao da opção. Tente novamente.");
				System.out.println ("Detalhe do erro: "+m);
			}
				}
		
	}

}
