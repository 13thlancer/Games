package Problem4;

import Problem4.RebuildBinaryTree.BinaryTreeNode;

public class test {
	public static void main(String args[]) throws Exception {
		RebuildBinaryTree test = new RebuildBinaryTree();
		int[] pre = {1,2,4,7,3,5,6,8};
		int[] in = {4,7,2,1,5,3,8,6};
		BinaryTreeNode root = test.RebuildBinaryTree(pre, in);
		System.out.println(root);
	}
}
