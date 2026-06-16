package com.LinkedList.leetcode.kthnodefromend;

public class LinkedList {

	private Node head;
	private Node tail;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}
	}

	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public void printList() {
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.print(current.value);
			if (current.next != null) {
				System.out.print(" -> ");
			}
			current = current.next;
		}
		System.out.println();
	}

	public void makeEmpty() {
		head = null;
		tail = null;
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public Node findKthFromEnd(int k) {
		if (k <= 0)
			return null;

		int length = 0;
		Node temp = head;

		while (temp != null) {
			temp = temp.next;
			length++;
		}

		if (k > length)
			return null;

		Node slow = head;
		for (int i = 0; i < length - k; i++) {
			slow = slow.next;
		}

		return slow;
	}

	/*
	 * “Why is your solution optimal?”
	 * 
	 * Answer:
	 * 
	 * The two-pointer approach avoids computing length and completes in a single
	 * traversal, maintaining a gap of k nodes between pointers, ensuring O(n) time
	 * and O(1) space with better efficiency in streaming scenarios.
	 */

	public Node findKthFromEndBetterVersion(int k) {
		if (k <= 0)
			return null;

		Node slow = head;
		Node fast = head;

		// Move fast k steps
		for (int i = 0; i < k; i++) {
			if (fast == null)
				return null;
			fast = fast.next;
		}

		// Move both
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

}
