public class Solution {
	public int bulbSwitch(int n) {
		// 约数都是成对出现的，除了完全平方数是单个的；
		return (int) Math.sqrt(n);
	}

	public static void main(String[] args) {
		int n = 9999999;
		System.out.println(new Solution().bulbSwitch(n));
	}
}
