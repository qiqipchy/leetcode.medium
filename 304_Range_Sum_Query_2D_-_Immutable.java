import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int[][] matrix = new int[5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				matrix[i][j] = i + j;
			System.out.println(Arrays.toString(matrix[i]));
		}
		System.out.println("--------------");
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println(numMatrix.sumRegion(0, 1, 2, 3));
		System.out.println(numMatrix.sumRegion(1, 2, 3, 4));

	}
}

class NumMatrix {
	int[][] sum;
	int length = 1;

	public NumMatrix(int[][] matrix) {
		if (matrix.length == 0) {
			length = 0;
			return;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		sum = new int[row][col];
		sum[0][0] = matrix[0][0];
		for (int j = 1; j < col; j++)
			sum[0][j] = sum[0][j - 1] + matrix[0][j];
		for (int i = 1; i < row; i++)
			sum[i][0] = sum[i - 1][0] + matrix[i][0];
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++)
				sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1]
						+ matrix[i][j];

		}
		for (int i = 0; i < row; i++)
			System.out.println(Arrays.toString(sum[i]));
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		if (length == 0)
			return 0;
		if (row1 == 0 && col1 == 0)
			return sum[row2][col2];
		else if (row1 == 0)
			return sum[row2][col2] - sum[row2][col1 - 1];
		else if (col1 == 0)
			return sum[row2][col2] - sum[row1 - 1][col2];
		return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1]
				+ sum[row1 - 1][col1 - 1];
	}
}

// Your NumMatrix object will be instantiated and called as such:
