public class Solution {

    int[] nums;
	int[] temp;
    Random random;
	public Solution(int[] nums) {
		this.nums = new int[nums.length];
		temp = new int[nums.length];
		random = new Random();
		System.arraycopy(nums, 0, this.nums, 0, nums.length);
		System.arraycopy(nums, 0, temp, 0, nums.length);

	}

	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
	    System.arraycopy(temp, 0, nums, 0, temp.length);
		return temp;

	}

	/** Returns a random shuffling of the array. */
    /** Returns a random shuffling of the array. */
	public int[] shuffle() {
		int temp = 0;
		for (int i = 0; i < nums.length; i++) {
			// 这里是i+1，有可能得到原来的数据；
			int index = random.nextInt(i + 1);
			temp = nums[index];
			nums[index] = nums[i];
			nums[i] = temp;
		}
		return nums;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
