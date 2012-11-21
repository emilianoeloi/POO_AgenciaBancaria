import SegSistemaBancario.Conta;


public class Especial extends Conta {
	
	private float jurosCobrados, limite;
	private static final float  LIMITE_PADRAO = 100.0f;
	private static final float TAXA_JUROS = 0.07f;
	private float valorEmprestado;
	
	
	public Especial (int numero, String proprietario, float saldo, byte tipo){
		super (numero, proprietario, saldo, ESPECIAL);
	}
	
	
	public void cobrarJuros(){
		
	}
	
	public void depositar(){
		
	}
	
	public void sacar(float saque){
		if ((super.getSaldo()+LIMITE_PADRAO) > saque){
			super.setSaldo(saldo);
		}
	}
	
	public float getSaldo(){
		return this.getSaldo();
	}
	
	public String listarDados(){
		return super.listarDados();
	}
	
	
	
}
