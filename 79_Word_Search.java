import java.util.Arrays;

public class Solution {
	// 回溯，需要用dfs；
	// 用flag保证一个元素不会使用两遍；
	boolean[][] flag;
	int si;
	int sj;
	int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public boolean exist(char[][] board, String word) {
		if (word.length() == 0 || board.length == 0)
			return false;
		if (word.length() > board.length * board[0].length)
			return false;
		char[] chs = word.toCharArray();
		char[][] coverBoard = new char[board.length + 2][board[0].length + 2];
		flag = new boolean[board.length + 2][board[0].length + 2];
		for (int i = 1; i < coverBoard.length - 1; i++) {
			for (int j = 1; j < coverBoard[0].length - 1; j++)
				coverBoard[i][j] = board[i - 1][j - 1];
		}

		for (int i = 1; i < coverBoard.length - 1; i++) {
			for (int j = 1; j < coverBoard[0].length - 1; j++) {

				if (coverBoard[i][j] == chs[0]) {
					// 这里也需要设置flag;
					flag[i][j] = true;
					si = i;
					sj = j;
					// System.out.println(i + " " + j);
					if (dfs(coverBoard, chs, 1, i, j))
						return true;
					// 如果是没有路径，这里也需要设置回来 ；
					flag[i][j] = false;

				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, char[] chs, int dep, int i, int j) {
		// TODO Auto-generated method stub
		if (dep == chs.length)
			return true;
		for (int k = 0; k < 4; k++) {
			int nexti = i + dir[k][0];
			int nextj = j + dir[k][1];
			// 注意不能和初始位置相同；
			if ((nexti == si && nextj == sj))
				continue;
			if (board[nexti][nextj] == chs[dep] && !flag[nexti][nextj]) {
				flag[nexti][nextj] = true;
				if (dfs(board, chs, dep + 1, nexti, nextj)) {
					// System.out.println("down");
					return true;
				}
				flag[nexti][nextj] = false;
			}

		}

		return false;
	}

	public static void main(String[] args) {
		String[] words = { "CAA", "AAA", "BCD" };
		char[][] board = new char[words.length][words[0].length()];
		for (int i = 0; i < words.length; i++)
			board[i] = words[i].toCharArray();
		String word = "AAB";
		boolean flag = new Solution().exist(board, word);
		System.out.println(flag);

	}
}
