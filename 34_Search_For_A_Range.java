import java.util.Arrays;

public class Solution {

	public int[] searchRange(int[] nums, int target) {

		int left = 0, right = nums.length - 1, mid = 0;
		int index = -1;
		int[] range = { -1, -1 };
		if (nums.length == 1 && nums[0] == target) {
			range[0] = range[1] = 0;
			return range;
		}

		// 要求必须长度大于1才有效，所以需要单独处理长度为1的数组；
		while (left < right) {
			mid = (left + right) / 2;
			if (nums[mid] == target) {
				index = mid;
				break;
			}
			if (nums[mid] < target)
				left = mid + 1;
			else {
				right = mid - 1;
			}
		}
		// 在二分法中，最后剩下的是left，看一看left是否是符合的；
		if (nums[left] == target)
			index = left;
		System.out.println(index);
		if (index == -1)
			return range;

		// 这两个放在一起很焦灼，还是分开放吧；
		for (int i = index; i >= 0; i--) {
			if (nums[i] == target)
				range[0] = i;
			else
				break;
		}
		for (int i = index; i < nums.length; i++) {
			if (nums[i] == target)
				range[1] = i;
			else
				break;
		}
		return range;

	}

	public static void main(String[] args) {
		int[] nums = { 1, 4 };
		int target = 4;
		System.out.println(Arrays.toString(new Solution().searchRange(nums,
				target)));
	}
}
