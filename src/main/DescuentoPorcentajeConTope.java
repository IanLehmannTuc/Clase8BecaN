package main;

public class DescuentoPorcentajeConTope extends DescuentoPorcentaje{
	
	private float tope;
	
	public DescuentoPorcentajeConTope(float tope) {
		super(0);
		this.tope = tope;
	}

	public float getTope() {
		return tope;
	}

	public void setTope(float nuevoValor) {
		this.tope = nuevoValor;
	}

	@Override
	public void setValorDesc(float valor) {
		if(valor > this.tope) {
			super.valorFinal(0);
			System.out.println("no se puede poner ese valor porque supero el tope");
		}
		else {
			super.setValorDesc(valor);
		}
	}

}
