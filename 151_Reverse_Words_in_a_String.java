import java.util.Arrays;

public class Solution {
	public String reverseWords(String s) {
		// \s+表示一个或多个空格；
		// \s*表示0个或多个空格；
		String regex = "\\s+";
		String[] words = s.split(regex);
		String res = "";
		System.out.println(Arrays.toString(words));
		for (int i = 0, j = words.length - 1; i < j; i++, j--) {
			String temp = words[i];
			words[i] = words[j];
			words[j] = temp;
		}
		for (int i = 0; i < words.length; i++)
			res += words[i] + " ";

		System.out.println(res);
		return res.trim();

	}

	public static void main(String[] args) {
		String s = "ff the              id grij sdd jiji djsid";
		new Solution().reverseWords(s);
	}
}
