import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class TreeThing {
	int[] path;
	List<List<Integer>> pathList = new ArrayList<List<Integer>>();
	List<Integer> list = new ArrayList<Integer>();

	public TreeNode buildTree(TreeNode root, int[] nums) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> location = new LinkedList<Integer>();

		int length = nums.length;

		if (root == null)
			root = new TreeNode(nums[0]);
		queue.add(root);
		location.add(0);
		int sum = 0;

		while (queue.size() != 0) {
			TreeNode parent = queue.poll();
			// 第num个结点
			int num = location.poll();
			TreeNode left = null, right = null;
			int leftIndex = 2 * num + 1;
			int rightIndex = 2 * (num + 1);
			if (leftIndex < length)
				left = new TreeNode(nums[leftIndex]);
			if (rightIndex < length)
				right = new TreeNode(nums[rightIndex]);

			if (left != null) {
				sum++;
				queue.add(left);
				location.add(sum);
				parent.left = left;
			}
			if (right != null) {
				++sum;
				queue.add(right);
				location.add(sum);
				parent.right = right;
			}
			if (leftIndex >= length || rightIndex >= length)
				return root;

		}
		return root;
	}

	public void print(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		System.out.print(root.val + " ");
		while (queue.size() != 0) {
			TreeNode parent = queue.poll();

			if (parent.left != null) {
				System.out.print(parent.left.val + " ");
				queue.add(parent.left);
			}
			if (parent.right != null) {
				System.out.print(parent.right.val + " ");
				queue.add(parent.right);
			}
		}
		/*
		 * System.out.println("\t" + root.val); if (root.left != null)
		 * print(root.left); if (root.right != null) print(root.right);
		 */
		// System.out.println();

	}

	public static void main(String[] args) {

		TreeNode root = null;
		int[] nums = { 1, 2, 3, 333, 445, 6, 7, 8, 9, 10 };
		root = new TreeThing().buildTree(root, nums);
		// System.out.println(root.val);
		new TreeThing().print(root);
	}
}
