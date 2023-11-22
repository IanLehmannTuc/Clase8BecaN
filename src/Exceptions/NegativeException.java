package Exceptions;

public class NegativeException extends Exception{
	
	public NegativeException() {
		super("El valor no puede ser numero negativo para aplicar el descuento");
	}

}
