package cursoED.semana02.ejercicio;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class ArrayBiDimencionalTest {

	@Test
    void testContarRepeticionConMaximaRepeticion() {
        assertEquals(3, ArrayBiDimensional.contarRepeticion(new int[][] { { 1, 1, 1 }, { 2, 2, 2 } }, 1));
    }

    @Test
    void testContarRepeticionConCeroRepeticion() {
        assertEquals(0, ArrayBiDimensional.contarRepeticion(new int[][] { { 1, 1, 1 }, { 2, 2, 2 } }, 3));
    }

    @Test
    void testContarRepeticionConRepeticionAlInicio() {
        assertEquals(1, ArrayBiDimensional.contarRepeticion(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, 1));
    }

    @Test
    void testContarRepeticionConRepeticionAlFinal() {
        assertEquals(2, ArrayBiDimensional.contarRepeticion(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 3 } }, 3));
    }

    @Test
    void testContarNumerosPrimos() {
        assertEquals(3, ArrayBiDimensional.contarNumerosPrimos(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }));
        assertEquals(3, ArrayBiDimensional.contarNumerosPrimos(new int[][] { { 10, 11, 12, 13 }, { 14, 15, 16, 17 } }));
    }

    @Test
    void testContarNumerosPrimosConNingunNumeroPrimo() {
        assertEquals(0, ArrayBiDimensional.contarNumerosPrimos(new int[][] { { 4, 6, 8 }, { 9, 10, 12 } }));
    }

}
