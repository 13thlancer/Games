package Problem5;
/*����ջʵ��һ������*/
import java.util.Stack;

public class StackQuene {
	
	private Stack<String> stack1 = new Stack<String>();
	private Stack<String> stack2 = new Stack<String>();

	public void appendTail(String s) {
		stack1.push(s);
		}
	
	public String deleteHead() throws Exception {
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if(stack2.isEmpty()) {
			throw new Exception("����Ϊ�գ�����ɾ����");
		}
		return stack2.pop();
	}
}
