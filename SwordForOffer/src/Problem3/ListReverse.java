package Problem3;

import java.util.Stack;

/*输入一个链表，从尾到头打印链表每个节点的值*/
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
