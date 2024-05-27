package cursoED.semana10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArbolAvlTest {

	@Test
	void testInsertarElementoRaiz() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(100, raiz.getDato());
		assertEquals(0, raiz.fe);
		asegurarQueEsUnaHoja(raiz);
	}

	private void asegurarQueEsUnaHoja(NodoAvl<Integer> nodo) {
		assertNull(nodo.getIzdo());
		assertNull(nodo.getDcho());
	}

	@Test
	void testInsertarClaveRepetida() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		assertThrows(RuntimeException.class, () -> a.insertar(100)); 
	}

	@Test
	void testInsertarSeisElementoPorLaDerecha() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(120);
		a.insertar(140);
		a.insertar(160);
		a.insertar(180);
		a.insertar(190);

		// Resultara:
		// 160
		// / \
		// 120 180
		// / \ \
		// 100 140 190

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(160, raiz.getDato());
		assertEquals(0, raiz.fe);
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(180, nodo.getDato());
		assertEquals(1, nodo.fe);
		assertNull(nodo.getIzdo());
		nodo = (NodoAvl<Integer>) nodo.getDcho();
		assertEquals(190, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		NodoAvl<Integer> nodo120 = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(120, nodo120.getDato());
		assertEquals(0, nodo120.fe);
		nodo = (NodoAvl<Integer>) nodo120.getIzdo();
		assertEquals(100, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		nodo = (NodoAvl<Integer>) nodo120.getDcho();
		assertEquals(140, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
	}
	
	@Test
	void testInsertarSeisElementoPorLaIzquierda() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(80);
		a.insertar(60);
		a.insertar(40);
		a.insertar(20);
		a.insertar(10);
		//Inicialmente:
		//
		//	   80
		//    / \
		//   40 100	
		//  / \		
		// 20 60	
		// /
		//10
		//Resultara:
		//    40
		//   / \
		//  20 80	
		// /   / \	
		//10  60 100

		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(40, raiz.getDato());
		assertEquals(0, raiz.fe);
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(20, nodo.getDato());
		assertEquals(-1, nodo.fe);
		assertNull(nodo.getDcho());
		nodo = (NodoAvl<Integer>) nodo.getIzdo();
		assertEquals(10, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		NodoAvl<Integer> nodo80 = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(80, nodo80.getDato());
		assertEquals(0, nodo80.fe);
		nodo = (NodoAvl<Integer>) nodo80.getIzdo();
		assertEquals(60, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		nodo = (NodoAvl<Integer>) nodo80.getDcho();
		assertEquals(100, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
	}
	
	@Test
	void testInsertarDosElementoRaizIzquirdo() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(50);
		/**
		 *  100
		 *   /
		 *  50
		 */
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(100, raiz.getDato());
		assertEquals(-1, raiz.fe);
		assertNull(raiz.getDcho());
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(50, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
	}
	
	@Test
	void testInsertarTresElementoRaizIzquirdoDrcho() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(50);
		a.insertar(150);
		/*
		 *  100
		 *  / \
		 * 50 150
		 */
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(100, raiz.getDato());
		assertEquals(0, raiz.fe);
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(50, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(150, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
	}
	
	@Test
	void testInsertarTresElementoRII() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(80);
		a.insertar(60);
		/*
		 *    100      80
		 *     /       /\
		 *    80   => 60 100
		 *    /
		 *   60
		 */
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(80, raiz.getDato());
		assertEquals(0, raiz.fe);
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(60, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(100, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
	}
	
	@Test
	void testInsertarTresElementoRDD() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(120);
		a.insertar(140);
		/*
		 *    100           120
		 *     \             /\
		 *     120     =>  100 140
		 *       \
		 *       140
		 */
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(120, raiz.getDato());
		assertEquals(0, raiz.fe);
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(100, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(140, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
	}
	
	@Test
	void testInsertarTresElementoRID() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(80);
		a.insertar(90);
		/*
		 *      100       90
		 *       /        /\
		 *      80    => 80 100
		 *       \
		 *       90
		 */
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(90, raiz.getDato());
		assertEquals(0, raiz.fe);
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(80, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(100, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
	}
	
	@Test
	void testInsertarTresElementoRDI() {
		/*
		 *      100       	  110
		 *        \       	   /\
		 *        120    => 100 120
		 *        /
		 *      110
		 */
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(100);
		a.insertar(120);
		a.insertar(110);
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(110, raiz.getDato());
		assertEquals(0, raiz.fe);
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(100, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo);
		nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(120, nodo.getDato());
		assertEquals(0, nodo.fe);
		asegurarQueEsUnaHoja(nodo); 
	}
	
	@Test
	void testInsertarElementoDerechoIzquierdo_n2feMenos1() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(20);
		a.insertar(3);
		a.insertar(30);
		a.insertar(25);
		a.insertar(24);
		a.insertar(23);

		/*
					  20
					 /  \
					3   30
					    /
					   25
					  /
					 24
					/
				   23
				   
		Resultara:		   
				      24
				     /  \
				   20   25
				  / \     \
				 3  23    30
		 */
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(24, raiz.getDato());
		assertEquals(0, raiz.fe);
		assertNotNull(raiz.getIzdo());
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(20, nodo.getDato());
		assertEquals(0, nodo.fe);
		NodoAvl<Integer> nodo2 = (NodoAvl<Integer>) nodo.getIzdo();
		assertEquals(3, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
		nodo2 = (NodoAvl<Integer>) nodo.getDcho();
		assertEquals(23, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
		nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(25, nodo.getDato());
		assertEquals(1, nodo.fe);
		nodo2 = (NodoAvl<Integer>) nodo.getDcho();
		assertEquals(30, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);	
	}
	
	@Test
	void testInsertarElementoDerechoIzquierdo_n2feMas1() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(20);
		a.insertar(3);
		a.insertar(30);
		a.insertar(25);
		a.insertar(23);
		a.insertar(24);
		/*
		 		  20
				 /  \
				3   30
				    /
				   25
				  /
				 23
				   \
				   24
	   
		Resultara:		   
			      23
			     /  \
			   20   25
			  / \     \
			 3  24    30
		*/
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(23, raiz.getDato());
		assertEquals(0, raiz.fe);
		assertNotNull(raiz.getIzdo());
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(20, nodo.getDato());
		assertEquals(-1, nodo.fe);
		NodoAvl<Integer> nodo2 = (NodoAvl<Integer>) nodo.getIzdo();
		assertEquals(3, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
		nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(25, nodo.getDato());
		assertEquals(0, nodo.fe);
		nodo2 = (NodoAvl<Integer>) nodo.getIzdo();
		assertEquals(24, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
		nodo2 = (NodoAvl<Integer>) nodo.getDcho();
		assertEquals(30, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
	}
	
	@Test
	void testInsertarElementoIzquierdoDerecho_n2feMas1() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(20);
		a.insertar(4);
		a.insertar(30);
		a.insertar(5);
		a.insertar(3);
		a.insertar(7);
		/*
					   20
					  /  \
					 4   30
					/ \
					3  5
					    \
					     7

		Resultara:		   
				           5
					     /  \
					    4    20
					   /    /  \
					  3    7    30
		*/
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(5, raiz.getDato());
		assertEquals(0, raiz.fe);
		assertNotNull(raiz.getIzdo());
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(4, nodo.getDato());
		assertEquals(-1, nodo.fe);
		NodoAvl<Integer> nodo2 = (NodoAvl<Integer>) nodo.getIzdo();
		assertEquals(3, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
		nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(20, nodo.getDato());
		assertEquals(0, nodo.fe);
		nodo2 = (NodoAvl<Integer>) nodo.getIzdo();
		assertEquals(7, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
		nodo2 = (NodoAvl<Integer>) nodo.getDcho();
		assertEquals(30, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
	}
	
	@Test	
	void testInsertarElementoIzquierdoDerecho_n2feMenos1() {
		ArbolAvl<Integer> a = new ArbolAvl<>();
		a.insertar(20);
		a.insertar(3);
		a.insertar(30);
		a.insertar(6);
		a.insertar(4);
		a.insertar(5);
		/*
						  20
						 /  \
						3   30
						   /
						  6
						 / \
						4   5	

		Resultara:		   
				            6
						   / \
						  4   20
						 / \    \
						3   5 	 30
						  
*/
		NodoAvl<Integer> raiz = a.getRaiz();
		assertEquals(6, raiz.getDato());
		assertEquals(0, raiz.fe);
		assertNotNull(raiz.getIzdo());
		NodoAvl<Integer> nodo = (NodoAvl<Integer>) raiz.getIzdo();
		assertEquals(4, nodo.getDato());
		assertEquals(0, nodo.fe);
		NodoAvl<Integer> nodo2 = (NodoAvl<Integer>) nodo.getIzdo();
		assertEquals(3, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
		nodo2 = (NodoAvl<Integer>) nodo.getDcho();
		assertEquals(5, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
		nodo = (NodoAvl<Integer>) raiz.getDcho();
		assertEquals(20, nodo.getDato());
		assertEquals(1, nodo.fe);
		nodo2 = (NodoAvl<Integer>) nodo.getDcho();
		assertEquals(30, nodo2.getDato());
		assertEquals(0, nodo2.fe);
		asegurarQueEsUnaHoja(nodo2);
	}	
}
