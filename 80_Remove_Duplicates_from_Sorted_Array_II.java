public class Solution {

	public int removeDuplicates(int[] nums) {
		if (nums.length == 1)
			return 1;
		int index = 0, length = nums.length;

		// 注意这里的length是常变的，不要写为nums.length；
		for (int i = 1; i < length; i++) {
			if (nums[i] == nums[i - 1]) {
				index = i + 1;
				int j = i + 1;

				// 注意这里的length是常变的，不要写为nums.length；
				while (j < length && nums[j] == nums[j - 1])
					j++;
				// j是第一个不相同的位置，把j之后的都搬过来；
				for (int k = j; k < length && index < length; k++, index++)
					nums[index] = nums[k];
				// 注意这里的length是常变的，不要写为nums.length；
				length = length - (j - i) + 1;

			}
		}
		return length;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 3, 3 };
		System.out.print("[");
		int length = new Solution().removeDuplicates(nums);
		for (int i = 0; i < length; i++)
			System.out.print(nums[i] + ",");
		System.out.print("]");
	}
}
