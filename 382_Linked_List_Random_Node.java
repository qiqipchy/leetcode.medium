import java.util.Random;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

// 蓄水池抽样

// 描述为：先把前k个数取出来放到结果集中，然后从k+1开始遍历，
// 每遇到一个数就以k/k+n（其中n从1开始递增）的概率把它取出来，然后再以1/k的概率从结果集中取出来一个数，
// 最后用前者替换掉后者。
/*
 * 1、文字描述：假设当前为第n个数，那么n最后留在结果集中的概率 = n被选中的概率 * [n后面的数没有被选中的概率 +
 * n后面的数被选中的概率*n没有被替换的概率]， 如果数据总数量为N，那么最终结果是每个数取出的概率都为k/N。
 */
public class Solution {

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	ListNode head;
	int val;

	public Solution(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		val = head.val;
		ListNode iter = head.next;
		for (int i = 1; iter != null; i++) {
			// 经过上面的公式，当添加新的数进来的时候总数为n，前面的数被替换的总概率为1/n;
			int rand = new Random().nextInt(i + 1);
			if (rand == 0)
				val = iter.val;
			iter = iter.next;
		}
		return val;
	}
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(head); int param_1 = obj.getRandom();
 */
