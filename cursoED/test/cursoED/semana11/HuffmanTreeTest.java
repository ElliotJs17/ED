package cursoED.semana11;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HuffmanTreeTest {
	char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
	int[] charfreq = { 45, 13, 12, 16, 9, 5 };
	HuffmanTree h = new HuffmanTree(charArray, charfreq); 	

	@Test
	void testGetCodificadoExistentes() {
		assertEquals("0", h.getCodificado('a'));
		assertEquals("100", h.getCodificado('c'));
		assertEquals("101", h.getCodificado('b'));
		assertEquals("1100", h.getCodificado('f'));
		assertEquals("1101", h.getCodificado('e'));
		assertEquals("111", h.getCodificado('d')); 
	} 
	
	@Test
	void testGetCodificadoInexistentes() {
		assertNull(h.getCodificado('z'));
		assertNull(h.getCodificado('x'));
		assertNull(h.getCodificado('y'));
		assertNull(h.getCodificado('w'));
		assertNull(h.getCodificado('s'));
	}
	
	@Test
	void testGetDesCodificado() {
		assertEquals("abc", h.getDesCodificado("0101100"));
		assertEquals("def", h.getDesCodificado("11111011100"));
		assertEquals("fa", h.getDesCodificado("11000"));
		assertEquals("ab	d", h.getDesCodificado("0101111"));
		assertEquals("abe", h.getDesCodificado("01011101"));
		assertEquals("abf", h.getDesCodificado("01011100"));
		assertEquals("bce", h.getDesCodificado("1011001101"));
		assertEquals("cba", h.getDesCodificado("1001010"));
		assertEquals("fda", h.getDesCodificado("11001110"));
	}
	
	@Test
	void testGetDesCodificadoInvalido() {
		assertEquals("", h.getDesCodificado("11111111"));
		assertEquals("", h.getDesCodificado("000000001"));
		assertEquals("", h.getDesCodificado("12345"));
		assertEquals("", h.getDesCodificado("abcde"));
		assertEquals("", h.getDesCodificado("sadakdkasdna"));
		assertEquals("", h.getDesCodificado("1215160"));
		assertEquals("", h.getDesCodificado("/*adasd1a"));
		assertEquals("", h.getDesCodificado(""));	
	}

	@Test
	void testCodificarDecodificar() {
		String original = "abcde"; 
		String encoded = "";  
		for (char c : original.toCharArray()) {
			encoded += h.getCodificado(c);
		}
		assertEquals(original, h.getDesCodificado(encoded)); 
		
		original = "fedcba";
		encoded = "";
		for (char c : original.toCharArray()) {
			encoded += h.getCodificado(c);
		}
		assertEquals(original, h.getDesCodificado(encoded));

		original = "abacabadabacaba";
		encoded = "";
		for (char c : original.toCharArray()) {
			encoded += h.getCodificado(c);
		}
		assertEquals(original, h.getDesCodificado(encoded));
	}
}
