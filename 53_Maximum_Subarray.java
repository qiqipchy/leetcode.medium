package com.leetcode.twentyone;

public class Solution {

	public int maxSubArray(int[] nums) {
		int local = nums[0], global = nums[0];
		// local是含有当前元素的局部最优解；
		// gloabl是全局最优解；
		for (int i = 1; i < nums.length; i++) {
			local = Math.max(local + nums[i], nums[i]);
			global = Math.max(global, local);
		}
		return global;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(new Solution().maxSubArray(nums));
	}
}
