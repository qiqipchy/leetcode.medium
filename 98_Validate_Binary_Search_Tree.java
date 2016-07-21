import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	List<Integer> list = new ArrayList<Integer>();

	// 中序遍历是增序，那就可以；
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		TreeNode iter = root;
		// 使用dfs更快一些，使用stack太慢了；
		preOrder(root);
		preOrderuseStack(root);
		System.out.println(list);
		for (int i = 0; i < list.size() - 1; i++)
			// 等于也是不行的；
			if (list.get(i) >= list.get(i + 1))
				return false;
		return true;
	}

	private void preOrder(TreeNode root) {
		// TODO Auto-generated method stub
		if (root.left != null)
			preOrder(root.left);
		list.add(root.val);
		if (root.right != null)
			preOrder(root.right);

	}

	private void preOrderuseStack(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (root == null)
			return;
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode parent = stack.peek();
			if (parent.left != null) {
				stack.add(parent.left);
				continue;
			} else {
				stack.pop();
				list.add(parent.val);
				if (parent.right != null)
					stack.add(parent.right);
				else if (!stack.isEmpty())
					stack.peek().left = null;
			}
		}
	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		String data = "2,1,3,3,4,5,6";

		System.out.println(new Solution().isValidBST(codec.deserialize(data)));
	}

}
