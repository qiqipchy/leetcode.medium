import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
	int size;
	String min = "";
	List<String> path;
	HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();

	public List<String> findItinerary(String[][] tickets) {

		path = new ArrayList<String>();
		size = tickets.length;
		for (int i = 0; i < tickets.length; i++) {
			String from = tickets[i][0];
			String to = tickets[i][1];
			if (!map.containsKey(from))
				map.put(from, new PriorityQueue<String>());
			map.get(from).add(to);
		}
		// Set<String> keySet = map.keySet();
		// for (String key : keySet)
		// System.out.println(key + ":" + map.get(key));

		dfs("JFK");

		return path;
	}

	// 需要使用的是贪心的算法，每一个城市开始访问的下一个城市都是最小的，这样遍历整个图得到的也是
	// 最小的路径；
	private void dfs(String from) {
		// TODO Auto-generated method stub
		while (map.containsKey(from) && !map.get(from).isEmpty()) {
			dfs(map.get(from).poll());
		}
		path.add(0, from);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		String[][] tickets = { { "AXA", "EZE" }, { "EZE", "AUA" },
				{ "ADL", "JFK" }, { "ADL", "TIA" }, { "AUA", "AXA" },
				{ "EZE", "TIA" }, { "EZE", "TIA" }, { "AXA", "EZE" },
				{ "EZE", "ADL" }, { "ANU", "EZE" }, { "TIA", "EZE" },
				{ "JFK", "ADL" }, { "AUA", "JFK" }, { "JFK", "EZE" },
				{ "EZE", "ANU" }, { "ADL", "AUA" }, { "ANU", "AXA" },
				{ "AXA", "ADL" }, { "AUA", "JFK" }, { "EZE", "ADL" },
				{ "ANU", "TIA" }, { "AUA", "JFK" }, { "TIA", "JFK" },
				{ "EZE", "AUA" }, { "AXA", "EZE" }, { "AUA", "ANU" },
				{ "ADL", "AXA" }, { "EZE", "ADL" }, { "AUA", "ANU" },
				{ "AXA", "EZE" }, { "TIA", "AUA" }, { "AXA", "EZE" },
				{ "AUA", "SYD" }, { "ADL", "JFK" }, { "EZE", "AUA" },
				{ "ADL", "ANU" }, { "AUA", "TIA" }, { "ADL", "EZE" },
				{ "TIA", "JFK" }, { "AXA", "ANU" }, { "JFK", "AXA" },
				{ "JFK", "ADL" }, { "ADL", "EZE" }, { "AXA", "TIA" },
				{ "JFK", "AUA" }, { "ADL", "EZE" }, { "JFK", "ADL" },
				{ "ADL", "AXA" }, { "TIA", "AUA" }, { "AXA", "JFK" },
				{ "ADL", "AUA" }, { "TIA", "JFK" }, { "JFK", "ADL" },
				{ "JFK", "ADL" }, { "ANU", "AXA" }, { "TIA", "AXA" },
				{ "EZE", "JFK" }, { "EZE", "AXA" }, { "ADL", "TIA" },
				{ "JFK", "AUA" }, { "TIA", "EZE" }, { "EZE", "ADL" },
				{ "JFK", "ANU" }, { "TIA", "AUA" }, { "EZE", "ADL" },
				{ "ADL", "JFK" }, { "ANU", "AXA" }, { "AUA", "AXA" },
				{ "ANU", "EZE" }, { "ADL", "AXA" }, { "ANU", "AXA" },
				{ "TIA", "ADL" }, { "JFK", "ADL" }, { "JFK", "TIA" },
				{ "AUA", "ADL" }, { "AUA", "TIA" }, { "TIA", "JFK" },
				{ "EZE", "JFK" }, { "AUA", "ADL" }, { "ADL", "AUA" },
				{ "EZE", "ANU" }, { "ADL", "ANU" }, { "AUA", "AXA" },
				{ "AXA", "TIA" }, { "AXA", "TIA" }, { "ADL", "AXA" },
				{ "EZE", "AXA" }, { "AXA", "JFK" }, { "JFK", "AUA" },
				{ "ANU", "ADL" }, { "AXA", "TIA" }, { "ANU", "AUA" },
				{ "JFK", "EZE" }, { "AXA", "ADL" }, { "TIA", "EZE" },
				{ "JFK", "AXA" }, { "AXA", "ADL" }, { "EZE", "AUA" },
				{ "AXA", "ANU" }, { "ADL", "EZE" }, { "AUA", "EZE" } };
		System.out.println(solution.findItinerary(tickets));
	}
}
