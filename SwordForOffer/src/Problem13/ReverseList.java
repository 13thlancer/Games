package Problem13;

import Problem3.ListNode;

public class ReverseList {
/*����һ�������ͷ�ڵ㣬��ת������*/
	
	public ListNode reverseList(ListNode head) {
	
		if(head == null)
			return null;
		ListNode preListNode = null;
		ListNode nowListNode = head;
		while(nowListNode.next != null) {
			ListNode nextLIstNode = nowListNode.next;
			nowListNode.next = preListNode;
			preListNode = nowListNode;
			nowListNode = nextLIstNode;
		}
		return nowListNode;
	}
	
}
