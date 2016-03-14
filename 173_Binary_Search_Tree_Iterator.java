import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

// 注意是把一个中序程序拆开来写；
class BSTIterator {
	TreeNode root;
	Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		this.root = root;
		if (root != null)
			stack.add(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		while (!stack.isEmpty()) {
			TreeNode parent = stack.peek();
			if (parent.left == null) {
				stack.pop();
				if (parent.right != null) {
					stack.add(parent.right);
				}
				return parent.val;
			} else {
				stack.push(parent.left);
				parent.left = null;
			}
		}
		return 0;
	}
}

public class Solution {
	public static void main(String[] args) {
		int[] nums = { 6, 2, 8, 0, 3 };
		TreeNode root = new TreeThing().buildTree(null, nums);
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext())
			System.out.println(i.next());
	}
}
