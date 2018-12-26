public class LinkedListDeque<T> {
	
	private static class Deque<T> {
		public T item;
		public Deque pre;
		public Deque next;
		public Deque(T i, Deque p, Deque n) {
			item = i;
			pre = p;
			next = n;
		}
	}
	
	private int size;
	
	/** The first item (if ever exists) is at sentinel.next. (circular sentinel) */
	private Deque sentinel;
	
	// Creates an empty linked list deque. 
	public LinkedListDeque() {
		sentinel = new Deque(null, new Deque(null, null, null), new Deque(null, null, null));
		size = 0;
	}
	
	// Adds an item of type T to the front of the deque.
	public void addFirst(T item) {
		size += 1;
		if (isEmpty()) {
			sentinel.next = new Deque(item, sentinel, sentinel);
			sentinel.pre = sentinel.next;
		} else {
			sentinel.next = new Deque(item, sentinel, sentinel.next);
			sentinel.next.next.pre = sentinel.next;
		}
	}
	
	public void addLast(T item) {
		size += 1;
		if (isEmpty()) {
			sentinel.next = new Deque(item, sentinel, sentinel);
			sentinel.pre = sentinel.next;
		} else {
			sentinel.pre = new Deque(item, sentinel.pre, sentinel);
			sentinel.pre.pre.next = sentinel.pre;
		}
	}
	
	public boolean isEmpty() {
//		if (size == 0) {
//			return true;
//		}
//		return false;
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	// Prints the items in the deque from first to last, separated by a space.
	public void printDeque() {
		if (isEmpty()) {
			System.out.println("null");
			return;
		} else {
			Deque p = sentinel;
			while (p.next.item != null) {
				System.out.print(p.next.item + " ");
				p = p.next;
			}
		}
	}
	
	public T removeFirst() {
		if (isEmpty()) {
			return null;
		}
		T oldFirst = (T) sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.pre = sentinel;
		size -= 1;
		return oldFirst;
	}
	
	public T removeLast() {
		if (isEmpty()) {
			return null;
		}
		T oldLast = (T) sentinel.pre.item;
		sentinel.pre = sentinel.pre.pre;
		sentinel.pre.next = sentinel;
		size -= 1;
		return oldLast;
	}
	
	//  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. 
	//	If no such item exists, returns null. Must not alter the deque!
	public T get(int index) {
		if (isEmpty() || size - 1 < index) {
			return null;
		} else {
			Deque p = sentinel;
			for (int i = 0; i <= index; i++) {
				p = p.next;
			}
			return (T) p.item;
		}
	}
	
	public T getRecursive(int index) {
	//	Deque p = sentinel;
		if (size <= index) {
			return null;
		} 
		if (index == 0) {
			return (T) sentinel.next.item;
		}
		if (index == size - 1) {
			return (T) sentinel.pre.item;
		}
		return getRecursive(size - 1);
	}
	
//	/* Utility method for printing out empty checks. */
//	public static boolean checkEmpty(boolean expected, boolean actual) {
//		if (expected != actual) {
//			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
//			return false;
//		}
//		return true;
//	}
//
//	/* Utility method for printing out empty checks. */
//	public static boolean checkSize(int expected, int actual) {
//		if (expected != actual) {
//			System.out.println("size() returned " + actual + ", but expected: " + expected);
//			return false;
//		}
//		return true;
//	}
//
//	/* Prints a nice message based on whether a test passed. 
//	 * The \n means newline. */
//	public static void printTestStatus(boolean passed) {
//		if (passed) {
//			System.out.println("Test passed!\n");
//		} else {
//			System.out.println("Test failed!\n");
//		}
//	}
//
//	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
//	  * finally printing the results. 
//	  *
//	  * && is the "and" operation. */
//	public static void addIsEmptySizeTest() {
//		System.out.println("Running add/isEmpty/Size test.");
//	//	System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
//		
//		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();
//
//		boolean passed = checkEmpty(true, lld1.isEmpty());
//
//		lld1.addFirst("front");
//		
//		// The && operator is the same as "and" in Python.
//		// It's a binary operator that returns true if both arguments true, and false otherwise.
//		passed = checkSize(1, lld1.size()) && passed;
//		passed = checkEmpty(false, lld1.isEmpty()) && passed;
//
//		lld1.addLast("middle");
//		passed = checkSize(2, lld1.size()) && passed;
//
//		lld1.addLast("back");
//		passed = checkSize(3, lld1.size()) && passed;
//
//		System.out.println("Printing out deque: ");
//		lld1.printDeque();
//
//		printTestStatus(passed);
//		
//	}
//
//	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
//	public static void addRemoveTest() {
//
//		System.out.println("Running add/remove test.");
//
//	//	System.out.println("Make sure to uncomment the lines below (and delete this print statement).");
//		
//		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
//		// should be empty 
//		boolean passed = checkEmpty(true, lld1.isEmpty());
//
//		lld1.addFirst(10);
//		// should not be empty 
//		passed = checkEmpty(false, lld1.isEmpty()) && passed;
//
//		lld1.removeFirst();
//		// should be empty 
//		passed = checkEmpty(true, lld1.isEmpty()) && passed;
//
//		printTestStatus(passed);
//		
//	}
//
//	public static void main(String[] args) {
//		System.out.println("Running tests.\n");
//		addIsEmptySizeTest();
//		addRemoveTest();
//	}
}
