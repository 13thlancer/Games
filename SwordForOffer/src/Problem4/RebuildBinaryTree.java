package Problem4;

import java.util.Arrays;

/*����ĳ��������ǰ���������������Ľ����
 * ���ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}��
 * ���ؽ���������������ĺ���������С�*/
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
		throw new Exception("�������");
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
		throw new Exception("���������ڵ�");
	}
	return root;
	}
}
