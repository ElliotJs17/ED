package cursoED.semana03.trabajo;

public class OrdenacionBurbuja {
	public static void burbuja(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					// intercambiar a[j] y a[j+1]
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	private static void demo() {
		int[] array = { 64, 34, 25, 12, 22, 11, 90 };
		System.out.println("Array original:");

		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

		burbuja(array);

		System.out.println("\nArray ordenado:");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		demo();
	}

}
