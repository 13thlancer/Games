package Problem12;

import Problem3.ListNode;

public class test {
	public static void main(String args[])
	{
		ListNode head=new ListNode();
		ListNode second=new ListNode();
		ListNode third=new ListNode();
		ListNode forth=new ListNode();
		head.next=second;
		second.next=third;
		third.next=forth;
		head.data=1;
		second.data=2;
		third.data=3;
		forth.data=4;
		FindKthToLast test=new FindKthToLast();
		ListNode resultListNode=test.FindKthToLast(head,2);
		System.out.println(head);
	}

}
