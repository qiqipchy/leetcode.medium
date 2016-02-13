import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int key = nums[i];
			if (map.containsKey(key))
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}
		Set<Entry<Integer, Integer>> entries = map.entrySet();
		for (Entry<Integer, Integer> entry : entries) {
			if (entry.getValue() > nums.length / 3)
				list.add(entry.getKey());
		}
		return list;
	}
}
