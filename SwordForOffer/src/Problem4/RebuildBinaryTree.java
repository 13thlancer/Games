package Problem4;

import java.util.Arrays;

/*输入某二叉树的前序遍历和中序遍历的结果，
 * 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并输出它的后序遍历序列。*/
public class RebuildBinaryTree {
	public class BinaryTreeNode {
		public int value;
		public BinaryTreeNode leftNode;
		public BinaryTreeNode rightNode;
	}
	
	public BinaryTreeNode RebuildBinaryTree(int[] preorder,int[] inorder) throws Exception {
	boolean isHave = false;
	if(preorder == null || inorder == null) {
		return null;
	}
	if(preorder.length!=inorder.length) {
		throw new Exception("输入错误");
	}
	BinaryTreeNode root = new BinaryTreeNode();
	for(int i = 0; i<inorder.length; i++) {
		if(inorder[i] == preorder[0]) {
			isHave = true;
			root.value = inorder[i];
			root.leftNode = RebuildBinaryTree(Arrays.copyOfRange(preorder, 1, i+1)
					,Arrays.copyOfRange(inorder, 0, i));	
			root.rightNode = RebuildBinaryTree(Arrays.copyOfRange(preorder, i+1, preorder.length)
					,Arrays.copyOfRange(inorder, i+1, inorder.length));
		}
	}
	if(!isHave) {
		throw new Exception("不包含根节点");
	}
	return root;
	}
}
