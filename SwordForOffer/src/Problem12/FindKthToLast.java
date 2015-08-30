package Problem12;

import Problem3.ListNode;

/*����б��е�����k���ڵ�*/
public class FindKthToLast {

	public ListNode FindKthToLast(ListNode head, int k) {
		if(head == null)
			return null;
		ListNode resultListNode = null;
		ListNode poListNode = head;
		for(int i = 0; i < k - 1; ++i) {
			if(poListNode.next != null)
				poListNode = poListNode.next;
			else
				return null;
		}
		resultListNode = head;
		while(poListNode.next != null) {
			poListNode = poListNode.next;
			resultListNode = resultListNode.next;
		}
		return resultListNode;
	}
}
