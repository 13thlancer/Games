package Problem3;

import java.util.Stack;

/*����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ*/
public class ListReverse {

	public void ListReverse(ListNode headNode) {
		Stack<ListNode> stack = new Stack<ListNode>();
		while(headNode !=  null) {
			stack.push(headNode);
			headNode = headNode.next;
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().data);
		}
	}

}
