import java.util.Stack;

public class Solution {
	public int kthSmallest(TreeNode root, int k) {
		int sum = 0;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		// 使用中序遍历的时候，是增序的数字，所以第k个遍历到的节点地数字就是第k大；
		while (!stack.isEmpty()) {

			TreeNode parent = stack.peek();
			if (parent.left == null) {
				sum++;
				if (sum == k)
					return stack.peek().val;
				if (parent.right != null) {
					stack.pop();
					stack.push(parent.right);
				} else
					stack.pop();
			} else {
				stack.add(parent.left);
				parent.left = null;
			}
		}
		return 0;
	}
}
