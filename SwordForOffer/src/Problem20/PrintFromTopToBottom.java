package Problem20;

import java.util.LinkedList;
import java.util.Queue;


/*从上往下打印出二叉树的每个节点，同层节点从左至右打印。*/
public class PrintFromTopToBottom<k> {

	public <E> void printFromTopToBottom(BinaryTreeNode<k> root) {
		if(root != null)
			return;
		Queue<BinaryTreeNode<k>> queue = new LinkedList<BinaryTreeNode<k>>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<k> node = queue.poll();
			System.out.println(node.data);
			if(node.leftNode != null)
				queue.add(node.leftNode);
			if(node.rightNode != null)
				queue.add(node.rightNode);
			}
		}
	}

class BinaryTreeNode<k> {
	k data;
	BinaryTreeNode<k> leftNode;
	BinaryTreeNode<k> rightNode;
}