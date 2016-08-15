import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> one = new ArrayList<Integer>();
		// 使用par记录，进行回溯；
		// 这种使用parent的方法很巧妙;
		int[] par = new int[nums.length];
		int[] len = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			par[i] = i;
		int max = 0, index = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			len[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (len[i] < len[j] + 1) {
						len[i] = len[j] + 1;
						par[i] = j;
					}
				}
			}
			if (len[i] > max) {
				max = len[i];
				index = i;
			}
		}
		while (index >= 0 && one.size() < max) {
			one.add(nums[index]);
			index = par[index];
		}
		return one;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 4, 8, 12, 24, 120, };
		System.out.println(new Solution().largestDivisibleSubset(nums));
	}
}
