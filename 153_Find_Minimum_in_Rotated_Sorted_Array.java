class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class Solution {
	public int findMin(int[] nums) {
		int i = nums.length - 1;
		while (i > 0) {
			if (nums[i] < nums[i - 1])
				break;
			i--;
		}
		// 5,6,7,0,1,2,3,4
		// i就是0的位置；
		return nums[i];
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int sum = new Solution().findMin(nums);
		System.out.println(sum);
	}
}
