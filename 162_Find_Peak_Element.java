import java.util.Arrays;

public class Solution {
	public int findPeakElement(int[] nums) {
		int length = nums.length;
		if (nums.length == 1)
			return 0;
		if (nums[0] > nums[1])
			return 0;
		if (nums[length - 1] > nums[length - 2])
			return length - 1;
		for (int i = 1; i < length - 1; i++) {
			if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1])
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 91, 72, 3, 4, 5, 6 };
		System.out.println(new Solution().findPeakElement(nums));
	}
}
