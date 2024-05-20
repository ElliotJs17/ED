package cursoED.semana04;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ListaEnlazadaSimpleTest {

	Lista<Integer> lista = new ListaEnlazadaSimple<>();

	@Test
	void testTamanyoConUnaListaVacia() {
		assertEquals(0, lista.tamanyo());
	}

	@Test
	void testTamanyoConUnaListaConAlgunosElementos() {
		lista.agregar(12);
		lista.agregar(14);
		lista.agregar(16);
		assertEquals(3, lista.tamanyo());
	} 

	@Test
	void testEsVacioaListaInicialEsVacio() {
		assertTrue(lista.esVacio());
	}

	@Test
	void testEsVacioaListaConAlgunosElementosNoEsVacio() {
		lista.agregar(16);
		assertFalse(lista.esVacio());
	}

	@Test
	void testContieneListaVacia() {	    
	    assertFalse(lista.contiene(5));
	}
	
	@Test
	void testContieneUnElementoCoincidente() {
	    lista.agregar(5);
	    assertTrue(lista.contiene(5));
	}
	
	@Test
	void testContieneElementoPresenteEnLista() {
	    lista.agregar(10);
	    lista.agregar(15);
	    lista.agregar(20);
	    assertTrue(lista.contiene(15));
	}
	
	@Test
	void testContieneElementoNoPresenteEnLista() {
	    lista.agregar(10);
	    lista.agregar(15);
	    assertFalse(lista.contiene(20));
	}


	@Test
	void testAgregarUnElemento() {
	    lista.agregar(5);
	    assertEquals(1, lista.tamanyo());
	    assertEquals(5, lista.get(0));
	}
	
	@Test
	void testAgregarMultiplesElementos() {
	    lista.agregar(10);
	    lista.agregar(15);
	    lista.agregar(20);
	    assertEquals(3, lista.tamanyo());
	    assertEquals(10, lista.get(0));
	    assertEquals(15, lista.get(1));
	    assertEquals(20, lista.get(2));
	}

	@Test
	void testAgregarEnIndiceCeroEnListaVacia() {
	    lista.agregar(0, 5); 
	    assertEquals(1, lista.tamanyo());
	    assertEquals(5, lista.get(0));
	}

	@Test
	void testAgregarEnIndiceCeroEnListaNoVacia() {
	    lista.agregar(0, 5);
	    lista.agregar(0, 10);
	    assertEquals(2, lista.tamanyo());
	    assertEquals(10, lista.get(0));
	    assertEquals(5, lista.get(1));
	}
	
	@Test
	void testAgregarEnIndiceIntermedioEnListaNoVacia() {
	    lista.agregar(0, 5);
	    lista.agregar(0, 10);
	    lista.agregar(1, 15); // Insertar en el medio de la lista
	    assertEquals(3, lista.tamanyo());
	    assertEquals(10, lista.get(0));
	    assertEquals(15, lista.get(1));
	    assertEquals(5, lista.get(2));
	}

	@Test
	void testAgregarEnUltimoIndice() {
	    lista.agregar(0, 5);
	    lista.agregar(1, 10);
	    lista.agregar(2, 15);
	    assertEquals(3, lista.tamanyo());
	    assertEquals(15, lista.get(2));
	}

	@Test
	void testAgregarEnIndiceFueraDeLimites() {
	    lista.agregar(0, 5);
	    assertThrows(IndexOutOfBoundsException.class, () -> lista.agregar(5, 20));
	}
	
	@Test
	void testRemoverElementoNulo() {
	    lista.agregar(10);
	    lista.agregar(null);
	    lista.agregar(30);
	    
	    assertTrue(lista.remover(null)); // Llama al método remover(Object o)
	    
	    assertFalse(lista.contiene(null));
	    assertEquals(2, lista.tamanyo());
	}

	@Test
	void testRemoverElementoDeListaVacia() {
	    Integer numero = 5;
	    assertFalse(lista.remover(numero)); // Llama al método remover(Object o)
	}

	@Test
	void testRemoverElementoNoPresente() {
	    lista.agregar(10);
	    lista.agregar(20);
	    Integer numero = 15;
	    assertFalse(lista.remover(numero)); // Llama al método remover(Object o)
	    assertEquals(2, lista.tamanyo());
	}

	@Test
	void testRemoverPrimerElemento() {
	    lista.agregar(10);
	    lista.agregar(20);
	    Integer numero = 10;
	    assertTrue(lista.remover(numero)); // Llama al método remover(Object o)
	    assertEquals(1, lista.tamanyo());
	    assertFalse(lista.contiene(10));
	}

	@Test
	void testRemoverElementoEnMedio() {
	    lista.agregar(10);
	    lista.agregar(20);
	    lista.agregar(30);
	    Integer numero = 20;
	    assertTrue(lista.remover(numero)); // Llama al método remover(Object o)
	    assertEquals(2, lista.tamanyo());
	    assertEquals(1, lista.indiceDe(30));
	}

	@Test
	void testRemoverUltimoElemento() {
	    lista.agregar(10);
	    lista.agregar(20);
	    Integer numero = 20;
	    assertTrue(lista.remover(numero));  // Llama al método remover(Object o)
	    assertEquals(1, lista.tamanyo());
	    assertFalse(lista.contiene(20));
	}
	
	@Test
	void testRemoverPrimerElementoIndice() {
	    lista.agregar(10);
	    lista.agregar(20);
	    lista.agregar(30);
	    
	    assertEquals(10, lista.remover(0));
	    assertEquals(2, lista.tamanyo());
	    assertFalse(lista.contiene(10));
	}

	@Test
	void testRemoverElementoEnMedioIndice() {
	    lista.agregar(10);
	    lista.agregar(20);
	    lista.agregar(30);
	    
	    assertEquals(20, lista.remover(1));
	    assertEquals(2, lista.tamanyo());
	    assertEquals(1, lista.indiceDe(30));
	}

	@Test
	void testRemoverUltimoElementoIndice() {
	    lista.agregar(10);
	    lista.agregar(20);
	    lista.agregar(30);
	    
	    assertEquals(30, lista.remover(2));
	    assertEquals(2, lista.tamanyo());
	    assertFalse(lista.contiene(30));
	}

	@Test
	void testLimpiar() {
	    lista.agregar(10);
	    lista.agregar(20); 
	    lista.agregar(30);
	    
	    assertEquals(3, lista.tamanyo());
	    
	    lista.limpiar();
	    
	    assertTrue(lista.esVacio());
	    assertEquals(0, lista.tamanyo());
	}

	@Test
	void testGet() {
	    lista.agregar(10);
	    lista.agregar(20);
	    lista.agregar(30);
	    
	    assertEquals(10, lista.get(0));
	    assertEquals(20, lista.get(1));
	    assertEquals(30, lista.get(2));
	}

	@Test
	void testSet() {
	    lista.agregar(10);
	    lista.agregar(20);
	    lista.agregar(30);
	    
	    lista.set(1, 25);
	    
	    assertEquals(25, lista.get(1));
	}
	
	@Test
	void testIndiceDeConNulo() {
	    lista.agregar(10);
	    lista.agregar(null);
	    lista.agregar(30);
	    
	    assertEquals(0, lista.indiceDe(10));
	    assertEquals(1, lista.indiceDe(null));
	    assertEquals(2, lista.indiceDe(30));
	}

	@Test
	void testIndiceDe() {
	    lista.agregar(10);
	    lista.agregar(20);
	    lista.agregar(30);
	    
	    assertEquals(0, lista.indiceDe(10));
	    assertEquals(1, lista.indiceDe(20));
	    assertEquals(2, lista.indiceDe(30));
	}

	@Test
	void testToString() {
		assertEquals("Lista()", lista.toString());
		lista.agregar(1);
		assertEquals("Lista(1)", lista.toString());
		lista.agregar(2);
		lista.agregar(3);
		assertEquals("Lista(1, 2, 3)", lista.toString());
		lista.agregar(4);
		lista.agregar(5);
		assertEquals("Lista(1, 2, 3, 4, 5)", lista.toString());
	}
}
