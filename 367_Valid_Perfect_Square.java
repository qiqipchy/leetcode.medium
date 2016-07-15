public class Solution {
	// 二分搜索；当在n的范围内搜索某个数的时候，可以使用二分搜索；
	public boolean isPerfectSquare(int num) {
		int begin = 0, end = num, mid;
		long product;
		while (begin <= end) {
			mid = (begin + end) / 2;
			// 注意这里的mid*mid的乘积有可能超过了int所能表示的范围；
			product = (long) mid * mid;
			System.out.println(product);
			if (product == num)
				return true;
			if (product > num)
				end = mid - 1;
			else
				begin = mid + 1;

		}
		return false;
	}

	public static void main(String[] args) {
		int num = 2147483647;
		System.out.println(new Solution().isPerfectSquare(num));
	}
}
