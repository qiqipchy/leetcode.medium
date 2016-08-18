import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		// 复杂度是O(nlog(k));
		// 注意t<0的情况是绝对不对的，两者有大小，所以at most一定是正的；

		if (k < 1 || nums.length == 0 || t < 0)
			return false;
		SortedSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {

			// 这个subSet保持最多k个元素，拿出来的是在范围之内的元素，看有没有；
			// 注意Integer在做运算的时候一定要考虑有没有越界的行为发生；
			// 注意运算转换的陷阱，下面这样的语句是不正确的；
			// long begin = -t + nums[i], end = nums[i] + t + 1;

			long begin = -t + (long)nums[i], end = (long)nums[i] + t + 1;

			SortedSet<Long> subSet = set.subSet(begin, end);
			if (!subSet.isEmpty())
				return true;
			// 维持一个为k的窗口;
			if (i >= k)
				set.remove(Long.valueOf(nums[i - k]));
			set.add(Long.valueOf(nums[i]));
		}
		return false;
	}

	public static void main(String[] args) {
		int nums[] = { -1, -1 };
		int k = 1;
		int t = -1;
		boolean flag = new Solution().containsNearbyAlmostDuplicate(nums, k, t);
		System.out.println(flag);
	}

}
