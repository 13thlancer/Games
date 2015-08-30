package Problem18;
/*����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������*/
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