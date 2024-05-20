package cursoED.semana03;

public class BusquedaSecuencial {
	public static int buscaSecuencial(int[] a, int clave) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == clave) {
				return i; 
			}
		}
		return -1; 
	}
}