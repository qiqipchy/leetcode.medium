package com.leetcode.twentyone;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<String> list = new ArrayList<String>();

	public List<String> generateParenthesis(int n) {
		String res = null;
		genString(n, n, "");
		return list;
	}

	private void genString(int left, int right, String path) {
		// TODO Auto-generated method stub
		if (left < 0 || right < 0 || right < left)
			return;
		if (left == 0 && right == 0) {
			list.add(path);
			return;
		}
		genString(left - 1, right, path + "(");
		genString(left, right - 1, path + ")");

	}

	public static void main(String[] args) {
		int n = 3;
		System.out.println(new Solution().generateParenthesis(n));
	}
}
