package cursoED.semana07.list;

import java.util.Comparator;
import java.util.List;

import cursoED.semana07.comun.PriorityQueue;

import java.util.ArrayList;

public class ListPriorityQueue<E> implements PriorityQueue<E> {
	private List<E> elements;
	private final Comparator<? super E> comparator;

	public ListPriorityQueue() {
		this(null);
	}

	public ListPriorityQueue(Comparator<? super E> comparator) {
		this.comparator = comparator;
		elements = new ArrayList<>();
	}

	@Override
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public boolean offer(E e) {
		if (e == null)
			throw new NullPointerException();
		if (comparator != null)
			return offerUsingComparator(e, comparator);
		else
			return offerComparable(e);
	}

	private boolean offerComparable(E e) {
		Comparable<? super E> key = (Comparable<? super E>) e;
		int index = -1;
		for (int i = 0; i < elements.size(); i++) {
			if (key.compareTo(elements.get(i)) >= 0) {
				index = i;
			} else {
				break;
			}
		}
		if (index == -1) {
			elements.add(0, e);
			return true;
		} else {
			elements.add(index + 1, e);
			return true;
		}
	}

	private boolean offerUsingComparator(E e, Comparator<? super E> comparator) {
		int index = -1;
		for (int i = 0; i < elements.size(); i++) {
			if (comparator.compare(e, elements.get(i)) >= 0) {
				index = i;
			} else {
				break;
			}
		}
		if (index == -1) {
			elements.add(0, e);
			return true;
		} else {
			elements.add(index + 1, e);
			return true;
		}
	}

	@Override
	public E poll() {
		if (elements.size() == 0) {
			return null;
		}
		return elements.remove(0);
	}

	@Override
	public E peek() {
		if (elements.size() == 0) {
			return null;
		}
		return elements.get(0);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < elements.size(); i++) {
			sb.append(elements.get(i));
			if (i < elements.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
