import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		if (root == null)
			return list;
		stack.push(root);
		list.add(root.val);
		while (!stack.isEmpty()) {
			TreeNode parent = stack.peek();
			if (parent.left != null) {
				stack.push(parent.left);
				list.add(parent.left.val);
				// 要在这里切断联系，不然会造成一个死循环；
				parent.left = null;
			} else {
				stack.pop();
				if (parent.right != null) {
					stack.push(parent.right);
					list.add(parent.right.val);
				}
			}
		}
		// System.out.println(list);
		return list;
	}

	public static void main(String[] args) {
		TreeThing treeThing = new TreeThing();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = treeThing.buildTree(null, nums);
		// treeThing.print(root);
		System.out.println(new Solution().preorderTraversal(root));

	}
}
