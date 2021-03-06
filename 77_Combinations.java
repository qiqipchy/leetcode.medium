public class Solution {
    // 递归效率太低，使用一个数组，用1代表选了，0代表没选；
	// 找到最后一个10组合，就是可以交换的，交换1，0，然后把后面的所有1都向前排列；
	int[] choosen;
	List<List<Integer>> list = new ArrayList<List<Integer>>();

	public List<List<Integer>> combine(int n, int k) {
		choosen = new int[n];
		for (int i = 0; i < k; i++)
			choosen[i] = 1;
		int replaceLoc = findLast12Change();
		while (replaceLoc != 0) {
			// System.out.println(replaceLoc);
			// System.out.println(Arrays.toString(choosen));
			genList();
			adjust(replaceLoc);

			replaceLoc = findLast12Change();
		}
		genList();
		return list;
	}

	private void adjust(int replaceLoc) {
		// TODO Auto-generated method stub
		choosen[replaceLoc] = 1;
		choosen[replaceLoc - 1] = 0;
		int cnt = 0;
		for (int k = replaceLoc + 1; k < choosen.length; k++) {
			if (choosen[k] == 1)
				cnt++;
		}
		for (int k = replaceLoc + 1; k <= replaceLoc + cnt; k++)
			choosen[k] = 1;
		for (int k = replaceLoc + cnt + 1; k < choosen.length; k++)
			choosen[k] = 0;
	}

	private void genList() {
		// TODO Auto-generated method stub
		List<Integer> listOne = new ArrayList<Integer>();
		for (int i = 0; i < choosen.length; i++) {
			if (choosen[i] == 1)
				listOne.add(i + 1);
		}
		list.add(listOne);
	}

	private int findLast12Change() {
		// TODO Auto-generated method stub
		int length = choosen.length;
		for (int i = length - 1; i > 0; i--) {
			if (choosen[i] == 0 && choosen[i - 1] == 1)
				// 返回的是0的位置，和前一位进行交换；
				return i;
		}
		return 0;
	}
}
