package cursoED.semana05;

public class ArrayStack<E> implements Stack<E> {
	protected static final int DEFAULT_MAX_SIZE = 10000;
	protected final int MAX_SIZE;
	private int head;
	private E[] data;

	public ArrayStack(final int maxSize) {
		MAX_SIZE = maxSize;
		head = -1;
		data = (E[]) new Object[MAX_SIZE];
	}

	public ArrayStack() {
		this(DEFAULT_MAX_SIZE);
	} 

	@Override
	public void push(E e) {
		if (head >= MAX_SIZE - 1)
			throw new RuntimeException("Desbordamiento de pila"); 
		head++;
		data[head] = e;
	}

	@Override
	public E pop() {
		if (head < 0) 
			throw new RuntimeException("La pila está vacía");
		E element = data[head];
		data[head] = null; // Eliminar referencia para evitar fuga de memoria
		head--;
		return element;
	}

	@Override
	public E peek() {
		if (head < 0)
			throw new RuntimeException("La pila está vacía");
		return data[head];
	}

	@Override
	public boolean empty() {
		return head == -1;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder("[");
	    for (int i = head; i >= 0; i--) {
	        result.append(data[i]);
	        if (i > 0) { 
	            result.append(", ");
	        }
	    }
	    result.append("]");
	    return result.toString();
	}
}
