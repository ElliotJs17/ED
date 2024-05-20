package cursoED.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilTest {

	@Test
    void testEsPrimoConNumerosPequenos() {
        assertTrue(MathUtil.esPrimo(2));
        assertTrue(MathUtil.esPrimo(3));
        assertTrue(MathUtil.esPrimo(5));
        assertTrue(MathUtil.esPrimo(7));
        assertFalse(MathUtil.esPrimo(1));
        assertFalse(MathUtil.esPrimo(4));
        assertFalse(MathUtil.esPrimo(6));
        assertFalse(MathUtil.esPrimo(8));
    }
    
    @Test
    void testEsPrimoConNumerosMedianos() {
        assertTrue(MathUtil.esPrimo(11));
        assertTrue(MathUtil.esPrimo(13));
        assertTrue(MathUtil.esPrimo(17));
        assertTrue(MathUtil.esPrimo(19));
        assertFalse(MathUtil.esPrimo(15));
        assertFalse(MathUtil.esPrimo(21));
        assertFalse(MathUtil.esPrimo(25));
        assertFalse(MathUtil.esPrimo(27));
    }
    
    @Test
    void testEsPrimoConNumerosGrandes() {
        assertTrue(MathUtil.esPrimo(997));
        assertTrue(MathUtil.esPrimo(991));
        assertTrue(MathUtil.esPrimo(983));
        assertFalse(MathUtil.esPrimo(999));
        assertFalse(MathUtil.esPrimo(990));
        assertFalse(MathUtil.esPrimo(985));
    }
    
    @Test
    void testEsPrimoConNumerosIgualesOMenoresAUno() {
        assertFalse(MathUtil.esPrimo(0));
        assertFalse(MathUtil.esPrimo(-1));
        assertFalse(MathUtil.esPrimo(-5));
    }

}
