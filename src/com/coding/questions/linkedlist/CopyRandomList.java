package com.coding.questions.linkedlist;

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
};

public class CopyRandomList {
	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null)
			return null;

		RandomListNode p = head;

		// copy every node and insert to list
		while (p != null) {
			RandomListNode copy = new RandomListNode(p.label);
			copy.next = p.next;
			p.next = copy;
			p = copy.next;
		}

		// copy random pointer for each new node
		p = head;
		while (p != null) {
			if (p.random != null)
				p.next.random = p.random.next;
			p = p.next.next;
		}

		// break list to two
		p = head;
		while(p != null && p.next != null){
		    RandomListNode temp = p.next;
		    p.next = temp.next;
		    p = temp;
		}

		return p;
	}
	
	public static void main(String[] args) {
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		
		node1.random=node3;
		node2.random=node1;
		node3.random=node5;
		node4.random=node5;
		node5.random=node2;
		
		CopyRandomList cr = new CopyRandomList();
		cr.copyRandomList(node1);
	}
}
