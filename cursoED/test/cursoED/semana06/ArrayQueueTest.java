package cursoED.semana06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayQueueTest {

	Queue<Integer> q = new ArrayQueue<Integer>(5);

	@Test
	void testConstructorMpArg() {
		Queue<Integer> q = new ArrayQueue<Integer>();
		assertTrue(q.isEmpty());
	}

	@Test
	void testOfferDentroDeLaCapacidad() {
		assertTrue(q.offer(10));
		assertTrue(q.offer(20));
		assertTrue(q.offer(30));
		assertTrue(q.offer(40));
		assertTrue(q.offer(50));
	}

	@Test
	void testOfferExcediendoLaCapacidad() {
		q.offer(10);
		q.offer(20);
		q.offer(30);
		q.offer(40);
		q.offer(50);
		assertFalse(q.offer(60));
	}

	@Test
	void testOfferConUnValorNull() {
		assertThrows(NullPointerException.class, () -> q.offer(null));
	}

	@Test
	void testPoll() {
		q.offer(10);
		q.offer(20);
		q.offer(30);
		assertEquals(10, q.poll());
		assertEquals(20, q.poll());
		assertEquals(30, q.poll());
	}

	@Test
	void testPollConUnaColaVacia() {
		assertEquals(null, q.poll());
	}

	@Test
	void testPeek() {
		q.offer(10);
		q.offer(20);
		assertEquals(10, q.peek());
		assertEquals(10, q.peek());
	}

	@Test
	void testPeekConUnaColaVacia() {
		assertEquals(null, q.peek());
	}

	@Test
	void testIsEmptyUnaColaRecienCreadaEsVacio() {
		assertTrue(q.isEmpty());
	}

	@Test
	void testIsEmptyUnaColaConAlgunosElementosNoEsVacio() {
		q.offer(10);
		q.offer(20);
		q.offer(30);
		assertFalse(q.isEmpty());
	}

}
