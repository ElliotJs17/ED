package cursoED.semana02.ejercicio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cursoED.util.Complejo;

class ArrayDeObjectosTest {

	@Test
    void testContarRepeticionConMaximaRepeticion() {
        Complejo[] datos = { new Complejo(1, 2), new Complejo(1, 2), new Complejo(1, 2) };
        Complejo dato = new Complejo(1, 2);
        assertEquals(3, ArrayDeObjectos.contarRepeticion(datos, dato));
    }

    @Test
    void testContarRepeticionConCeroRepeticion() {
        Complejo[] datos = { new Complejo(1, 2), new Complejo(3, 4), new Complejo(5, 6) };
        Complejo dato = new Complejo(7, 8);
        assertEquals(0, ArrayDeObjectos.contarRepeticion(datos, dato));
    }

    @Test
    void testContarRepeticionConRepeticionAlInicio() {
        Complejo[] datos = { new Complejo(1, 2), new Complejo(3, 4), new Complejo(1, 2) };
        Complejo dato = new Complejo(1, 2);
        assertEquals(2, ArrayDeObjectos.contarRepeticion(datos, dato));
    }

    @Test
    void testContarRepeticionConRepeticionAlFinal() {
        Complejo[] datos = { new Complejo(3, 4), new Complejo(5, 6), new Complejo(1, 2), new Complejo(1, 2) };
        Complejo dato = new Complejo(1, 2);
        assertEquals(2, ArrayDeObjectos.contarRepeticion(datos, dato));
    }

}
