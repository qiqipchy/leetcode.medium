package com.leetcode.twenty_three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
	int target;
	int[] candidates;
	List<List<Integer>> list = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {

		// 必须保持是非降序的，和硬币组成差不多；
		Arrays.sort(candidates);
		if (candidates.length == 0 || candidates[0] > target)
			return list;
		this.target = target;
		this.candidates = candidates;
		List<Integer> listOne = new ArrayList<Integer>();
		backTracing(0, candidates.length - 1, listOne);
		Collections.reverse(list);
		for (List<Integer> listone : list)
			Collections.sort(listone);
		return list;
	}

	private void backTracing(int sum, int begin, List<Integer> listOne) {
		// TODO Auto-generated method stub
		if (sum == target) {
			// System.out.println(sum + " " + listOne);
			// 这里需要添加一个新的ArrayList，不然添加的是指针；
			if(!list.contains(listOne))
				list.add(new ArrayList<Integer>(listOne));
			// System.out.println(list + "--------");
			return;
		}
		for (int i = begin; i >= 0; i--) {
			if (target - sum >= candidates[i]) {
				int size = listOne.size();
				listOne.add(candidates[i]);
				backTracing(sum + candidates[i], i - 1, listOne);
				// 不推荐使用subList，返回的是一个视图，如果listOne改变了，则会报错；
				// 使用循环进行删除
				while (listOne.size() > size)
					listOne.remove(listOne.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 1, 1 };
		int target = 1;
		List<List<Integer>> list = new Solution().combinationSum2(candidates,
				target);
		System.out.println(list);

	}
}
