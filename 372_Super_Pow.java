public class Solution {
	// 一步一步算；
	int N = 1337;

	// 有些变量还是需要long类型的；
	public int superPow(int a, int[] b) {
		long sum = 0;
		for (int i = 0; i < b.length; i++) {
			int k = 0, j = 0, iter = (int) sum;
			long rest = 1;
			// 一定要自己循环做，使用Math.pow容易越界；
			while (k < b[i]) {
				rest = a * rest % N;
				k++;
			}
			if (i == 0) {
				sum = rest;
				continue;
			}
			// 已经有一个sum了，所以做乘法的时候使用9个就可以了；
			while (j < 9) {
				// sum=sum*10+b;
				sum = sum * iter % N;
				j++;
			}
			sum = (sum * rest) % N;
		}
		return (int) sum;
	}

	public static void main(String[] args) {
		int a = 2147483647;
		int[] b = { 2, 0, 0 };
		System.out.println(new Solution().superPow(a, b));
	}
}
