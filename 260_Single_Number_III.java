import java.util.Arrays;
import java.util.Hashtable;
import java.util.Set;

public class Solution {
	public int[] singleNumber(int[] nums) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
		int[] res = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (ht.containsKey(nums[i])) {
				ht.remove(nums[i]);
			} else
				ht.put(nums[i], 1);
		}
		Set<Integer> keySet = ht.keySet();
		int k = 0;
		for (Integer i : keySet)
			res[k++] = i;
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2, 3, 3, 4, 5 };
		System.out.println(Arrays.toString(new Solution().singleNumber(nums)));
	}
}
