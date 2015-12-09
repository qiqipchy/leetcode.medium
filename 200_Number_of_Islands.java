public class Solution {
    boolean[][] visit;
   public int numIslands(char[][] grid) {
       if(grid.length==0) return 0;
		visit = new boolean[grid.length][grid[0].length];
		int cnt = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1' && !visit[i][j]) {
					// System.out.println("i--->" + i + " j---->" + j);
					dfs(i, j, grid);
					cnt++;
				}
			}
		}
		return cnt;
	}

	private void dfs(int i, int j, char[][] grid) {
		// TODO Auto-generated method stub
		if (i > grid.length - 1 || i < 0 || j > grid[0].length - 1 || j < 0
				|| visit[i][j] == true)
			return;
		if (grid[i][j] == '0')
			return;
		else
			visit[i][j] = true;
		dfs(i + 1, j, grid);
		dfs(i - 1, j, grid);
		dfs(i, j + 1, grid);
		dfs(i, j - 1, grid);
	}

}
