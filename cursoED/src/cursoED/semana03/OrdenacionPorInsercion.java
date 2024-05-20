package cursoED.semana03;

public class OrdenacionPorInsercion {
	public static void ordenarPorInsercion(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			/*
			 * indice j es para explorar la sublista a[i-1]..a[0] buscando la posicion
			 * correcta del elemento destino
			 */
			int j = i;
			int aux = a[i];
			// se localiza el punto de inserción explorando hacia izquierda
			while (j > 0 && aux < a[j - 1]) {
				// desplazar elementos hacia derecha para hacer espacio
				a[j] = a[j - 1];
				j--;
			}
			a[j] = aux;
		}
	}
}
