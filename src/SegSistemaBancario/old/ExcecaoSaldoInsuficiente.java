package SegSistemaBancario;

@SuppressWarnings("serial")
public class ExcecaoSaldoInsuficiente extends RuntimeException{

	public ExcecaoSaldoInsuficiente(String message){
		super("ExcecaoSaldoInsuficiente: "+message);
	}
}
