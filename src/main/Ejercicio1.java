package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

import Exceptions.NegativeException;
import Exceptions.NuleException;

public class Ejercicio1 {

	public static void main(String[] args) {

		String archivoEntrada = "compras.txt";
		try {
			Carrito carrito = new Carrito(LocalDateTime.parse("2023-10-14T18:03:00"));
			List<String> lista = Files.readAllLines(Paths.get(archivoEntrada));
			boolean cabezaLista = true;
			for(String item : lista ){
				if(cabezaLista) {
					cabezaLista = false;
				}
				else {
					String[] datosProducto = item.split(" ");
					Producto producto = new Producto(datosProducto[1], datosProducto[2], Float.parseFloat(datosProducto[0]));
					carrito.setProducto(producto);
				}
			}
			
			Persona persona1 = new Persona("Ian", "Lehmann", LocalDateTime.parse("1997-03-02T10:00:00"), carrito);
			
			Carrito miCarrito = persona1.getCarrito();
			
			Descuento desFijo = new DescuentoFijo(0);
			Descuento desPorcentaje = new DescuentoPorcentaje(0.50F);
			Descuento desPorcentajeconTope = new DescuentoPorcentajeConTope(0.30F);
			
			desPorcentajeconTope.setValorDesc(0.20F);
			desPorcentaje.setValorDesc(4);
			
			double resultado = miCarrito.costoFinal(desFijo);
			System.out.println(resultado);
		}
		catch(IOException e){
			System.out.println(e);
		}
		catch(NuleException e) {
			System.out.println(e);
		}
		catch(NegativeException e) {
			System.out.println(e);
		}
		
	}

}
