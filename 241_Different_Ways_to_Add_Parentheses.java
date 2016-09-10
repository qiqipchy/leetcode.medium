import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<Integer> nums = new ArrayList<Integer>();
	List<Character> ops = new ArrayList<Character>();
	public List<Integer> diffWaysToCompute(String input) {

		int i = 0;
		while (i < input.length()) {
			char ch = input.charAt(i);
			if (!(ch <= '9' && ch >= '0')) {
				ops.add(ch);
				i++;
				continue;
			}
			int sum = 0;
			while (ch <= '9' && ch >= '0') {
				sum = sum * 10 + ch - '0';
				if (++i < input.length())
					ch = input.charAt(i);
				else
					break;
			}
			nums.add(sum);

		}
		System.out.println(nums);
		System.out.println(ops);
		return divide(0, nums.size());
	}
	private List<Integer> divide(int begin, int end) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		if (begin + 1 == end) {
			list.add(nums.get(begin));
			return list;
		}
		for (int i = begin + 1; i < end; i++) {
			List<Integer> nums1 = divide(begin, i);
			List<Integer> nums2 = divide(i, end);
			for (int p = 0; p < nums1.size(); p++) {
				for (int k = 0; k < nums2.size(); k++) {
					int res, left = nums1.get(p), right = nums2.get(k);
					char op = ops.get(i - 1);
					res = cal(left, right, op);
					list.add(res);
				}
			}
		}
		return list;
	}
	private int cal(int left, int right, char op) {
		// TODO Auto-generated method stub
		int res = 0;
		switch (op) {
			case '+' :
				res = left + right;

				break;
			case '-' :
				res = left - right;
				break;
			case '*' :
				res = left * right;
				break;
			case '/' :
				res = left / right;
				break;
			default :
				break;
		}
		return res;
	}
	public static void main(String[] args) {
		String input = "2*3-4*5";
		System.out.println(new Solution().diffWaysToCompute(input));
	}
}
