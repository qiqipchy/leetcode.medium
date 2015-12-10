package com.leetcode.twentyone;

import java.util.Arrays;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
		if (obstacleGrid[0][0] == 1)
			return 0;
		for (int i = 0; i < obstacleGrid.length; i++) {
			if (obstacleGrid[i][0] == 1)
				break;
			res[i][0] = 1;
		}
		for (int j = 0; j < obstacleGrid[0].length; j++) {
			if (obstacleGrid[0][j] == 1)
				break;
			res[0][j] = 1;
		}
		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[i].length; j++) {
				res[i][j] = res[i - 1][j] + res[i][j - 1];
				// 后面的路都堵死了，从这过不去；
				if (obstacleGrid[i][j] == 1)
					res[i][j] = 0;
			}

		}

		for (int i = 0; i < obstacleGrid.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
		return res[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	public static void main(String[] args) {
		int[][] obstacleGrid = { { 0, 0, } };

		System.out.println(new Solution()
				.uniquePathsWithObstacles(obstacleGrid));
	}
}
