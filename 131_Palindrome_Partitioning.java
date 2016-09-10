import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	List<List<String>> res = new ArrayList<List<String>>();
	public List<List<String>> partition(String s) {
		if (s.length() == 0)
			return res;
		dfs(s, "");
		return res;
	}
	private void dfs(String s, String path) {
		// TODO Auto-generated method stub
		if (s.length() == 0) {
			System.out.println(path);
			res.add(Arrays.asList(path.split(" ")));
		}
		for (int i = 1; i <= s.length(); i++) {
			boolean isPalindrome = false;
			String sub = s.substring(0, i);
			int k, p;
			for (k = 0, p = sub.length() - 1; k < p
					&& sub.charAt(k) == sub.charAt(p); k++, p--);
			if (k >= p) {
				dfs(s.substring(sub.length()), path + sub + " ");
			}
		}
	}
	public static void main(String[] args) {
		String s = "ababababababababbbbbbbbabab";
		System.out.println(new Solution().partition(s));
	}
}
