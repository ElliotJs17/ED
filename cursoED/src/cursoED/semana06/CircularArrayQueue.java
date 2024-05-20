package cursoED.semana06;

public class CircularArrayQueue<E> implements Queue<E>{
	private static final int DEFAULT_MAX_SIZE = 100;
	private final int MAX_SIZE;
	private int head;
	private int tail;
	private Object[] elements;

	public CircularArrayQueue() {
		this(DEFAULT_MAX_SIZE);
	}

	public CircularArrayQueue(int maxSize) {
		MAX_SIZE = maxSize + 1;
		head = 0;
		tail = MAX_SIZE - 1;
		elements = new Object[MAX_SIZE];
	}

	private int nextIndex(int currentIndex) {
		return (currentIndex + 1) % MAX_SIZE;
	}

	@Override
	public boolean offer(E e) {
		if (e == null)
			throw new NullPointerException();
		if (!isFull()) {
			tail = nextIndex(tail);
			elements[tail] = e;
			return true;
		} else
			return false;

	}

	@Override
	public E poll() {
		if (!isEmpty()) {
			@SuppressWarnings("unchecked")
			E result = (E) elements[head];
			elements[head] = null;
			head = nextIndex(head);
			return result;
		}
		return null;
	}

	@Override
	public E peek() {
		if (!isEmpty()) {
			@SuppressWarnings("unchecked")
			E result = (E) elements[head];
			return result;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		return head == nextIndex(tail);
	}

	public boolean isFull() {
		return head == nextIndex(nextIndex(tail));
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		int current = head;
		while (current != nextIndex(tail)) {
			@SuppressWarnings("unchecked")
			E element = (E) elements[current];
			builder.append(element);
			if (nextIndex(current) != nextIndex(tail)) {
				builder.append(", ");
			}
			current = nextIndex(current);
		}
		builder.append("]");
		return builder.toString();
	}
}
