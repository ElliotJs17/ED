package cursoED.semana12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SplayTreeTest {

	private SplayTree tree;

    @BeforeEach
    public void setUp() {
        tree = new SplayTree();
    }

    @Test
    public void testInsertAndFind() {
    	// Verificar que buscar en un árbol vacío retorna null
        assertNull(tree.find(10));
                     	
    	// Insertar elementos
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(15);
        tree.insert(30);
        
        /*
				       10
				      /  \
				     5    20
				         /  \
				       15    30
        */

        // Verificar que se pueden encontrar correctamente
        assertEquals(10, tree.find(10));
        assertEquals(20, tree.find(20));
        assertEquals(5, tree.find(5));
        assertEquals(15, tree.find(15));
        assertEquals(30, tree.find(30));

        // Intentar insertar duplicado
        tree.insert(10);
        
        // Verificar que el duplicado no afecta la estructura
        assertEquals(10, tree.find(10));

        // Buscar elementos no existentes
        assertNull(tree.find(25));
        assertNull(tree.find(1));
    }

    @Test
    public void testFindMin() {
    	// Verificar que buscar el mínimo en un árbol vacío retorna null
        assertNull(tree.findMin());
        
        // Insertar elementos
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        
        /*
					   10
				      /  \
				     5    15
				    / \   /
				   3   7 12
        */

        // Verificar que el mínimo se encuentra correctamente
        assertEquals(3, tree.findMin());

        // Remover el mínimo actual y verificar el nuevo mínimo
        tree.remove(3);
        assertEquals(5, tree.findMin());

        // Remover todos los elementos y verificar el comportamiento en un árbol vacío
        tree.remove(10);
        tree.remove(5);
        tree.remove(15);
        tree.remove(7);
        tree.remove(12);
        assertNull(tree.findMin());
    }

    @Test
    public void testFindMax() {
    	// Verificar que buscar el máximo en un árbol vacío retorna null
        assertNull(tree.findMax());
         	
    	// Insertar elementos en orden aleatorio
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(15);
        tree.insert(30);
        tree.insert(2);
        
        /*
						   10
					      /  \
					     5    20
					    /    /  \
					   2   15   30
        */

        // Verificar que el máximo se encuentra correctamente
        assertEquals(30, tree.findMax());

        // Remover el máximo actual y verificar el nuevo máximo
        tree.remove(30);
        assertEquals(20, tree.findMax());

        // Remover todos los elementos y verificar el comportamiento en un árbol vacío
        tree.remove(10);
        tree.remove(20);
        tree.remove(5);
        tree.remove(15);
        tree.remove(2);
        assertNull(tree.findMax());
    }

    @Test
    public void testRemove() {	
    	// Insertar elementos
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(15);
        tree.insert(30);
        
        /*
						   10
					      /  \
					     5    20
					         /  \
					       15    30
        */

        // Eliminar un elemento y verificar que ya no está presente
        tree.remove(10);
        assertNull(tree.find(10));

        // Verificar que el árbol aún contiene los otros elementos
        assertEquals(20, tree.find(20));
        assertEquals(5, tree.find(5));
        assertEquals(15, tree.find(15));
        assertEquals(30, tree.find(30));

        // Intentar eliminar un elemento que no existe
        tree.remove(25);
        
        // Verificar que el árbol no se ve afectado
        assertEquals(20, tree.find(20));
        assertEquals(5, tree.find(5));
        assertEquals(15, tree.find(15));
        assertEquals(30, tree.find(30));

        // Eliminar todos los elementos y verificar que el árbol está vacío
        tree.remove(20);
        tree.remove(5);
        tree.remove(15);
        tree.remove(30);
        assertTrue(tree.isEmpty());
    }

    @Test
    public void testIsEmpty() {
    	// Verificar que el árbol está vacío inicialmente
        assertTrue(tree.isEmpty());

        // Insertar un elemento y verificar que ya no está vacío
        tree.insert(10);
        assertFalse(tree.isEmpty());

        // Eliminar el elemento y verificar que el árbol está vacío de nuevo
        tree.remove(10);
        assertTrue(tree.isEmpty());
        
        // Insertar múltiples elementos y verificar
        tree.insert(20);
        tree.insert(30);
        assertFalse(tree.isEmpty());

        // Vaciar el árbol y verificar que está vacío
        tree.remove(20);
        tree.remove(30);
        assertTrue(tree.isEmpty());
    }
}
