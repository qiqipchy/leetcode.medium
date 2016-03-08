import java.util.Arrays;

public class Solution {

	int[][] origin;

	public void gameOfLife(int[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return;
		int[][] cover = new int[board.length + 2][board[0].length + 2];
		origin = new int[board.length + 2][board[0].length + 2];
		int len = board.length;
		int wid = board[0].length;
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= wid; j++) {
				cover[i][j] = board[i - 1][j - 1];
				origin[i][j] = board[i - 1][j - 1];
			}
		}
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= wid; j++)
				update(cover, i, j);
		}
		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= wid; j++)
				board[i - 1][j - 1] = cover[i][j];
		}
	}

	/*
	 * 当前细胞为存活状态时，当周围低于2个（不包含2个）存活细胞时， 该细胞变成死亡状态。（模拟生命数量稀少）
	 * 当前细胞为存活状态时，当周围有2个或3个存活细胞时， 该细胞保持原样。
	 * 当前细胞为存活状态时，当周围有3个以上的存活细胞时，该细胞变成死亡状态。（模拟生命数量过多）
	 * 当前细胞为死亡状态时，当周围有3个存活细胞时，该细胞变成存活状态。 （模拟繁殖）
	 */
	private void update(int[][] board, int i, int j) {
		// TODO Auto-generated method stub
		int alive = Cnt(board, i, j);
		if (board[i][j] == 1) {
			if (!(alive == 2 || alive == 3))
				board[i][j] = 0;
		} else if (alive == 3)
			board[i][j] = 1;
	}

	private int Cnt(int[][] board, int i, int j) {
		// TODO Auto-generated method stub
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 },
				{ -1, 1 }, { 1, -1 }, { 1, 1 } };
		int sum = 0;
		for (int k = 0; k < dir.length; k++) {
			int x = i + dir[k][0];
			int y = j + dir[k][1];
			if (origin[x][y] == 1)
				++sum;
		}
		return sum;
	}

}
