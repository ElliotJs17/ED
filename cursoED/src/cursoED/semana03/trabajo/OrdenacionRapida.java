package cursoED.semana03.trabajo;

import java.util.ArrayList;
import java.util.List;

public class OrdenacionRapida {
	public static <T extends Comparable<T>> void quickSort(List<T> lista) {
		quickSort(lista, 0, lista.size() - 1);
	}

	private static <T extends Comparable<T>> void quickSort(List<T> lista, int primero, int ultimo) {
		int i, j, central;
		T pivote;
		central = (primero + ultimo) / 2;
		pivote = lista.get(central);
		i = primero;
		j = ultimo;
		do {
			while (lista.get(i).compareTo(pivote) < 0)
				i++;
			while (lista.get(j).compareTo(pivote) > 0)
				j--;
			if (i <= j) {
				intercambiar(lista, i, j);
				i++;
				j--;
			}
		} while (i <= j);
		if (primero < j)
			quickSort(lista, primero, j); // mismo proceso con sublista izqda
		if (i < ultimo)
			quickSort(lista, i, ultimo); // mismo proceso con sublista drcha
	}

	private static <T extends Comparable<T>> void intercambiar(List<T> lista, int i, int j) {
		T temp = lista.get(i);
		lista.set(i, lista.get(j));
		lista.set(j, temp);
	}

	private static void demo() {
		List<Integer> lista = new ArrayList<>(List.of(5, 3, 7, 2, 8, 1, 6, 4)); // Crear una lista mutable
		quickSort(lista);
		System.out.println(lista);
	}

	public static void main(String[] args) {
		demo();

	}

}
