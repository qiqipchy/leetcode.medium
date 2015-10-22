import java.util.Arrays;

public class Solution {
	public int[] singleNumber(int[] nums) {
        int[] single=new int[2];
        int cnt=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
        {
        	if(cnt==2) return single;
        	if(nums[i]==nums[i+1])
        	//注意相等的话，需要将下一个i跳过；
        		i++;
        	else {
				single[cnt++]=nums[i];
			}
        }
        single[cnt]=nums[nums.length-1];
        return single;
    }
	public static void main(String[] args) {
		int[] nums={1,2,2,3,3,4};
		int[] single=new Solution().singleNumber(nums);
		System.out.println(Arrays.toString(single));
	}
}
