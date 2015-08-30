package Problem18;
/*定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。*/
public class Stack<k> {
	public ListNode<k> head;
	public int length;
	public void push(k item) {
		ListNode<k> node = new ListNode<k>();
		node.data = item;
		node.nextNode = head;
		head = node;
		length++;	
	}
	
	public k pop() {
		if(head == null)
			return null;
		ListNode<k> temp = head;
		head = head.nextNode;
		length--;
		return temp.data;
	}

}

class ListNode<k> {
	k data;
	ListNode<k> nextNode;
}