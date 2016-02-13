import java.util.Hashtable;
import java.util.Set;

public class Solution {
	public int singleNumber(int[] nums) {
		Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (ht.containsKey(nums[i])) {
				if (ht.get(nums[i]) == 1)
					ht.put(nums[i], 2);
				else
					ht.remove(nums[i]);
			} else
				ht.put(nums[i], 1);
		}
		Set<Integer> keySet = ht.keySet();
		for (Integer i : keySet)
			return i;
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 2, 3, 3, 4, 3 };
		System.out.println(new Solution().singleNumber(nums));
	}
}
