import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	int index;

	public void nextPermutation(int[] nums) {
		int length = nums.length;
		int[] tempArray;
		if (nums.length == 0 || nums.length == 1)
			return;
		if (nums[length - 1] > nums[length - 2]) {
			int temp = nums[length - 1];
			nums[length - 1] = nums[length - 2];
			nums[length - 2] = temp;
			return;
		}
		if (isDecend(nums)) {
			reverse(nums);
			return;
		}
		int replaceLoc = findLastDisorder(nums);
		int maxIndex = findMin(nums, replaceLoc);
		tempArray = new int[length - replaceLoc - 1];
		// 交换过程
		// 将maxIndex对应的元素放在replaceLoc上，剩下的元素排序；
		System.out.println(replaceLoc + "----" + maxIndex);
		System.arraycopy(nums, replaceLoc, tempArray, 0, maxIndex - replaceLoc);
		System.out.println("---" + Arrays.toString(tempArray));
		System.arraycopy(nums, maxIndex + 1, tempArray, maxIndex - replaceLoc,
				length - maxIndex - 1);
		System.out.println("---" + Arrays.toString(tempArray));

		nums[replaceLoc] = nums[maxIndex];
		Arrays.sort(tempArray);
		System.arraycopy(tempArray, 0, nums, replaceLoc + 1, tempArray.length);

	}

	private int findMin(int[] nums, int replaceLoc) {
		// TODO Auto-generated method stub
		// 从后面的元素中找到比nums[replaceLoc]大最小的值；
		int min = Integer.MAX_VALUE, index = replaceLoc + 1;
		for (int i = replaceLoc + 2; i < nums.length; i++) {
			if (nums[i] - nums[replaceLoc] > 0
					&& nums[i] - nums[replaceLoc] < min) {
				min = nums[i] - nums[replaceLoc];
				index = i;
			}
			// System.out.println(max);
		}
		return index;
	}

	private int findLastDisorder(int[] nums) {
		// TODO Auto-generated method stub
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] <= nums[i - 1])
				continue;
			else {
				return i - 1;
			}
		}
		return 0;
	}

	private boolean isDecend(int[] nums) {
		// TODO Auto-generated method stub
		for (int i = 0; i < nums.length - 1; i++)
			if (nums[i] < nums[i + 1])
				return false;
		return true;
	}

	private void reverse(int[] nums) {
		// TODO Auto-generated method stub
		for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 2, 2, 7, 5, 4, 3, 2, 2, 1 };
		new Solution().nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
}
