public class Solution {
	public int minSubArrayLen(int s, int[] nums) {

		int min = Integer.MAX_VALUE;
		int sum = 0;
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != 0)
				// 利用上一次的结果；
				sum -= nums[i - 1];
			while (j < nums.length && sum < s) {
				sum = sum + nums[j++];
			}
			if (sum >= s)
				min = Math.min(min, j - i);
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
		int s = 9;
		int[] nums = { 2, 3, 1, 2, 3, 3 };
		System.out.println(new Solution().minSubArrayLen(s, nums));
	}
}
