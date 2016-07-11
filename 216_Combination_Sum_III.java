import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	List<List<Integer>> combinations;
	List<Integer> combination;
	boolean visit[];
	int N = 10;

	public List<List<Integer>> combinationSum3(int k, int n) {
		combination = new ArrayList<Integer>();
		combinations = new ArrayList<List<Integer>>();
		visit = new boolean[N];

		dfs(k, n, 0);
		for (List<Integer> combination : combinations)
			System.out.println(combination);
		return combinations;
	}

	private void dfs(int k, int n, int sum) {
		// TODO Auto-generated method stub
		if (sum == n && k == 0) {
			List<Integer> temp = new ArrayList<Integer>(combination);
			Collections.sort(temp);
			if (!combinations.contains(temp))
				combinations.add(new ArrayList<Integer>(temp));
			return;
		} else if (k == 0 || sum == n)
			return;
		for (int i = 1; i < N && i <= n - sum; i++) {
			if (!visit[i]) {
				combination.add(i);
				visit[i] = true;
				int length = combination.size() - 1;
				dfs(k - 1, n, sum + i);
				visit[i] = false;
				while (combination.size() > length)
					combination.remove(combination.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		int k = 3;
		int n = 9;
		new Solution().combinationSum3(k, n);
	}
}
