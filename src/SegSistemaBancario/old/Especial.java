package SegSistemaBancario;


public class Especial extends Corrente {
	
	private float jurosCobrados;
	private float limite;
	private static final float LIMITE_PADRAO = 100.00f;
	private static final float TAXA_JUROS = 8.00f;
	private float valorEmprestado;
	
	public Especial (int numero, String proprietario, float saldo){
		super (numero, proprietario, saldo, ESPECIAL);
		this.valorEmprestado = 0;
		
	}
	
	
	public void cobrarJuros(){
	}
	
	public void sacar(float saque){
		if(super.getSaldo()+LIMITE_PADRAO < saque)
			throw new ExcecaoSaqueInvalido("Saldo insuficiente. Você só pode sacar "+formatador.format(super.getSaldo()+LIMITE_PADRAO));
		
		if(super.getSaldo() < saque){
			this.valorEmprestado += saque - super.getSaldo();
			super.setSaldo(0);
		}else{
			super.sacar(saque);
		}
	}
	
	public float getSaldo(){
		return this.getSaldo();
	}
	
	public String listarDados(){
		return super.listarDados();
	}
	
	
	
}
