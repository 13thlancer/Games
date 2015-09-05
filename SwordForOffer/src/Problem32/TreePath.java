package Problem32;

public class TreePath {
	/*
	 * 1.������ڵ����������
	 */
	public int treePath(BinaryTreeNode root) {
		if(root == null)
			return 0;
		int left = treePath(root.leftNode);
		int right = treePath(root.rightNode);
		return left > right ? (left + 1) : (right + 1);
	}
	
	/*
	 * 2.�ж϶������ǲ���ƽ����������������������ڵ�������������������1������ƽ���
	 */
	public boolean isBalanced(BinaryTreeNode root) {
		int depth = 0;
		return isBalanced(root,depth);
	}
	
	public boolean isBalanced(BinaryTreeNode root, int depth) {
		if(root == null) {
			depth = 0;
			return true;
		}
		int left = 0,right = 0;
		if(isBalanced(root.leftNode, left) && isBalanced(root.rightNode, right)) {
			int diff = left - right;
			if(diff <= 1 && diff >= -1) {
				depth = 1+(left>right?left:right);
				return true;
			}
		}
		return false;
	}
}

class BinaryTreeNode {
	int data;
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
}