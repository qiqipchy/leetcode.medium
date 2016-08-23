public class Solution {
    // DP进行递归,选择每次的root是不同的就可以了;
	// dp[n]表示以n为root,n之前的点做过root了;
    public int numTrees(int n) {
		int[] dp=new int[n+1];
		dp[0]=1;
		for(int i=1;i<=n;i++)
		{
			for(int j=0;j<i;j++)
				//注意这里是i-1,因为有一个作为root了
				dp[i]+=dp[j]*dp[i-1-j];
		}
        return dp[n];
    }
}
