package com.coding.questions.linkedlist;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;
	
	ListNode(int x) {
		val = x;
	}
}

public class MergeSortedList {

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			public int compare(ListNode l1, ListNode l2) {
				return l1.val - l2.val;
			}
		});

		ListNode head = new ListNode(0);
		ListNode p = head;

		for (ListNode list : lists) {
			if (list != null)
				queue.offer(list);
		}

		while (!queue.isEmpty()) {
			ListNode n = queue.poll();
			p.next = n;
			p = p.next;

			if (n.next != null)
				queue.offer(n.next);
		}

		return head.next;

	}
	
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
 
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		n4.next = n5;
		n5.next = n6;
 
		ListNode n7 = new ListNode(2);
		ListNode n8 = new ListNode(6);
		n7.next = n8;
		
		MergeSortedList ms = new MergeSortedList();
		ListNode result=ms.mergeKLists(new ListNode[] {n1,n4,n7});
		printList(result);
	}

	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
		
	}
}
