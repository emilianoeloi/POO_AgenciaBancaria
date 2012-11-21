package SegSistemaBancario;

public class Poupanca extends Conta{

	private int quantidadeConsultas;
	private static float TARIFA_CONSULTA = 1.10f;
	private static int QTDE_MAX_CONSULTAS = 2;
	
	public Poupanca (int numero, String proprietario, float saldo){
		super (numero, proprietario, saldo, POUPANCA);
	}
	
	public float getSaldo(){
		
		if (quantidadeConsultas < 2){
			quantidadeConsultas++;
			return super.getSaldo();
		} else {
			if (super.getSaldo() >= TARIFA_CONSULTA){
				super.setSaldo(super.getSaldo() - TARIFA_CONSULTA);
				 return super.getSaldo();
			 } 
		}
		
		throw new ExcecaoSaldoInsuficiente("Você não possui saldo suficiente para consulta do saldo, e já ultrapassou o limite gratuito por mês.");
		
	}

	public void reajustar (float taxa){
		super.depositar(super.getSaldo() * taxa / 100); //confirmar calculo.
	}
	
	public void sacar (float saque){
		if (saque > super.getSaldo() && quantidadeConsultas < QTDE_MAX_CONSULTAS)
			throw new ExcecaoSaqueInvalido("Saldo insuficiente. Você só pode sacar "+formatador.format(getSaldo()));
		
		if (saque > super.getSaldo())
			throw new ExcecaoSaqueInvalido("Saldo insuficiente. Consulte o seu saldo.");
		
		setSaldo(super.getSaldo() - saque);
		
	}
	
	
	
	
	public String listarDados(){
		return super.listarDados();
	}
	
}
