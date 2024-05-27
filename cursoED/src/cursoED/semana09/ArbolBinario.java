package cursoED.semana09;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ArbolBinario<T> {
	protected Nodo<T> raiz;

	public ArbolBinario(Nodo<T> raiz) {
		this.raiz = raiz;
	}

	public ArbolBinario() {
		this(null);
	}

	public Nodo<T> getRaiz() {
		return raiz;
	}

	boolean esVacio() {
		return raiz == null;
	}

	public static <T> void preorden(Nodo<T> r) {
		if (r != null) {
			procesar(r);
			preorden(r.getIzdo());
			preorden(r.getDcho());
		}
	}

	// Recorrido Inorden
	public static <T> void inorden(Nodo<T> r) {
		if (r != null) {
			inorden(r.getIzdo());
			procesar(r);
			inorden(r.getDcho());
		}
	}

	// Recorrido Postorden
	public static <T> void postorden(Nodo<T> r) {
		if (r != null) {
			postorden(r.getIzdo());
			postorden(r.getDcho());
			procesar(r);
		}
	}

	private static <T> void procesar(Nodo<T> n) {
		System.out.print(n.getDato() + " ");
	}

	public void preorden() {
		preorden(this.getRaiz());
	}

	public void inorden() {
		inorden(this.getRaiz());
	}

	public void postorden() {
		postorden(this.getRaiz());
	}

	// Métodos auxiliares privados para acumulación de resultados
	private void preorden(Nodo<T> r, List<T> result) {
		if (r != null) {
			result.add(r.getDato());
			preorden(r.getIzdo(), result);
			preorden(r.getDcho(), result);
		}
	}

	private void inorden(Nodo<T> r, List<T> result) {
		if (r != null) {
			inorden(r.getIzdo(), result);
			result.add(r.getDato());
			inorden(r.getDcho(), result);
		}
	}

	private void postorden(Nodo<T> r, List<T> result) {
		if (r != null) {
			postorden(r.getIzdo(), result);
			postorden(r.getDcho(), result);
			result.add(r.getDato());
		}
	}

	// Métodos públicos que devuelven los recorridos como cadenas
	public String preordenStr() {
		List<T> result = new ArrayList<>();
		preorden(this.getRaiz(), result);
		return String.join(", ", result.stream().map(Object::toString).toArray(String[]::new));
	}

	public String inordenStr() {
		List<T> result = new ArrayList<>();
		inorden(this.getRaiz(), result);
		return String.join(", ", result.stream().map(Object::toString).toArray(String[]::new));
	}

	public String postordenStr() {
		List<T> result = new ArrayList<>();
		postorden(this.getRaiz(), result);
		return String.join(", ", result.stream().map(Object::toString).toArray(String[]::new));
	}

	public int altura() {
		return altura(this.raiz);
	}

	private int altura(Nodo<T> nodo) {
		if (nodo == null) {
			return 0;
		} else {
			int alturaIzquierda = altura(nodo.getIzdo());
			int alturaDerecha = altura(nodo.getDcho());
			return Math.max(alturaIzquierda, alturaDerecha) + 1;
		}
	}
}
