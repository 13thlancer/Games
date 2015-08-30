package Problem18;
/*
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ����СԪ�ص�Min�������ڸ�ջ��,min,push.pop��ʱ�临�Ӷȶ���O��1��
 */
public class StackWithMin extends Stack<Integer>{

	private Stack<Integer> minStack = new Stack<>();
	private Stack<Integer> dataStack = new Stack<>();
	
	public void push(Integer item) {
		dataStack.push(item);
		if(minStack.length == 0 || item <= minStack.head.data) {
			minStack.push(item);
		}else{
			minStack.push(minStack.head.data);
		}
	}
	
	public Integer min() {
		if(minStack.length == 0)
			return null;
		return minStack.head.data;
	}
}
