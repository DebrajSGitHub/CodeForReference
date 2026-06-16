package com.LinkedList;

import com.LinkedList.LinkedList.Node;

public class LinkedList {

	private Node head;
	private Node tail;
	private int length;

	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;

	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	public void getHead() {
		if (head == null) {
			System.out.println("Head: null");
		} else {
			System.out.println("Head: " + head.value);
		}
	}

	public void getTail() {
		if (head == null) {
			System.out.println("Tail: null");
		} else {
			System.out.println("Tail: " + tail.value);
		}
	}

	public void getLength() {
		System.out.println("Length: " + length);
	}

	public void printlist() {

		Node temp = head;

		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;

		}
		length++;
	}

	public Node removeLast() {
		if (length == 0)
			return null;

		Node temp = head;
		Node pre = head;

		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}

		tail = pre;
		tail.next = null;
		length--;

		if (length == 0) {
			head = null;
			tail = null;
		}

		return temp;

	}

	public Node removeFirst() {
		if (length == 0)
			return null;

		Node temp = head;
		// Node pre = head;
		head = temp.next;
		temp.next = null;

		length--;

		if (length == 0) {
			// head = null; // not required
			tail = null;
		}

		return temp;

	}

	//
	public void prepend(int value) {
		Node newnode = new Node(value);

		if (length == 0) {
			head = newnode;
			tail = newnode;
		} else {

			// Node temp=head;
			// head= newnode;
			// newnode.next=temp;

			// without temp

			newnode.next = head;
			head = newnode;
		}

		length++;

	}

	public Node get1(int index) {// my bad coding
		Node temp = head;
		int count = 1;

		if (index == 0 || index > length)
			return null;

		while (count <= length) {
			System.out.println("temp.value " + temp.value + "  " + count);
			if (count == index) {
				return temp;
			} else {
				count++;
				temp = temp.next;
			}

		}

		return null;
	}

	public Node get(int index) {
		if (index < 0 || index >= length)
			return null;

		Node temp = head;

		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;

	}

	public boolean set(int index, int value) {
		if (index < 0 || index >= length)
			return false;

		Node temp = get(index);
		if (temp != null) {
			temp.value = value;
			return true;
		} else
			return false;

	}

	public boolean insert(int index, int value) {
		if (index < 0 || index > length)
			return false;

		if (index == 0) {
			prepend(value);
			return true;
		}
		if (index == length) {
			append(value);
			return true;
		}

		Node newNode = new Node(value);
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;

	}

	public Node remove(int index) {

		if (index < 0 || index >= length)
			return null;

		if (index == 0)
			removeFirst();
		if (index == length - 1)
			removeLast();

		Node prev = get(index - 1);
		Node temp = prev.next;
		prev.next = temp.next;
		temp.next = null;

		length--;

		return temp;

	}
	
	public void reverse() {
		Node temp = head;
	    head = tail;
	    tail = temp;

	    Node before = null;
	    Node after = null;

	    while (temp != null) {
	        after = temp.next;
	        temp.next = before;
	        before = temp;
	        temp = after;
	    }
		
	}

}
