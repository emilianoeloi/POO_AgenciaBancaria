package SegSistemaBancario;
import java.text.DecimalFormat;

public abstract class Conta {

	DecimalFormat formatador = new DecimalFormat ("R$ #,##0.##");
	
	public static final byte POUPANCA = 1;
	public static final byte CORRENTE = 2;
	public static final byte ESPECIAL = 3;
	
	private byte tipo;
	private int numero;
	private String nomeProprietario;
	private float saldo;
	
	private boolean cobrarTarifa;
	
	
	
	public Conta(int numero, String nomeProprietario, float saldo, byte tipo){
		this.numero = numero;
		this.nomeProprietario = nomeProprietario;
		this.saldo = saldo;
		this.tipo = tipo;
				
	}
	
	public void depositar (float valor){
		if (valor < 0)
			throw new ExcecaoValorNegativo("Você não pode entrar com valor de deposito negativo.");
		saldo += valor;
	}
	
	protected boolean deveCobrarTarifa(){
		return cobrarTarifa;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public String getProprietario(){
		return this.nomeProprietario;
	}
	
	public float getSaldo(){
		return this.saldo;
	}
	
	public int getTipo(){
		return this.tipo;
		
	}
	
	public String listarDados(){
		return "Numero: "+this.numero+"\n"+
				"Proprietário: "+this.nomeProprietario+"\n"+
				"Saldo: "+formatador.format(this.saldo)+"\n"+
				"Tipo: "+this.tipo;
	}
	
	public void sacar (float valor){
		if (valor < 0)
			throw new ExcecaoValorNegativo("Você não pode entrar com valor de saque negativo.");
		if (valor > saldo)
			throw new ExcecaoSaqueInvalido("Saldo insuficiente. Você só pode sacar "+formatador.format(saldo));
		saldo -= valor;
	}
	
	public void setCobrarTarifa(boolean cobrarTarifa){
		this.cobrarTarifa = cobrarTarifa;
	}
	
	protected void setSaldo(float saldo){
		this.saldo = saldo;
	}
	
	protected void setTipo(byte tipo){
		this.tipo = tipo;
	}
	
	@SuppressWarnings("unused")
	private static String tipoContaToString (int tipo){ //confirmar com o Pablo se o metodo est� correto
		switch(tipo){
			case 1:
				return "Poupança";
			case 2:
				return "Corrente";
			case 3:
				return "Especial";
			default:
				throw new ExcecaoContaExistente("A conta não existe");
		}
	}
	
}
