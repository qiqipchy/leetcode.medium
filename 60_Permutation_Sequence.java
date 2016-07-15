import java.util.ArrayList;
import java.util.List;

public class Solution {
	// 使用递归的方法确定每一位；
	public String getPermutation(int n, int k) {
		List<Integer> visit = new ArrayList<Integer>();
		for (int i = 0; i <= n; i++)
			visit.add(i);
		int[] cnt = new int[n + 1];
		cnt[0] = cnt[1] = 1;
		String s = "";
		for (int i = 2; i <= n; i++) {
			cnt[i] = cnt[i - 1] * i;
		}
		int length;
		while (n > 0) {
			length = k / cnt[n - 1];
			if (k % cnt[n - 1] == 0)
				k = cnt[n - 1];
			else {
				length++;
				k = k % cnt[n - 1];
			}
			s += String.valueOf(visit.get(length));
			visit.remove(length);
			n--;
		}
		System.out.println(s);
		return s;
	}
}
