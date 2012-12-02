package SegSistemaBancario;

import java.util.ArrayList;


public class Agencia {
	
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private final int MAX_CONTAS = 20;
	

	public void criarConta (String proprietario, int numero, float saldo){
		if (contas.size() == MAX_CONTAS){
			throw new ExcecaoFaltaEspaco("MÁXIMO DE CONTAS ATINGIDO!");
			
		} else {
			boolean val = validarConta(numero);
			if (val == true){
				throw new ExcecaoContaExistente("Número de conta existente!");
				
			} else {
				contas.add(conta);
			
			}
			
		}
	}
	

	public boolean validarConta(int numero){
		for (Conta c : contas){
			if (c.getNumero() == numero){
				return true;
			}
		}
		return false;
	}
	

	public void cancelaConta(int numero){
		boolean val = validarConta(numero);
		if (val == true){
			for (Conta c : contas){
				if (c.getNumero() == numero){
					contas.remove(c);
					System.out.println ("Conta cancelada.");
					break;
				}
			}
		} else {
			System.out.println ("Conta não existe");
		}
		
		


	}
	

	public void listarDados (){
		for (Conta c : contas){
			 System.out.println(c.listarDados());
		}
	}
	

	public void depositar(int numero, float valor){
		boolean val = validarConta(numero);
		if (val == true){
			for (Conta c : contas){
				if (c.getNumero() == numero){
					c.depositar(valor);
					break;
				}
			}
		} else {
			System.out.println ("Conta não existe!");
		
		}
		

	}
	

	public void sacar (int numero, float valor){
		boolean val = validarConta(numero);
		if (val == true){
			for (Conta c : contas){
				if (c.getNumero() == numero){
					c.sacar(valor);
					break;
				}
			}
		} else {
			System.out.println ("Conta não existe!");
		
		}
	}
}
