public class ArrayDeque<T> {
	private T[] items;
	private int size;
	
	public ArrayDeque() {
		items = (T[]) new Object[8];
		size = 0;
	}
	
	private void resize(int capacity) {
		T[] a = (T[]) new Object[capacity];
		System.arraycopy(items, 0, a, 0, size);
		items = a;
	}
	
	public void addFirst(T item) {
		if (isEmpty()) {
			items[0] = item;
		} else {
			
		}
		size += 1;
	}
	
	public void addLast(T item) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[size] = item;
		size += 1;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void printDeque() {
		if (isEmpty()) {
			System.out.println("null");
		} else {
			for (int i = 0; i < size; i++) {
				System.out.print(items[i] + " ");
			}
		}
	}
	
	public T removeFirst() {
		if (isEmpty()) {
			return null;
		} else {
			size -= 1;
			T itemFirst = items[0];
			return itemFirst;
		}
	}
	
	public T removeLast() {
		if (isEmpty()) {
			return null;
		} else {
			T itemLast = get(size - 1);
			items[size - 1] = null;
			size -= 1;
			return itemLast;
		}
		
	}
	
	public T get(int index) {
		if (index >= size) {
			return null;
		}
		return items[index];
	}
}
