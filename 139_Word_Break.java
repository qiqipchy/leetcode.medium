import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
	// wordDict中的单词可以使用不止一次；
	public boolean wordBreak(String s, Set<String> wordDict) {
		// valid[i]表示s中的前i个字母都可以由wordDict中的字母组成。
		boolean[] valid = new boolean[s.length() + 1];
		valid[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (valid[j] && wordDict.contains(s.substring(j, i))) {
					valid[i] = true;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(valid));
		return valid[s.length()];
	}

	public static void main(String[] args) {
		String s = "leetcodeleetleetcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(new Solution().wordBreak(s, wordDict));
	}
}
