import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public boolean isSubsequence(String s, String t) {
		// 在s中寻找t，t很小，s很大；
		int pre = -1;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			// 找不到一个；
			if (t.indexOf(ch) < 0)
				return false;
			int fromIndex = 0, index;
			boolean flag = false;

			while ((index = t.indexOf(ch, fromIndex)) != -1) {
				// 找第一个数的时候；
				if (pre == -1 || index > pre) {
					flag = true;
					pre = index;
					break;
				} else
					fromIndex = index + 1;

			}
			if (!flag)
				return false;
		}
		return true;

	}
	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		System.out.println(new Solution().isSubsequence(s, t));
	}
}
