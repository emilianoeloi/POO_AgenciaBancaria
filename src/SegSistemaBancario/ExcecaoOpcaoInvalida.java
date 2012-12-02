package SegSistemaBancario;

@SuppressWarnings("serial")
public class ExcecaoOpcaoInvalida extends RuntimeException {

	public ExcecaoOpcaoInvalida(String message){
		super("ExcecaoOpcaoInvalida: "+message);
	}
}
