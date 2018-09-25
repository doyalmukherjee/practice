package com.coding.questions.linkedlist;

public class IntersectionLinkedList {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode p1=headA, p2=headB;
        if (p1 == null || p2 == null)
            return null;
 
        while(p1 != null){
            len1++;
            p1 = p1.next;
        }
        while(p2 !=null){
            len2++;
            p2 = p2.next;
        }
 
        int diff = 0;
        p1=headA;
        p2=headB;
 
        if(len1 > len2){
            diff = len1-len2;
            int i=0;
            while(i<diff){
                p1 = p1.next;
                i++;
            }
        }else{
            diff = len2-len1;
            int i=0;
            while(i<diff){
                p2 = p2.next;
                i++;
            }
        }
 
        while(p1 != null && p2 != null){
            if(p1.val == p2.val){
                return p1;
            }else{
 
            }
            p1 = p1.next;
            p2 = p2.next;
        }
 
        return null;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(3);
		l1.next.next= new ListNode(5);
		l1.next.next.next= new ListNode(7);
		l1.next.next.next.next=new ListNode(9);
		l1.next.next.next.next.next= new ListNode(11);
		
		ListNode l2 = new ListNode(2);
		l2.next=new ListNode(4);
		l2.next.next= new ListNode(9);
		l2.next.next.next= new ListNode(11);
		
		System.out.println(new IntersectionLinkedList().getIntersectionNode(l1, l2).val);
				
	}
}
