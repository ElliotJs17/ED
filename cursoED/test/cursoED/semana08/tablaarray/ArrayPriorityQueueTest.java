package cursoED.semana08.tablaarray;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.Test;

import cursoED.semana07.comun.PriorityQueue;

class ArrayPriorityQueueTest {

	PriorityQueue<Estudiante> pq = new ArrayPriorityQueue<>(3);

	@Test
	void testOffer() {
		assertThrows(NullPointerException.class, () -> pq.offer(null));
		assertFalse(pq.offer(new Estudiante("21000001", "Perez", "Juan", 17.5F, 4)));
		assertTrue(pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0)));
		assertTrue(pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1)));
		assertTrue(pq.offer(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3)));
		assertTrue(pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 0)));
		assertTrue(pq.offer(new Estudiante("21000005", "Elias", "Eva", 17.5F, 1)));
		assertEquals("[21000001, 21000004][21000002, 21000005][][21000003]", pq.toString());
	}

	@Test
	void testPoll() {
	    assertNull(pq.poll()); // La cola está vacía, debería devolver null

	    // Agregamos muchos estudiantes
	    pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0));
	    pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1));
	    pq.offer(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3));
	    pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 2));
	    pq.offer(new Estudiante("21000005", "Esteban", "Elena", 17.5F, 0));
	    pq.offer(new Estudiante("21000006", "Fernandez", "Fabian", 17.5F, 1));
	    pq.offer(new Estudiante("21000007", "Garcia", "Gabriela", 17.5F, 3));
	    pq.offer(new Estudiante("21000008", "Hernandez", "Hugo", 17.5F, 2));
	    pq.offer(new Estudiante("21000009", "Iglesias", "Irene", 17.5F, 0));
	    pq.offer(new Estudiante("21000010", "Jimenez", "Javier", 17.5F, 1));
	    pq.offer(new Estudiante("21000011", "Kaiser", "Karen", 17.5F, 3));
	    pq.offer(new Estudiante("21000012", "Lopez", "Luis", 17.5F, 2));
	    pq.offer(new Estudiante("21000013", "Martinez", "Marta", 17.5F, 0));
	    pq.offer(new Estudiante("21000014", "Navarro", "Nestor", 17.5F, 1));
	    pq.offer(new Estudiante("21000015", "Ortega", "Olga", 17.5F, 3));
	    pq.offer(new Estudiante("21000016", "Perez", "Pablo", 17.5F, 2));
	    pq.offer(new Estudiante("21000017", "Quintero", "Queta", 17.5F, 0));
	    pq.offer(new Estudiante("21000018", "Ramirez", "Ricardo", 17.5F, 1));
	    pq.offer(new Estudiante("21000019", "Sanchez", "Sofia", 17.5F, 3));
	    pq.offer(new Estudiante("21000020", "Torres", "Tomás", 17.5F, 2));

	    // Verificamos la extracción en el orden correcto
	    assertEquals("21000001", pq.poll().getCodigo()); // Priority 0
	    assertEquals("21000005", pq.poll().getCodigo()); // Priority 0
	    assertEquals("21000009", pq.poll().getCodigo()); // Priority 0
	    assertEquals("21000013", pq.poll().getCodigo()); // Priority 0
	    assertEquals("21000017", pq.poll().getCodigo()); // Priority 0

	    assertEquals("21000002", pq.poll().getCodigo()); // Priority 1
	    assertEquals("21000006", pq.poll().getCodigo()); // Priority 1
	    assertEquals("21000010", pq.poll().getCodigo()); // Priority 1
	    assertEquals("21000014", pq.poll().getCodigo()); // Priority 1
	    assertEquals("21000018", pq.poll().getCodigo()); // Priority 1

	    assertEquals("21000004", pq.poll().getCodigo()); // Priority 2
	    assertEquals("21000008", pq.poll().getCodigo()); // Priority 2
	    assertEquals("21000012", pq.poll().getCodigo()); // Priority 2
	    assertEquals("21000016", pq.poll().getCodigo()); // Priority 2
	    assertEquals("21000020", pq.poll().getCodigo()); // Priority 2

	    assertEquals("21000003", pq.poll().getCodigo()); // Priority 3
	    assertEquals("21000007", pq.poll().getCodigo()); // Priority 3
	    assertEquals("21000011", pq.poll().getCodigo()); // Priority 3
	    assertEquals("21000015", pq.poll().getCodigo()); // Priority 3
	    assertEquals("21000019", pq.poll().getCodigo()); // Priority 3 

	    assertNull(pq.poll()); // La cola ahora está vacía, debería devolver null
	}

	@Test
	void testPeek() {
	    assertNull(pq.peek()); // La cola está vacía, debería devolver null

	    // Agregamos muchos estudiantes
	    pq.offer(new Estudiante("21000001", "Arias", "Alex", 17.5F, 0));
	    pq.offer(new Estudiante("21000002", "Bellido", "Betty", 17.5F, 1));
	    pq.offer(new Estudiante("21000003", "Casas", "Carlos", 17.5F, 3));
	    pq.offer(new Estudiante("21000004", "Diaz", "Diana", 17.5F, 2));
	    pq.offer(new Estudiante("21000005", "Esteban", "Elena", 17.5F, 0));
	    pq.offer(new Estudiante("21000006", "Fernandez", "Fabian", 17.5F, 1));
	    pq.offer(new Estudiante("21000007", "Garcia", "Gabriela", 17.5F, 3));
	    pq.offer(new Estudiante("21000008", "Hernandez", "Hugo", 17.5F, 2));
	    pq.offer(new Estudiante("21000009", "Iglesias", "Irene", 17.5F, 0));
	    pq.offer(new Estudiante("21000010", "Jimenez", "Javier", 17.5F, 1));
	    pq.offer(new Estudiante("21000011", "Kaiser", "Karen", 17.5F, 3));
	    pq.offer(new Estudiante("21000012", "Lopez", "Luis", 17.5F, 2));
	    pq.offer(new Estudiante("21000013", "Martinez", "Marta", 17.5F, 0));
	    pq.offer(new Estudiante("21000014", "Navarro", "Nestor", 17.5F, 1));
	    pq.offer(new Estudiante("21000015", "Ortega", "Olga", 17.5F, 3));
	    pq.offer(new Estudiante("21000016", "Perez", "Pablo", 17.5F, 2));
	    pq.offer(new Estudiante("21000017", "Quintero", "Queta", 17.5F, 0));
	    pq.offer(new Estudiante("21000018", "Ramirez", "Ricardo", 17.5F, 1));
	    pq.offer(new Estudiante("21000019", "Sanchez", "Sofia", 17.5F, 3));
	    pq.offer(new Estudiante("21000020", "Torres", "Tomás", 17.5F, 2));

	    // Verificamos que el estudiante con mayor prioridad es siempre el mismo hasta que se remueve
	    assertEquals("21000001", pq.peek().getCodigo()); // Priority 0
	    assertEquals("21000001", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000001
	    assertEquals("21000005", pq.peek().getCodigo()); // Priority 0
	    assertEquals("21000005", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000005
	    assertEquals("21000009", pq.peek().getCodigo()); // Priority 0
	    assertEquals("21000009", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000009
	    assertEquals("21000013", pq.peek().getCodigo()); // Priority 0
	    assertEquals("21000013", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000013
	    assertEquals("21000017", pq.peek().getCodigo()); // Priority 0
	    assertEquals("21000017", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000017
	    assertEquals("21000002", pq.peek().getCodigo()); // Priority 1
	    assertEquals("21000002", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000002
	    assertEquals("21000006", pq.peek().getCodigo()); // Priority 1
	    assertEquals("21000006", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000006
	    assertEquals("21000010", pq.peek().getCodigo()); // Priority 1
	    assertEquals("21000010", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000010
	    assertEquals("21000014", pq.peek().getCodigo()); // Priority 1
	    assertEquals("21000014", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000014
	    assertEquals("21000018", pq.peek().getCodigo()); // Priority 1
	    assertEquals("21000018", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000018
	    assertEquals("21000004", pq.peek().getCodigo()); // Priority 2
	    assertEquals("21000004", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000004
	    assertEquals("21000008", pq.peek().getCodigo()); // Priority 2
	    assertEquals("21000008", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000008
	    assertEquals("21000012", pq.peek().getCodigo()); // Priority 2
	    assertEquals("21000012", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000012
	    assertEquals("21000016", pq.peek().getCodigo()); // Priority 2
	    assertEquals("21000016", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000016
	    assertEquals("21000020", pq.peek().getCodigo()); // Priority 2
	    assertEquals("21000020", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000020
	    assertEquals("21000003", pq.peek().getCodigo()); // Priority 3
	    assertEquals("21000003", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000003
	    assertEquals("21000007", pq.peek().getCodigo()); // Priority 3
	    assertEquals("21000007", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000007
	    assertEquals("21000011", pq.peek().getCodigo()); // Priority 3
	    assertEquals("21000011", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000011
	    assertEquals("21000015", pq.peek().getCodigo()); // Priority 3
	    assertEquals("21000015", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000015
	    assertEquals("21000019", pq.peek().getCodigo()); // Priority 3
	    assertEquals("21000019", pq.peek().getCodigo()); // Debería seguir siendo el mismo

	    pq.poll(); // Remove 21000019
	    assertNull(pq.peek()); // La cola ahora está vacía, debería devolver null
	}

}
