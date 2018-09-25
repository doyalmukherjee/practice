package com.coding.questions.linkedlist;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;

		ListNode newHead = new ListNode(0);
		ListNode p1 = l1, p2 = l2, p3 = newHead;
		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}
			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}
			p3.next = new ListNode(carry % 10);
			p3 = p3.next;
			carry /= 10;
		}
		if (carry == 1)
			p3.next = new ListNode(1);
		return newHead.next;
	}
	
	public static void main(String[] args) {
		ListNode l1= new ListNode(2);
		ListNode l2= new ListNode(4);
		ListNode l3= new ListNode(3);
		l1.next=l2;
			l2.next=l3;
		
		ListNode l4= new ListNode(5);
		ListNode l5= new ListNode(6);
		ListNode l6= new ListNode(4);
		l4.next=l5;
		l5.next=l6;
		
		AddTwoNumbers an = new AddTwoNumbers();
		ListNode result = an.addTwoNumbers(l1, l4);
		MergeSortedList.printList(result);
	}
}
