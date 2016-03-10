/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return list;
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode parent = stack.peek();
			if (parent.left == null) {
				stack.pop();
				list.add(parent.val);
				if (parent.right != null)
					stack.push(parent.right);
			} else {
				stack.add(parent.left);
				parent.left = null;
			}
		}
		return list;
	}
}
