package cursoED.semana03;

public class BusquedaBinaria {
	public static int busquedaBinaria(int a[], int clave) {
		int central, bajo, alto;
		int valorCentral;
		bajo = 0;
		alto = a.length - 1;
		while (bajo <= alto) {
			central = (bajo + alto) / 2; // índice de elemento central
			valorCentral = a[central]; // valor del índice central
			if (clave == valorCentral)
				return central; // encontrado, devuelve posición
			else if (clave < valorCentral)
				alto = central - 1; // ir a sublista inferior
			else
				bajo = central + 1; // ir a sublista superior

		}
		return -1; // elemento no encontrado
	}
}
