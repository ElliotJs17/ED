package cursoED.semana05;

import cursoED.semana04.Lista;
import cursoED.semana04.ListaEnlazadaSimple;

public class LinkedListStack<E> implements Stack<E> {
	private Lista<E> data;

	public LinkedListStack() {
		data = new ListaEnlazadaSimple<>();  
	}

	@Override
	public void push(E e) {
		data.agregar(0, e); 
	}

	@Override
	public E pop() {
		if (empty()) {
	        throw new RuntimeException("La pila está vacía"); 
	    }
	    return data.remover(0);
	}

	@Override
	public E peek() {
		if (empty()) {
	        throw new RuntimeException("La pila está vacía");
	    }
	    return data.get(0);
	}

	@Override
	public boolean empty() {
		return data.esVacio();
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
