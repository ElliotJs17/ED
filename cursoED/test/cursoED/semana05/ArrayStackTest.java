package cursoED.semana05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayStackTest {
	ArrayStack<Integer> stack = new ArrayStack<>(5);

	@Test
	void testArrayStackInt() {
		assertTrue(stack.empty()); // Verificamos que la pila esté vacia
        assertEquals(5, stack.MAX_SIZE); // Verificamos que el tamaño maximo sea el esperado
	}

	@Test
	void testArrayStack() { 
		ArrayStack<Integer> emptyStack = new ArrayStack<>();
        assertTrue(emptyStack.empty()); 
        assertEquals(ArrayStack.DEFAULT_MAX_SIZE, emptyStack.MAX_SIZE); // Verificamos que el tamaño maximo sea el predeterminado
	}
 
	@Test
	void testPush() {
		stack.push(1);
	    stack.push(2);
	    stack.push(3);
	    stack.push(4);
	    stack.push(5); 
	    assertFalse(stack.empty()); // Verificamos que la pila no este vacia despues de añadir elementos
	}
	
	@Test
	void testPushFullStack() { 
	    stack.push(1);
	    stack.push(2);
	    stack.push(3);
	    stack.push(4);
	    stack.push(5);
	    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.push(6)); // Verificamos que se lance una excepcion al intentar empujar en una pila llena
	    assertEquals("Desbordamiento de pila", exception.getMessage()); // Verificamos que el mensaje de excepcion sea el esperado
	}

	@Test
	void testPop() {
	    stack.push(1);
	    stack.push(2);
	    stack.push(3);
	    assertEquals(3, stack.pop());
	    assertEquals(2, stack.pop()); // Verificamos que el elemento eliminado sea el esperado
	    assertFalse(stack.empty()); // Verificamos que la pila no este vacia después de hacer pop
	}
	
	@Test
	void testPopEmptyStack() {
	    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.pop()); // Verificamos que se lance una excepcion al intentar hacer pop en una pila vacia
	    assertEquals("La pila está vacía", exception.getMessage()); // Verificamos que el mensaje de excepcion sea el esperado
	}

	@Test
	void testPeek() {
	    stack.push(1);
	    stack.push(2);
	    stack.push(3);
	    assertEquals(3, stack.peek()); // Verificamos que el elemento en la cima sea el esperado
	    assertFalse(stack.empty()); // Verificamos que la pila no este vacia despues de hacer peek
	} 
	
	@Test
	void testPeekEmptyStack() {
	    RuntimeException exception = assertThrows(RuntimeException.class, () -> stack.peek()); // Verificamos que se lance una excepción al intentar hacer peek en una pila vacia
	    assertEquals("La pila está vacía", exception.getMessage()); // Verificamos que el mensaje de excepcion sea el esperado
	}

	@Test
	void testEmpty() {
		assertTrue(stack.empty()); // Verificamos que la pila este vacia inicialmente 
	}

	@Test
	void testToString() {
		assertEquals("[]", stack.toString());
		stack.push(1);
		assertEquals("[1]", stack.toString());
		stack.push(2);
		assertEquals("[2, 1]", stack.toString());
	}

}
