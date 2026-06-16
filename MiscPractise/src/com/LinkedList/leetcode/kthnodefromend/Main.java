package com.LinkedList.leetcode.kthnodefromend;

import com.LinkedList.leetcode.kthnodefromend.LinkedList.Node;

public class Main {

	public static void main(String[] args) {
		LinkedList myList = new LinkedList(1);
		myList.append(2);
		myList.append(3);
		myList.append(4);
		myList.append(5);
		
		Node result = myList.findKthFromEnd(4);
		
		System.out.println(result.value);

	}

}
