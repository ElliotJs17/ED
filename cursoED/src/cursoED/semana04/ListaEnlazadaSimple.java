package cursoED.semana04;

public class ListaEnlazadaSimple<E> implements Lista<E> {
	private int tamanyo = 0;
	private Nodo<E> primero;
	private Nodo<E> ultimo;

	private class Nodo<E> {
		E item;
		Nodo<E> sgte;

		Nodo(E element, Nodo<E> sgte) {
			this.item = element;
			this.sgte = sgte;
		}
	}

	@Override
	public int tamanyo() {
		return tamanyo;
	}

	@Override
	public boolean esVacio() {
		return tamanyo == 0;
	}

	@Override
	public boolean contiene(Object o) { 
		return indiceDe(o) >= 0;
	}

	@Override
	public void agregar(E e) {
		final Nodo<E> u = ultimo;
		final Nodo<E> nuevoNodo = new Nodo<>(e, null);
		ultimo = nuevoNodo;
		if (u == null)
			primero = nuevoNodo;
		else
			u.sgte = nuevoNodo;
		tamanyo++;

	}

	@Override
	public void agregar(int index, E element) {
		validarAgregarIndice(index);
		if (index == tamanyo)
			agregar(element);
		else if (index == 0)
			linkearPrimero(element);
		else
			linkearMedio(element, index);
	}

	private void validarAgregarIndice(int index) {
		if (!(index >= 0 && index <= tamanyo))
			throw new IndexOutOfBoundsException("indice: " + index + ", tamaño: " + tamanyo);
	}

	
	//ejercicio a desarrollar
	private void linkearMedio(E element, int index) {
		// Encuentra la posicion a la que se quiere agregar
		Nodo<E> anterior = obtenerNodo(index - 1);
		// Crea un nuevo nodo con el elemento a agregar
		Nodo<E> nuevoNodo = new Nodo<>(element, anterior.sgte);
		// Enlaza el nuevo nodo al nodo anterior
		anterior.sgte = nuevoNodo;
		// Incrementa el tamaño de la lista
		tamanyo++;
	}
	
	
	//ejercicio a desarrollar
	private void linkearPrimero(E element) {
		// Crea un nuevo nodo con el elemento a agregar
		Nodo<E> nuevoNodo = new Nodo<>(element, primero);
		// Establece el nuevo nodo como el primer nodo de la lista
		primero = nuevoNodo;
		// Si la lista esta vacia, el ultimo nodo tambien es el nuevo nodo
		if (ultimo == null) {
			ultimo = nuevoNodo;
		}
		// Incrementa el tamaño de la lista
		tamanyo++;
	}

	
	//ejercicio a desarrollar
	private Nodo<E> obtenerNodo(int index) {
		if (index < 0 || index >= tamanyo) {
			throw new IndexOutOfBoundsException("Índice fuera de los límites: " + index);
		}
		Nodo<E> actual = primero;
		for (int i = 0; i < index; i++) {
			actual = actual.sgte;
		}
		return actual;
	}

	@Override
	public boolean remover(Object o) {
		Nodo<E> previo = null;
		if (o == null) {
			for (Nodo<E> x = primero; x != null; previo = x, x = x.sgte) {
				if (x.item == null) {
					desligar(previo, x);
					return true;
				}
			}
		} else {
			for (Nodo<E> x = primero; x != null; previo = x, x = x.sgte) {
				if (o.equals(x.item)) {
					desligar(previo, x);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public E remover(int index) {
		validarElementoIndice(index);
		Nodo<E> x = primero;
		Nodo<E> previo = null;
		for (int i = 0; i < index; i++) {
			previo = x;
			x = x.sgte;
		}
		return desligar(previo, x);
	}

	//ejercicio a desarrollar
	private E desligar(Nodo<E> previo, Nodo<E> x) {
		// Guarda el elemento del nodo que se va a eliminar
		E elemento = x.item;
		// el nodo a eliminar es el primero de la lista
		if (previo == null) {
			primero = x.sgte;
		} else {
			previo.sgte = x.sgte;
		}
		// el nodo a eliminar es el ultimo de la lista
		if (x == ultimo) {
			ultimo = previo;
		}
		x.item = null;
		x.sgte = null;
		// Decrementamos el tamaño de la lista
		tamanyo--;
		return elemento;
	}

	@Override
	public void limpiar() {
		for (Nodo<E> x = primero; x != null;) {
			Nodo<E> sgte = x.sgte;
			x.item = null;
			x.sgte = null;
			x = sgte;
		}
		primero = ultimo = null;
		tamanyo = 0;
	}

	@Override
	public E get(int index) {
		validarElementoIndice(index);
		return nodo(index).item;
	}

	private void validarElementoIndice(int index) {
		if (!(index >= 0 && index < tamanyo))
			throw new IndexOutOfBoundsException("indice: " + index + ", tamaño: " + tamanyo);
	}

	// ejercicio a desarrollar
	private Nodo<E> nodo(int index) {
		Nodo<E> actual = primero;
		for (int i = 0; i < index; i++) {
			actual = actual.sgte;
		}
		return actual;
	}

	@Override
	public E set(int index, E element) {
		validarElementoIndice(index);
		Nodo<E> x = nodo(index);
		E oldVal = x.item;
		x.item = element;
		return oldVal;
	}

	@Override
	public int indiceDe(Object o) {
		int index = 0;
		if (o == null) {
			for (Nodo<E> x = primero; x != null; x = x.sgte) {
				if (x.item == null)
					return index;
				index++;
			}
		} else {
			for (Nodo<E> x = primero; x != null; x = x.sgte) {
				if (o.equals(x.item))
					return index;
				index++;
			}
		}
		return -1;
	}

	
	//ejercicio a desarrollar
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Lista(");
		Nodo<E> actual = primero;
		while (actual != null) {
			sb.append(actual.item);
			if (actual.sgte != null) {
				sb.append(", ");
			}
			actual = actual.sgte;
		}
		sb.append(")");
		return sb.toString();

	}
}
