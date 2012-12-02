package SegSistemaBancario;

import java.util.ArrayList;


public class Agencia {
	
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	private final int MAX_CONTAS = 20;
	

	public void criarConta (String proprietario, int numero, float saldo, byte tipo, float limite ){
		if (contas.size() == MAX_CONTAS){
			throw new ExcecaoFaltaEspaco("MÁXIMO DE CONTAS ATINGIDO!");
			
		} else {
			boolean val = validarConta(numero);
				if (val == true){
					throw new ExcecaoContaExistente("Número de conta existente!");
					
				} else {
					switch(tipo){
						case 1:
							contas.add( new Poupanca(numero, proprietario, saldo));
							break;
						case 2:
							contas.add(new Corrente(numero, proprietario, saldo));
							break;
						case 3:
							contas.add (new Especial (numero, proprietario, saldo, limite));
							break;
					}
				}
		}
	}
	
	
	private Conta getConta(int numero){ //RETORNA OBJETO CONTA - REVISAR
		boolean val = validarConta(numero);
		if (val == true){
			for (Conta c : contas){
				int tipo = c.getTipo();
				switch(tipo){
					case 1:
					
				}
				}
			}
		throw new ExcecaoContaInexistente("Conta não existe!");
		}
		
	
	public boolean validarConta(int numero){
		for (Conta c : contas){
			if (c.getNumero() == numero){
				return true;
			}
		}
		return false;
	}
	

	public void cancelarConta(int numero){
		boolean val = validarConta(numero);
		if (val == true){
			for (Conta c : contas){
				if (c.getNumero() == numero){
					contas.remove(c);
				}
			}
	
		}
		throw new ExcecaoContaInexistente("Conta não existe!");
	}
	

	public String listarDados (){
		String r = null;
		for (Conta c : contas){
			 r += c.listarDados();
		}
		return r;
	}
	

	public float depositar(int numero, float valor){
		boolean val = validarConta(numero);
		if (val == true){
			for (Conta c : contas){
				if (c.getNumero() == numero){
					c.depositar(valor);
					return c.getSaldo();
				}
			}
		}
		throw new ExcecaoContaInexistente("Conta não exite.");

	}
	

	public float sacar (int numero, float valor){
		boolean val = validarConta(numero);
		if (val == true){
			for (Conta c : contas){
				if (c.getNumero() == numero){
					c.sacar(valor);
					return c.getSaldo();
				}
			}
		} 
		throw new ExcecaoContaInexistente("Conta inexistente.");
	}

	
	public void cobrarJurosContaEspecial(int numero){
		boolean val = validarConta(numero);
		if (val == true){
			for (Conta c : contas){
				if(c.getNumero() == numero){
					if (c.getTipo() == 3){
						
					}
				}
			}
		}
	}
	
	
	public void cobrarTarifa(int numero){
		boolean val = validarConta(numero);
		if (val == true){
			for (Conta c: contas){
				if (c.getNumero() == numero){
					c.setCobrarTarifa(true);
				}
			}
		}
		throw new ExcecaoContaInexistente("Conta inexistente.");
	}
	
	
	public String consultaConta(int numero){
		boolean val= validarConta(numero);
		if (val == true){
			for (Conta c: contas){
				if (c.getNumero() == numero){
					return c.listarDados();
				}
			}
		}
		throw new ExcecaoContaInexistente("Conta inexistente.");
	}
	
	
	public void reajustarPounpanca(int numero, float taxa){ //REVISAR
		boolean val= validarConta(numero);
		if (val == true){
			for (Conta c: contas){
				if (c.getNumero() == numero){
					
				}
			}
		}
		throw new ExcecaoContaInexistente("Conta inexistente.");
	}
	
	

	public void cobrarTarifa(){
		
	}
	

}
