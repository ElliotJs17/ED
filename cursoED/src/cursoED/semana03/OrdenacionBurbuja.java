package cursoED.semana03;

import java.util.List;

public class OrdenacionBurbuja {
	public static <T extends Comparable<T>> void burbuja(List<T> lista) {
		boolean interruptor = true;
		int pasada, j;
		int n = lista.size();
		// bucle externo controla la cantidad de pasadas
		for (pasada = 0; pasada < n - 1 && interruptor; pasada++) {
			interruptor = false;
			for (j = 0; j < n - pasada - 1; j++) {
				T elem = lista.get(j);
				if (elem.compareTo(lista.get(j + 1)) > 0) {
					// elementos desordenados, se intercambian
					interruptor = true;
					intercambiar(lista, j, j + 1);
				}
			}
		}
	}

	private static <T> void intercambiar(List<T> lista, int j, int i) {
		T temp = lista.get(j);
		lista.set(j, lista.get(i));
		lista.set(i, temp);
	}
}
