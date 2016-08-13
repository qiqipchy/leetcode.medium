import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		if (matrix.length == 0)
			return 0;
		int row = matrix.length, col = matrix[0].length;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < col; i++)
			list.add(matrix[0][i]);
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] >= matrix[i - 1][col - 1]) {
					for (int p = j; p < col; p++)
						list.add(matrix[i][p]);
					break;
				}
				int index = Collections.binarySearch(list, matrix[i][j]);
				if (index < 0)
					list.add(-index - 1, matrix[i][j]);
				else
					list.add(index, matrix[i][j]);
			}
		}
		System.out.println(list);
		return list.get(k - 1);
	}

	
}
