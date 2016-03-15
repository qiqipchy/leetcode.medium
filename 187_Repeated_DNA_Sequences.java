import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/*
 * 所有判断是否有两次出现的问题都可以用hashTable来解决；
 */
public class Solution {
	public List<String> findRepeatedDnaSequences(String s) {
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		List<String> list = new ArrayList<String>();
		for (int i = 0; i <= s.length() - 10; i++) {
			String ten = s.substring(i, i + 10);
			System.out.println(ten);
			if (ht.containsKey(ten)) {
				if (ht.get(ten) == 1)
					list.add(ten);
				ht.put(ten, ht.get(ten) + 1);
			} else
				ht.put(ten, 1);
		}
		return list;
	}

	public static void main(String[] args) {
		String s = "AAAAAAAAAAA";
		System.out.println(new Solution().findRepeatedDnaSequences(s));
	}
}
