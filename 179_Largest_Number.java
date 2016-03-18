import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public String largestNumber(int[] nums) {
		String[] str = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			str[i] = String.valueOf(nums[i]);
		}
		// 重写的函数注意其中的比较规则
		Arrays.sort(str, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		StringBuilder sb = new StringBuilder();
		if (str[0].charAt(0) == '0')
			return "0";
		for (int i = 0; i < str.length; i++)
			sb.append(str[i]);
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 30, 34, 9, 5 };
		System.out.println(new Solution().largestNumber(nums));
	}
}
