package Problem18;
/*
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的Min函数，在该栈中,min,push.pop的时间复杂度都是O（1）
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
