package SegSistemaBancario;

@SuppressWarnings("serial")
public class ExcecaoContaInexistente extends RuntimeException{

	public ExcecaoContaInexistente(String message){
		super("ExcecaoContaInexistente: "+message);
	}
}
