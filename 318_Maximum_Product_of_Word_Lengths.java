public class Solution {
	public int maxProduct(String[] words) {
		int len = words.length;
		int[] mask = new int[len];
		for (int i = 0; i < words.length; i++) {
			for (int k = 0; k < words[i].length(); k++)
				// 使用掩码对每一个单词进行记录；
				mask[i] |= 1 << words[i].charAt(k) - 'a';
		}
		int max = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if ((mask[i] & mask[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String[] words = { "hello", "world", "java" };
		int max = new Solution().maxProduct(words);
		System.out.println(max);
	}
}
