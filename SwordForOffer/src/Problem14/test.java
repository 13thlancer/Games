package Problem14;

import Problem3.ListNode;

public class test {
	public static void main(String args[])
	{
		ListNode head1=new ListNode();
		ListNode second1=new ListNode();
		ListNode head2=new ListNode();
		ListNode second2=new ListNode();
		ListNode third2=new ListNode();
		head1.next=second1;	
		head2.next=second2;
		second2.next=third2;
		head1.data=1;
		second1.data=3;
		head2.data=2;
		second2.data=2;
		third2.data=3;
		
		merge test=new merge();
		ListNode result=test.merge(head1,head2);
		while(result.next != null) {
			System.out.println(result.data);
			result = result.next;	
		}
		
		
	}


}
