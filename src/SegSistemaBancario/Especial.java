package SegSistemaBancario;


public class Especial extends Corrente {
	
	private float jurosCobrados;
	private float limite;
	private static final float LIMITE_PADRAO = 100.00f;
	private static final float TAXA_JUROS = 8.00f;
	private float valorEmprestado;
	
	public Especial (int numero, String proprietario, float saldo, float limite){
		super(numero, proprietario, saldo);
		super.setTipo(ESPECIAL);
		this.limite = (limite < 0) ? LIMITE_PADRAO : limite;
		super.tarifaManutencao = 20.00f;
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
	
	public void cobrarJuros(){
		super.setSaldo(this.getSaldo() - (valorEmprestado * TAXA_JUROS / 100));
	}
	
	public String listarDados(){
		StringBuilder dados = new StringBuilder();
		
		dados.append(super.listarDados());
		dados.append("\n");
		dados.append("Juros cobrados: ");
		dados.append(formatador.format(this.jurosCobrados));
		dados.append("\n");
		dados.append("Limite de credito: ");
		dados.append(formatador.format(this.limite));
		dados.append("\n");
		dados.append("Valor emprestado: ");
		dados.append(formatador.format(this.valorEmprestado));
		
		return dados.toString();
	}
	
	
	
}
