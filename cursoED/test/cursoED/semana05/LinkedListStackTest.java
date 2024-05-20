package cursoED.semana05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LinkedListStackTest {
	LinkedListStack<Integer> stack = new LinkedListStack<>();

	@Test
	void testLinkedListStack() {
		assertTrue(stack.empty()); // Verificamos que la pila este vacia al inicio
	}

	@Test
	void testPush() {
        stack.push(1);
        stack.push(2); 
        stack.push(3); 
        assertFalse(stack.empty()); // Verificamos que la pila no este vacia despues de empujar un elemento 

	}

	@Test
	void testPopNonEmptyStack() {
	    // Agregamos algunos elementos a la pila
	    stack.push(1);
	    stack.push(2);
	    stack.push(3);

	    // Verificamos que los elementos sean eliminados en el orden correcto
	    assertEquals(3, stack.pop());
	    assertEquals(2, stack.pop());
	    assertEquals(1, stack.pop());

	    // Verificamos que la pila este vacia después de eliminar todos los elementos
	    assertTrue(stack.empty()); 
	}
	
	@Test
	void testPopEmptyStack() {
	    assertTrue(stack.empty()); // Verificamos que la pila este vacia inicialmente

	    // Intentamos hacer pop en una pila vacia y verificamos que se lance la excepcion
	    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.pop());
	    assertEquals("La pila está vacía", exception.getMessage());
	}

	@Test
	void testPeekNonEmptyStack() {
	    // Agregamos algunos elementos a la pila
	    stack.push(1);
	    stack.push(2);
	    stack.push(3);

	    // Verificamos que el elemento en la cima sea el esperado
	    assertEquals(3, stack.peek());

	    // Verificamos que la pila no este vacía despues de hacer peek
	    assertFalse(stack.empty());
	}
	
	@Test
	void testPeekEmptyStack() {
	    assertTrue(stack.empty()); // Verificamos que la pila este vacia inicialmente

	    // Intentamos hacer peek en una pila vacia y verificamos que se lance la excepcion
	    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.peek());
	    assertEquals("La pila está vacía", exception.getMessage());
	}

	@Test
	void testEmpty() {
		assertTrue(stack.empty()); // Verificamos que la pila este vacia inicialmente
	}

	@Test
	void testToString() {
		assertEquals("Lista()", stack.toString()); // Verificamos que la representacion de cadena sea la esperada para una pila vacia
        stack.push(1);
        assertEquals("Lista(1)", stack.toString()); // Verificamos que la representacion de cadena sea la esperada despues de añadir un elemento
        stack.push(2);
        assertEquals("Lista(2, 1)", stack.toString()); // Verificamos que la representacion de cadena sea la esperada despues de empujar varios elementos
	}

}
