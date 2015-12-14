import java.util.Arrays;

public class Solution {
	public void sortColors(int[] nums) {
		int r = 0, b = 0;
		for (int i = 0; i < nums.length; i++) {
			switch (nums[i]) {
			case 0:
				r++;
				break;
			case 1:
				b++;
				break;
			}
		}
		for (int i1 = 0; i1 < r; i1++)
			nums[i1] = 0;
		for (int i1 = r; i1 < r + b; i1++)
			nums[i1] = 1;
		for (int i1 = r + b; i1 < nums.length; i1++)
			nums[i1] = 2;
		System.out.println(Arrays.toString(nums));
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 0, 0, 2, 2, 1 };
		new Solution().sortColors(nums);
	}
}
