package Problem14;

import Problem3.ListNode;

/*
 * �������������������ϲ�����������ʹ��������Ȼ�ǵ�����
 */
public class merge {
	public ListNode merge(ListNode root1, ListNode root2) {
		if(root1 == null)
			return root2;
		else if(root2 == null)
			return root1;
		ListNode mergeHead = null;
		if(root1.data <= root2.data) {
			mergeHead = root1;
			mergeHead.next = merge(root1.next, root2);
			}else {
				mergeHead = root2;
				mergeHead.next = merge(root1, root2.next);
			}
		return mergeHead;
		}
	}


