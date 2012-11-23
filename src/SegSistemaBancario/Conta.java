package SegSistemaBancario;
import java.text.DecimalFormat;
public abstract class Conta {
	
	public static final byte POUPANCA = 1;
	public static final byte CORRENTE = 2;
	public static final byte ESPECIAL = 3;
	private int              numero;
	private String           proprietario;
	private float            saldo;
	private byte             tipo;
	private boolean          cobrarTarifa;
	DecimalFormat            formatador = new DecimalFormat ("R$ #,##0.##");
	
	public Conta(int numero, String proprietario, float saldo, byte tipo){
		this.numero = numero;
		this.proprietario = proprietario;
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
		return this.proprietario;
	}
	
	public float getSaldo(){
		return this.saldo;
	}
	
	public int getTipo(){
		return this.tipo;
		
	}
	
	public String listarDados(){
		
		StringBuilder dados = new StringBuilder();
		
		dados.append("Número: ");
		dados.append(this.numero);
		dados.append("\n");
		dados.append("Proprietário: ");
		dados.append(this.proprietario);
		dados.append("\n");
		dados.append("Saldo: ");
		dados.append(formatador.format(this.saldo));
		dados.append("\n");
		dados.append("Tipo: ");
		dados.append(this.tipo);
		
		return dados.toString();
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
	
	private static String tipoContaToString (byte tipo){ 
		switch(tipo){
			case 1:
				return "Poupança";
			case 2:
				return "Corrente";
			case 3:
				return "Especial";
			default:
				return "Tipo de Conta Padrão";
		}
	}
	
}
