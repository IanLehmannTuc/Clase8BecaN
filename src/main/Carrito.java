package main;

import java.time.LocalDateTime;
import java.util.ArrayList;

import Exceptions.NegativeException;
import Exceptions.NuleException;

public class Carrito {
	
	private ArrayList<Producto> productos;
	private LocalDateTime fechaCompra;
	
	public Carrito(LocalDateTime fechaCompra){
		productos = new ArrayList<>();
		this.fechaCompra = fechaCompra;
	}
	
	public ArrayList<Producto> getListProductos(){
		return this.productos;
	}
	
	public void setProducto(Producto producto) {
		productos.add(producto);
	}
	
	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}
	
	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	
	public double costoFinal(Descuento desc) throws NuleException, NegativeException {
		float subtotal = 0;
		for(Producto item : this.getListProductos()) {
			subtotal += item.getPrecio();
		}
		if(subtotal == 0) {
			throw new NuleException();
		}
		else if(subtotal < 0) {
			throw new NegativeException();
		}
		else {
			float total = desc.valorFinal(subtotal);
			return total;
		}
	}
	
}
