public class Solution {
	// 计算两遍
	public boolean canJump(int[] nums) {
		if (nums.length == 0 || nums.length == 1)
			return true;
		int max = nums[0];
		// 注意是到n-1
		for (int i = 1; i < nums.length - 1; i++) {
			// 如果不能到达下一步，则退出；
			if (max <= 0)
				return false;
			// 如果能够达到下一步，挑选最大的；
			max = Math.max(max - 1, nums[i]);
		}
		if (max <= 0)
			return false;
		return true;

	}

	public static void main(String[] args) {
		int[] nums = { 0, 2, 3 };
		System.out.println(new Solution().canJump(nums));
	}
}
