import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//很简单的一道题，暴力解决
public class Solution {
	public void setZeroes(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix.length == 0)
			return;
		int i;
		for (i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					list.add(i);
					list.add(j);
				}
			}
		}
		for (i = 0; i < list.size(); i += 2) {
			int k = list.get(i);
			int p = list.get(i + 1);
			Arrays.fill(matrix[k], 0);
			for (int m = 0; m < matrix.length; m++)
				matrix[m][p] = 0;
		}

	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 },
				{ 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
		new Solution().setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}
}
