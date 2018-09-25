package com.coding.questions.linkedlist;

public class ListPalindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		// find list center
		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode secondHead = slow.next;
		slow.next = null;

		// reverse second part of the list
		ListNode p1 = secondHead;
		ListNode p2 = p1.next;

		while (p1 != null && p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}

		secondHead.next = null;

		// compare two sublists now
		ListNode p = (p2 == null ? p1 : p2);
		ListNode q = head;
		while (p != null) {
			if (p.val != q.val)
				return false;

			p = p.next;
			q = q.next;

		}
		return true;
	}
	
	 public boolean isPalindromeMine(ListNode head) {
	        if(head==null || head.next==null)
	            return true;
	        ListNode slow=head;
	        ListNode fast= head;
	        while(fast.next!=null && fast.next.next!=null){
	            slow=slow.next;
	            fast=fast.next;
	        }
	        ListNode secondHead = slow.next;
	        slow.next=null;
	        
	        ListNode p1=secondHead;
	        ListNode p2=p1.next;
	        while(p1!=null && p2!=null){
	            ListNode temp =p2.next;
	            p2.next=p1;
	            p1=p2;
	            p2=temp;
	        }
	        secondHead.next=null;
	        
	        ListNode p=(p2==null)?p1:p2;
	        ListNode q=head;
	        while(p!=null){
	            if(p.val!=q.val)
	                return false;
	            p=p.next;
	            q=q.next;
	        }
	        return true;
	    }
	 
	public static void main(String[] args) {
		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(1);
		ListNode l3= new ListNode(2);
		ListNode l4= new ListNode(1);
		
		l1.next=l2;
		l2.next=l3;
		l3.next=l4;
		
		ListPalindrome lp = new ListPalindrome();
		System.out.println(lp.isPalindromeMine(l1));
	}
}
