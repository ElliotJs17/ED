package cursoED.semana12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SplayTreeTest {
  
    @Test
    public void testInsert() {
        SplayTree tree = new SplayTree();
        
     // Verificar que buscar en un árbol vacío retorna null
        assertNull(tree.find(10));

        // Insertar elementos
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);

        // Verificar nodos izquierdo y derecho después de la inserción
        assertEquals(7, tree.root.key); // Verifica la clave en la raíz
        assertEquals(5, tree.root.left.key); // Verifica la clave del nodo izquierdo de la raíz
        assertEquals(10, tree.root.right.key); // Verifica la clave del nodo derecho de la raíz
        assertEquals(3, tree.root.left.left.key); // Verifica la clave del nodo izquierdo de '5'
        assertEquals(15, tree.root.right.right.key); // Verifica la clave del nodo derecho de '15'
    }
    
    @Test
    public void testRemove() {
        SplayTree tree = new SplayTree();
        
     // Verificar que buscar en un árbol vacío retorna null
        assertNull(tree.find(10));

        // Insertar elementos
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);

        // Eliminar elementos
        tree.remove(3);
        assertEquals(5, tree.findMin());

        tree.remove(15);
        assertEquals(10, tree.findMax()); 

        // Verificar nodos izquierdo y derecho después de la eliminación
        assertEquals(10, tree.root.key); // Verifica la clave en la raíz
        assertEquals(7, tree.root.left.key); // Nodo izquierdo del nodo raíz después de eliminar 3
        assertEquals(5, tree.root.left.left.key); // Nodo derecho del nodo raíz después de eliminar 15
    }
    
    @Test
    public void testFindMinAndMax() {
        SplayTree tree = new SplayTree();
        
        // Verificar que buscar el máximo en un árbol vacío retorna null
        assertNull(tree.findMax());
        
        // Verificar que buscar el mínimo en un árbol vacío retorna null
        assertNull(tree.findMin());

        // Insertar elementos
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);

        // Verificar mínimo y máximo
        assertEquals(3, tree.findMin());
        assertEquals(15, tree.findMax());

        // Verificar nodos izquierdo y derecho después de buscar mínimo y máximo
        assertEquals(15, tree.root.key); // Verifica la clave en la raíz
        assertEquals(5, tree.root.left.key); // Nodo izquierdo del nodo raíz después de buscar mínimo
        assertEquals(3, tree.root.left.left.key); // Nodo derecho del nodo raíz después de buscar máximo
        assertEquals(10, tree.root.left.right.key); // Nodo derecho del nodo raíz después de buscar máximo
        assertEquals(7, tree.root.left.right.left.key); // Nodo derecho del nodo raíz después de buscar máximo
    }
    
    @Test
    public void testSplay() {
        SplayTree tree = new SplayTree();

        // Insertar elementos
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);

        // Realizar una búsqueda para activar splay
        tree.find(5);
        assertEquals(5, tree.find(5)); // Verificar que el nodo 5 está en la raíz después del splay

        // Verificar nodos izquierdo y derecho después de splay
        assertEquals(3, tree.root.left.key); // Nodo izquierdo del nodo raíz después del splay de 5
        assertEquals(7, tree.root.right.key); // Nodo derecho del nodo raíz después del splay de 5
    }
    
    @Test
    public void testEmptyTree() {
        SplayTree tree = new SplayTree();

        // Verificar que el árbol esté vacío inicialmente
        assertTrue(tree.isEmpty());

        // Insertar y verificar que el árbol ya no está vacío
        tree.insert(10);
        assertFalse(tree.isEmpty());

        // Verificar nodos izquierdo y derecho después de insertar
        assertNull(tree.root.left); // No hay nodo izquierdo del nodo raíz
        assertNull(tree.root.right); // No hay nodo derecho del nodo raíz
    }
}
