import java.util.Arrays;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;
		return convert(nums, 0, nums.length - 1);
	}

	private TreeNode convert(int[] nums, int begin, int end) {
		// TODO Auto-generated method stub
		// 注意这里的终止条件，是>end的时候，这时候已经没有元素了
		if (begin > end)
			return null;
		int middle = (begin + end) / 2;
		TreeNode root = new TreeNode(nums[middle]);
		root.left = convert(nums, begin, middle - 1);
		root.right = convert(nums, middle + 1, end);
		return root;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		Arrays.sort(nums);
		TreeNode root = new Solution().sortedArrayToBST(nums);
		new TreeThing().print(root);
	}
}108. Convert Sorted Array to Binary Search Tree
