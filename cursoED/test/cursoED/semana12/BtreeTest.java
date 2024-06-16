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
        assertNotNull(tree.root.search(10)); // Verificar que la clave 10 está presente
        assertNotNull(tree.root.search(20)); // Verificar que la clave 20 está presente
        assertNull(tree.root.search(15));    // Verificar que la clave 15 no está presente
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
