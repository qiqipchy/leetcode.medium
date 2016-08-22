public class Solution {
   // dp[i][j]记录的是以i,j为右下角的正方形的边长;
	public int maximalSquare(char[][] matrix) {
        if(matrix.length==0)
			return 0;
		int row=matrix.length,col=matrix[0].length;
		int[][] dp=new int[row][col];
		
		// 刚开始最大的是0;
		int max=0;
		for(int i=0;i<row;i++){
			dp[i][0]=matrix[i][0]-'0';
			if(dp[i][0]==1)
				max=1;
		}
		for(int j=0;j<col;j++){
			dp[0][j]=matrix[0][j]-'0';
			if(dp[0][j]==1)
				max=1;
		}
		
		for(int i=1;i<row;i++)
		{
			for(int j=1;j<col;j++)
			{
				if(matrix[i][j]=='0')
					dp[i][j]=0;
				else{
					dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
					if(dp[i][j]>max)
						max=dp[i][j];
				}
			}
		}
		return max*max;

    }
}
