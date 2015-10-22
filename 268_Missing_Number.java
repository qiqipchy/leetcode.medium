public class Solution {
   public int missingNumber(int[] nums) {
       //注意不一定是有序的
       Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
        	if(nums[i]!=i)
        		return i;
        }
        return nums.length;
    }
}
