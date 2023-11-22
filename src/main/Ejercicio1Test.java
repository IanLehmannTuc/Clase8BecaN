package main;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Exceptions.NegativeException;
import Exceptions.NuleException;

class Ejercicio1Test {

	@Test
	void testCostoFinalDescuentoFijo() {
		
		Producto producto1 = new Producto("Arroz", "8745F", 2000);
		Producto producto2 = new Producto("Atun", "8574S", 2000);
		Producto producto3 = new Producto("Sal", "8574H", 2000);
		
		Carrito carrito = new Carrito(LocalDateTime.parse("2023-10-14T18:03:00"));
		carrito.setProducto(producto1);
		carrito.setProducto(producto2);
		carrito.setProducto(producto3);
		
		DescuentoFijo desFijo = new DescuentoFijo(2000);
		
		try {
			double valorFinal = carrito.costoFinal(desFijo);
			System.out.println(valorFinal);
			assertEquals(valorFinal, 4000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testCostoFinalDescuentoPorcentajeConTope() {
		
		Producto producto1 = new Producto("Arroz", "8745F", 4000);
		Producto producto2 = new Producto("Atun", "8574S", 4000);
		Producto producto3 = new Producto("Sal", "8574H", 2000);
		
		Carrito carrito = new Carrito(LocalDateTime.parse("2023-10-14T18:03:00"));
		carrito.setProducto(producto1);
		carrito.setProducto(producto2);
		carrito.setProducto(producto3);
		
		DescuentoPorcentajeConTope desConTope = new DescuentoPorcentajeConTope(0.50F);
		desConTope.setValorDesc(0.20F);
		
		try {
			double valorFinal = carrito.costoFinal(desConTope);
			System.out.println(valorFinal);
			assertEquals(valorFinal, 8000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Test
	void testCostoFinalDescuentoPorcentaje() {
		
		Producto producto1 = new Producto("Arroz", "8745F", 2000);
		Producto producto2 = new Producto("Atun", "8574S", 2000);
		Producto producto3 = new Producto("Sal", "8574H", 2000);
		
		Carrito carrito = new Carrito(LocalDateTime.parse("2023-10-14T18:03:00"));
		carrito.setProducto(producto1);
		carrito.setProducto(producto2);
		carrito.setProducto(producto3);
		
		DescuentoPorcentaje desPorcentaje = new DescuentoPorcentaje(0.50F);
		
		try {
			double valorFinal = carrito.costoFinal(desPorcentaje);
			System.out.println(valorFinal);
			assertEquals(valorFinal, 3000);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Test
	void testCostoFinalDescuentoConSubTotalIgualA0() {
		
		Producto producto1 = new Producto("Arroz", "8745F", 2000);
		Producto producto2 = new Producto("Atun", "8574S", 2000);
		Producto producto3 = new Producto("Sal", "8574H", -4000);
		
		Carrito carrito = new Carrito(LocalDateTime.parse("2023-10-14T18:03:00"));
		carrito.setProducto(producto1);
		carrito.setProducto(producto2);
		carrito.setProducto(producto3);
		
		DescuentoFijo desFijo = new DescuentoFijo(2000);
		
		Assertions.assertThrows(NuleException.class, () -> {carrito.costoFinal(desFijo);});
	}
	
	@Test
	void testCostoFinalDescuentoConSubTotalNegativo() {
		
		Producto producto1 = new Producto("Arroz", "8745F", 2000);
		Producto producto2 = new Producto("Atun", "8574S", 2000);
		Producto producto3 = new Producto("Sal", "8574H", -5000);
		
		Carrito carrito = new Carrito(LocalDateTime.parse("2023-10-14T18:03:00"));
		carrito.setProducto(producto1);
		carrito.setProducto(producto2);
		carrito.setProducto(producto3);
		
		DescuentoFijo desFijo = new DescuentoFijo(2000);
		
		Assertions.assertThrows(NegativeException.class, () -> {carrito.costoFinal(desFijo);});
	}

}
