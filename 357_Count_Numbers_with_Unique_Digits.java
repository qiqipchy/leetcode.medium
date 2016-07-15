public class Solution {
	// 直接用排列组合啊，用什么减法。。。
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0)
			return 1;
		int res = 10;
		for (int i = 2; i <= n; i++) {
			System.out.println(res + "-----------");
			int k = 1, product = 9;
			while (k != i) {
				product *= (10 - k);
				k++;
			}
			res += product;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 4;
		System.out.println(new Solution().countNumbersWithUniqueDigits(n));
	}
}
