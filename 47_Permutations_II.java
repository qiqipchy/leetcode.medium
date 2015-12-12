package com.leetcode.twenty_three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	List<List<Integer>> list = new ArrayList<List<Integer>>();

	public List<List<Integer>> permuteUnique(int[] nums) {

		// 因为主主体程序的宗旨是下一个排列，所以先将排列置为最小状态；
		Arrays.sort(nums);
		List<Integer> listOne = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++)
			listOne.add(nums[i]);

		list.add(listOne);

		int replaceLoc = findLastAscend(nums);
		while (replaceLoc != -1) {
			int minIndex = findMin(nums, replaceLoc);
			// System.out.println(replaceLoc + " " + minIndex);
			int temp = nums[replaceLoc];
			nums[replaceLoc] = nums[minIndex];
			nums[minIndex] = temp;
			// System.out.println(Arrays.toString(num));
			reverse(replaceLoc + 1, nums);

			listOne = new ArrayList<Integer>();
			for (int i = 0; i < nums.length; i++)
				listOne.add(nums[i]);
			list.add(listOne);
			replaceLoc = findLastAscend(nums);
		}
		return list;

	}

	private int findMin(int[] num, int replaceLoc) {
		// TODO Auto-generated method stub
		// 从后面的元素中找到比nums[replaceLoc]大最小的值；
		int min = Integer.MAX_VALUE, index = replaceLoc + 1;
		for (int i = replaceLoc + 2; i < num.length; i++) {
			// 需要主题相等元素的情况，这里必须加上=号；因为之后是需要进行倒转操作，所以需要把replaceLoc上的元素（较小）放在前面，所以
			// 所以尽量往后放
			if (num[i] - num[replaceLoc] > 0 && num[i] - num[replaceLoc] <= min) {
				min = num[i] - num[replaceLoc];
				index = i;
			}
			// System.out.println(max);
		}
		return index;
	}

	private int findLastAscend(int[] num) {
		// TODO Auto-generated method stub
		for (int i = num.length - 1; i > 0; i--) {
			// 这里的也需要等号，替换的位置都是从后面开始的；
			if (num[i] <= num[i - 1])
				continue;
			else {
				return i - 1;
			}
		}
		// 注意这里最后返回的是-1；
		return -1;
	}

	private void reverse(int begin, int[] num) {
		// TODO Auto-generated method stub
		for (int i = begin, j = num.length - 1; i < j; i++, j--) {
			int temp = num[i];
			num[i] = num[j];
			num[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };

		System.out.println(new Solution().permuteUnique(nums));
	}
}
