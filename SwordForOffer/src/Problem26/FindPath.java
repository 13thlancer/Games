package Problem26;

import java.util.Stack;


/*
 * 输入一个二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径
 */
public class FindPath {
	
	public void findPath(BinaryTreeNode root, int k) {
		if(root == null)
			System.out.println("errror1");
		Stack<Integer> stack = new Stack<Integer>();
		findPath(root,k,stack);
	}
	
	public void findPath(BinaryTreeNode root, int k, Stack<Integer> path) {
		if(root == null)
			System.out.println("error2");
		if(root.leftNode == null && root.rightNode == null) {
			if(root.data == k) {
				System.out.println("路径开始");
				for(int i : path)
					System.out.println(i);
				System.out.println(root.data);
			}	
		}else {
			path.push(root.data);
			findPath(root.leftNode, k - root.data, path);
			findPath(root.rightNode, k - root.data, path);
			path.pop();
		}
	}
	public static void main(String args[])
	{
		BinaryTreeNode root1=new BinaryTreeNode();
		BinaryTreeNode node1=new BinaryTreeNode();
		BinaryTreeNode node2=new BinaryTreeNode();
		BinaryTreeNode node3=new BinaryTreeNode();
		BinaryTreeNode node4=new BinaryTreeNode();
		BinaryTreeNode node5=new BinaryTreeNode();
		BinaryTreeNode node6=new BinaryTreeNode();
		root1.leftNode=node1;
		root1.rightNode=node2;
		node1.leftNode=node3;
		node1.rightNode=node4;
		node4.leftNode=node5;
		node4.rightNode=node6;
		root1.data=1;
		node1.data=1;
		node2.data=1;
		node3.data=1;
		node4.data=1;
		node5.data=1;
		node6.data=1;
		FindPath testFindPath=new FindPath();
		testFindPath.findPath(root1, 1);		
	}
}

class BinaryTreeNode {
	int data;
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
}
