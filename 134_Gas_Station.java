public class Solution {
   // gas[i]是i个地点有的汽油数,cost[i]是从i到i+1;
    public int canCompleteCircuit(int[] gas, int[] cost) {
		if(gas.length==0)
			return -1;
		int[] own=new int[gas.length];
		int index=0;
		own[0]=gas[0]-cost[0];
		
			
		for(int i=1;i<gas.length;i++)
		{
			if(own[i-1]<0)
			{
				 own[i]=gas[i]-cost[i];
				 index=i;
			}
			else{
				own[i]=gas[i]-cost[i]+own[i-1];
			}
		    
		}
		// 在循环中最后一位没有进行判断是否大于0;
		// 在第一遍的循环中,到最后一位应该是大于等于0的;
		int left=own[own.length-1];
		if(left<0)
			return -1;
			
		//System.out.println(Arrays.toString(own)+" "+index);
		if(index==0)
			return 0;
		
		// 检查一下前面的这一段,回来的这一段	
		for(int i=0;i<index;i++)
		{
			own[i]=gas[i]-cost[i]+own[(i+own.length-1)%own.length];
			if(own[i]<0)
				return -1;
		}
		return index;
    }
 
 
}
