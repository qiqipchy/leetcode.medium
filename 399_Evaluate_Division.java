import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Solution {
	double[] res;
	double vaule;
	boolean falg;
	HashMap<String, HashMap<String, Double>> map = new HashMap<String, HashMap<String, Double>>();
	public double[] calcEquation(String[][] equations, double[] values,
			String[][] queries) {
		res = new double[queries.length];
		for (int i = 0; i < equations.length; i++) {
			String divide = equations[i][0], divided = equations[i][1];
			if (!map.containsKey(divide))
				map.put(divide, new HashMap<String, Double>());
			if (!map.containsKey(divided))
				map.put(divided, new HashMap<String, Double>());
			map.get(divide).put(divided, values[i]);
			map.get(divided).put(divide, 1 / values[i]);
		}
		Set<String> sets = map.keySet();
		for (String s : sets)
			System.out.println(s + " => " + map.get(s));

		for (int i = 0; i < queries.length; i++) {
			String divide = queries[i][0], divided = queries[i][1];
			// 不含有是1.0
			if (!map.containsKey(divide) || !map.containsKey(divided))
				res[i] = -1.0;
			// 含有是而且相等是1.0；
			else if (map.containsKey(divide) && (divide.equals(divided))) {
				res[i] = 1.0;
			} else {
				cal(divide, divided, divide, 1.0);
				// 有可能没有找到，不存在这样的一个数据链；
				res[i] = falg ? vaule : -1.0;
				// 注意要把这个flag恢复；
				falg = false;
			}
		}
		return res;
	}
	private void cal(String divide, String divided, String iter, double value) {
		// TODO Auto-generated method stub
		System.out.println(divide + " " + iter);
		if (iter.equals(divided)) {
			this.vaule = value;
			falg = true;
			return;
		}
		HashMap<String, Double> linkedlist = map.get(iter);
		Set<String> sets = linkedlist.keySet();
		for (String key : sets) {
			double temp = linkedlist.get(key);
			if (temp > 0) {
				linkedlist.put(key, -23.0);
				cal(divide, divided, key, value * temp);
				linkedlist.put(key, temp);
				if (falg)
					return;
			}
		}
	}
	public static void main(String[] args) {
		String[][] equations = {{"x1", "x2"}, {"x2", "x3"}, {"x3", "x4"},
				{"x4", "x5"}};
		double[] values = {3.0, 4.0, 5.0, 6.0};
		String[][] queries = {{"x1", "x5"}, {"x5", "x2"}, {"x2", "x4"},
				{"x2", "x2"}, {"x2", "x9"}, {"x9", "x9"}};

		double[] res = new Solution().calcEquation(equations, values, queries);
		System.out.println(Arrays.toString(res));
	}
}
