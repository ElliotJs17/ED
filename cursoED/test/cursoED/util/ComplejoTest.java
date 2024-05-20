package cursoED.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComplejoTest {

	@Test
    void testEquals() {
        Complejo c1 = new Complejo(3.5, 2.5);
        Complejo c2 = new Complejo(3.5, 2.5);
        Complejo c3 = new Complejo(3.6, 2.6);
        Complejo c4 = new Complejo(3.5000001, 2.5000001); // Contenidos ligeramente diferentes pero deberían ser considerados iguales
        
        // Prueba de igualdad entre c1 y c2
        assertTrue(c1.equals(c2));
        
        // Prueba de igualdad con un objeto idéntico a c1
        assertTrue(c1.equals(c1));
        
        // Prueba de igualdad entre c1 y c3, con una pequeña diferencia
        assertFalse(c1.equals(c3));
        
        // Prueba de igualdad entre c1 y c4, con una pequeña diferencia
        assertTrue(c1.equals(c4)); // Ahora esperamos que esta comparación sea verdadera
        
        // Prueba de igualdad con un objeto nulo
        assertFalse(c1.equals(null));
        
        // Prueba de igualdad con un objeto de otra clase
        assertFalse(c1.equals("No es un Complejo"));
    }
    
    @Test
    void testHashCode() {
        Complejo c1 = new Complejo(3.5, 2.5);
        Complejo c2 = new Complejo(3.5, 2.5);
        Complejo c3 = new Complejo(3.6, 2.6);

        // Verifica que el hash code sea igual para objetos iguales
        assertEquals(c1.hashCode(), c2.hashCode());
        
        // Verifica que el hash code sea diferente para objetos con contenidos diferentes
        assertNotEquals(c1.hashCode(), c3.hashCode());
    }
    
    @Test
    void testToString() {
        Complejo c1 = new Complejo(3.5, 2.5);
        
        // Verifica que el método toString() retorne el formato esperado
        assertEquals("3.50+2.50i", c1.toString());
    }
}
