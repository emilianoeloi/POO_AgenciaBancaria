package SegSistemaBancario;

public class Corrente extends Conta{

	protected float tarifaManutencao = 12.50f;
	
	public Corrente (int numero, String proprietario, float saldo){
		super (numero, proprietario, saldo, CORRENTE);
	}
	
	public void cobrarTarifa(float tarifaManutencao){
		super.setSaldo(super.getSaldo() - tarifaManutencao);
	}
	
	public String listarDados(){
		return super.listarDados();
	}
}
