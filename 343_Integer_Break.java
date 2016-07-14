public class Solution {
	// n1=n/n2;
	// n1的n2幂的最大数
	//说是让找规律，我为什么要找加法的规律？找也应该找的是分割后乘法的规律啊。
	public int integerBreak(int n) {
		if (n < 4)
			return n - 1;
		int k = n % 3;
		if (k == 0)
			return (int) Math.pow(3, n / 3);
		else if (k == 2)
			return (int) Math.pow(3, n / 3) * 2;
		else
			return (int) Math.pow(3, n / 3 - 1) * 4;

	}

	public static void main(String[] args) {
		int n = 11;
		System.out.println(new Solution().integerBreak(n));
	}

}
