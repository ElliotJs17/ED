package cursoED.semana03;

public class OrdenacionShell {
	public static void ordenarShell(int[] a) {
		int n = a.length;
		int intervalo, i, j, k;
		intervalo = n / 2;
		while (intervalo > 0) {
			for (i = intervalo; i < n; i++) {
				j = i - intervalo;
				while (j >= 0) {
					k = j + intervalo;
					if (a[j] <= a[k])
						j = -1; // par de elementos ordenado
					else {
						intercambiar(a, j, k); // ERRATA j, j+1
						j -= intervalo;
					}
				}
			}
			intervalo = intervalo / 2;
		}
	}

	private static void intercambiar(int[] a, int i, int j) {
		int aux = a[i];
		a[i] = a[j];
		a[j] = aux;
	}
}
