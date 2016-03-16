import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
/*
 * 对树中的结点进行编号，1，2，3左结点是2*n；右节点是2*n+1； 找到每一层中最优的结点；
 */
public class Solution {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		List<Integer> val = new ArrayList<Integer>();
		List<Integer> index = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> number = new LinkedList<Integer>();

		queue.add(root);
		number.add(1);

		while (!queue.isEmpty()) {
			TreeNode parent = queue.poll();
			int baseNumber = number.poll();
			val.add(parent.val);
			index.add(baseNumber);
			if (parent.left != null) {
				queue.add(parent.left);
				number.add(2 * baseNumber);
			}
			if (parent.right != null) {
				queue.add(parent.right);
				number.add(2 * baseNumber + 1);
			}
		}
		int radius = 1, i = 0;
		while (i < index.size()) {
			int max = Integer.MIN_VALUE;
			while (i < index.size() && index.get(i) < Math.pow(2, radius))
				i++;
			list.add(val.get(i - 1));

			radius++;
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, -1, -1, -1, 8 };
		TreeNode root = new TreeThing().buildTree(null, nums);
		System.out.println(new Solution().rightSideView(root));

	}
}
