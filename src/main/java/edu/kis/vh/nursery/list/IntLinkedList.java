package edu.kis.vh.nursery.list;

/**
 * @author Student
 * class implementing a doubly linked list that holds integer values
 */
public class IntLinkedList {
	public static final int DEFAULT_VALUE = -1;

	private class Node {

		private int value;
		private Node prev;
		private Node next;

		public Node(int i) {
			this.value = i;
		}
	}

	private Node last;
	private int i;

	/**
	 * push - places a new value at the end of the list
	 * @param i - value to be pushed
	 */
	public void push(int i) {
		if (last == null)
			last = new Node(i);
		else {
			last.next = new Node(i);
			last.next.prev = last;
			last = last.next;
		}
	}

	/**
	 * isEmpty - checks if list is empty
	 * @return - returns true if list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return last == null;
	}

	/**
	 * isFull - checks if list is full
	 * @return - always returns false because list id dynamically expanding and will never be full
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * top - returns last value from the list
	 * @return value of the last node in the list or DEFAULT_VALUE if the list is empty
	 */
	public int top() {
		if (isEmpty())
			return DEFAULT_VALUE;
		return last.value;
	}
	/**
	 * pop - returns last value and removes the node at the end of the list
	 * @return DEFAULT_VALUE if the list is empty or value from the last node
	 */
	public int pop() {
		if (isEmpty())
			return DEFAULT_VALUE;

		int ret = last.value;
		last = last.prev;

		return ret;
	}

}