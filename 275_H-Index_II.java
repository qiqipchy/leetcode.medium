public class Solution {
	public int hIndex(int[] citations) {
		if (citations.length == 0)
			return 0;
		// 有h篇是至少是h的引用，N-h不多于h的引用；
		int h = 0, size = citations.length, max = citations[size - 1];
		int p = 0;
		// 搞不清这个逻辑。。。。
		for (int i = 0; i < max; i++) {
			// System.out.println(citations[p]);

			if (size - 1 - i >= 0 && citations[size - i - 1] >i)
				h = i+1;
		}
		return h;
	}
	public static void main(String[] args) {
		int[] citations = {2,2,2,2,2,2};
		System.out.println(new Solution().hIndex(citations));
	}
}
