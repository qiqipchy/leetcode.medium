import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	// 计算两遍
	public int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			output[i] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			output[i] = output[i + 1] * nums[i + 1];
		}
		int front = 1;
		for (int i = 0; i < nums.length; i++) {
			output[i] *= front;
			front *= nums[i];
		}
		System.out.println(Arrays.toString(output));
		return output;
	}

	public static void main(String[] args) {
		int[] nums = { 0,0 };
		System.out.println(new Solution().productExceptSelf(nums));
	}
}
