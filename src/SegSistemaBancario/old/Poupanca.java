package SegSistemaBancario;

public class Poupanca extends Conta{

	private static float TARIFA_CONSULTA = 1.10f;
	private int quantidadeConsultas;
	private static int QTDE_MAX_CONSULTAS = 2;
	
	public Poupanca (int numero, String proprietario, float saldo){
		super (numero, proprietario, saldo, POUPANCA);
	}
	
	public float getSaldo(){
		if(super.deveCobrarTarifa()){
			if(super.getSaldo() < TARIFA_CONSULTA)
				throw new ExcecaoSaldoInsuficiente("Você não possui saldo suficiente para consulta do saldo, e já ultrapassou o limite gratuito por mês.");
			super.sacar(TARIFA_CONSULTA);
		}
		this.quantidadeConsultas++;
		this.setCobrarTarifa(quantidadeConsultas >= QTDE_MAX_CONSULTAS);
		return super.getSaldo();
	}

	public void reajustar (float taxa){
		
		super.depositar(super.getSaldo() * taxa / 100);
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
