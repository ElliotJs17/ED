package cursoED.semana03;

public class OrdenacionRapida {
	public static void quickSort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private static void quickSort(int[] a, int primero, int ultimo) {
		int i, j, central;
		double pivote;
		central = (primero + ultimo) / 2;
		pivote = a[central];
		i = primero;
		j = ultimo;
		do {
			while (a[i] < pivote)
				i++;
			while (a[j] > pivote)
				j--;
			if (i <= j) {
				intercambiar(a, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (primero < j)
			quickSort(a, primero, j); // mismo proceso con sublista izqda
		if (i < ultimo)
			quickSort(a, i, ultimo); // mismo proceso con sublista drcha

	}
	
	private static void intercambiar(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
}
