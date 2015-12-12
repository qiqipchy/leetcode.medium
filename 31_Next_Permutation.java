public class Solution {
    int index;

	public void nextPermutation(int[] nums) {

		int replaceLoc = findLastAscend(nums);
		if (replaceLoc == -1) {
			reverse(0, nums);
			return;
		}
		int minIndex = findMin(nums, replaceLoc);
		
		// System.out.println(replaceLoc + " " + minIndex);
		int temp = nums[replaceLoc];
		nums[replaceLoc] = nums[minIndex];
		nums[minIndex] = temp;
		// System.out.println(Arrays.toString(nums));
		reverse(replaceLoc + 1, nums);

	}

	private int findMin(int[] nums, int replaceLoc) {
		// TODO Auto-generated method stub
		// 从后面的元素中找到比nums[replaceLoc]大最小的值；
		int min = Integer.MAX_VALUE, index = replaceLoc + 1;
		for (int i = replaceLoc + 2; i < nums.length; i++) {
			if (nums[i] - nums[replaceLoc] > 0
					&& nums[i] - nums[replaceLoc] <= min) {
				min = nums[i] - nums[replaceLoc];
				index = i;
			}
			// System.out.println(max);
		}
		return index;
	}

	private int findLastAscend(int[] nums) {
		// TODO Auto-generated method stub
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] <= nums[i - 1])
				continue;
			else {
				return i - 1;
			}
		}
		return -1;
	}

	private void reverse(int begin, int[] nums) {
		// TODO Auto-generated method stub
		for (int i = begin, j = nums.length - 1; i < j; i++, j--) {
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		}
	}
}
