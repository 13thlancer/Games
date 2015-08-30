package Problem16;

import java.util.Stack;

import Problem15.BinaryTreeNode;


/*¾µÏñÒ»¸ö¶þ²æÊ÷*/
public class MirrorRecursively{
	public BinaryTreeNode mirrorRecursively(BinaryTreeNode root) {
	if(root == null)
		return null;
	BinaryTreeNode node = root;
	Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
	while(node != null || stack.isEmpty()) {
		while(node != null) {
			BinaryTreeNode temp = node.leftNode;
			node.leftNode = node.rightNode;
			node.rightNode = temp;
			stack.push(node);
			node = node.leftNode;
		}
		node = stack.pop();
		node = node.rightNode;
	}
	return root;
	
 }
	
	
}
