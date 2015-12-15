import java.util.Arrays;

public class Solution {

	public boolean search(int[] nums, int target) {
		// 找到降序的元素，作为分支点，对两部分分别使用二分法寻找；
		int i = 0;
		for (i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1])
				break;
		}
		// i就是分水岭；
		if (i == nums.length - 1)
			// 注意这里是大于等于0，不要忘记等于0
			return Arrays.binarySearch(nums, target) >= 0 ? true : false;
		int left = Arrays.binarySearch(nums, 0, i + 1, target);
		if (left >= 0)
			return true;
		int right = Arrays.binarySearch(nums, i + 1, nums.length, target);
		return right >= 0 ? true : false;
	}

	public static void main(String[] args) {
		int[] nums = { 1 };
		int target = 1;
		System.out.println(new Solution().search(nums, target));
	}
}
