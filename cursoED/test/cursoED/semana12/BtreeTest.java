package cursoED.semana12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BtreeTest {
	Btree tree = new Btree(3); // Crear un árbol B con un grado mínimo de 3

	@Test
    public void testInsertAndSearch() {        
        // Insertar algunas claves
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        
        // Realizar pruebas de búsqueda
        assertNotNull(tree.search(10)); // La clave 10 debe estar presente
        assertNotNull(tree.search(20)); // La clave 20 debe estar presente
        assertNull(tree.search(15));    // La clave 15 no debe estar presente
    }

    @Test
    public void testTraversal() {
        // Insertar algunas claves
        tree.insert(10);
        tree.insert(20);
        tree.insert(5);
        tree.insert(6);
        tree.insert(12);
        tree.insert(30);
        
        // Realizar prueba de recorrido
        // Este método simplemente imprimirá el recorrido en la consola para su verificación manual
        tree.traverse();
    }
    
    @Test
    public void testInsertionWithManyKeys() {
        // Insertar una gran cantidad de claves
        for (int i = 1; i <= 100; i++) {
            tree.insert(i);
        }
        
        // Realizar pruebas de búsqueda
        for (int i = 1; i <= 100; i++) {
            assertNotNull(tree.search(i)); // Todas las claves insertadas deben estar presentes
        }
    }
    
    @Test
    public void testSearchWithEmptyTree() {
        // Realizar prueba de búsqueda en un árbol vacío
        assertNull(tree.search(10)); // La búsqueda en un árbol vacío debe devolver null
    }
}
