package com.LinkedList;

import com.LinkedList.LinkedList.Node;

public class Main {

	public static void main(String[] args) {

		LinkedList myLinkedList = new LinkedList(1);
		myLinkedList.append(2);
		myLinkedList.prepend(0);
		myLinkedList.append(3);
		myLinkedList.append(4);
		myLinkedList.append(5);
		myLinkedList.set(0, 500);
		myLinkedList.insert(4, 77);

		int index = 0;
		Node node = myLinkedList.get(index);
		String s = (node != null) ? ("the value is " + node.value) : "Node less than 0 index or exceeds length";

		System.out.println(" get(index) index:  " + index + "    " + s);

		myLinkedList.getHead();
		myLinkedList.getTail();
		myLinkedList.getLength();

		System.out.println("\nLinked List:");
		myLinkedList.printList();
		System.out.println("=======================");

		/*
		 * EXPECTED OUTPUT: ---------------- Head: 4 Tail: 4 Length: 1
		 * 
		 * Linked List: 4
		 * 
		 */

		/*
		 * System.out.println(myLinkedList.removeLast().value);
		 * System.out.println(myLinkedList.removeLast().value);
		 * System.out.println(myLinkedList.removeLast().value);
		 * System.out.println(myLinkedList.removeLast());
		 */
		System.out.println(myLinkedList.removeFirst().value);
		System.out.println(myLinkedList.removeFirst().value);
		System.out.println(myLinkedList.removeFirst().value);
		System.out.println(myLinkedList.removeFirst().value);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		LinkedList myLinkedList2 = new LinkedList(1);
		
		myLinkedList2.append(2);
		myLinkedList2.append(3);
		myLinkedList2.append(4);
		myLinkedList2.append(5);
		
		myLinkedList2.reverse();
		myLinkedList2.printList();

	}

}
