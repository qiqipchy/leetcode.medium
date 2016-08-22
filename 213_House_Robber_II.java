public class Solution {
     public int rob(int[] nums) {
        if(nums.length==0)
			return 0;
		if(nums.length==1)
			return nums[0];
		int[] dp=new int[nums.length];
		// 不抢第一个;
		dp[0]=0;
		dp[1]=nums[1];
		for(int i=2;i<nums.length;i++)
			dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
		
		int[] rob=new int[nums.length];
		// 抢第一个;
		rob[0]=nums[0];
		rob[1]=Math.max(nums[0],nums[1]);
		for(int i=2;i<nums.length;i++)
			rob[i]=Math.max(rob[i-1],rob[i-2]+nums[i]);
		
		int n=nums.length;
		if(rob[n-1]==rob[n-2])
			return Math.max(rob[n-1],dp[n-1]);
		else
			return Math.max(rob[n-2],dp[n-1]);
    }
}
