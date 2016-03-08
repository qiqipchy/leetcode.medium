import java.util.ArrayList;
import java.util.List;

public class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		// 注意对特殊情况的解释；
		if (k == 0 || head == null)
			return head;
		ListNode middle = head, iter = head;
		int len = 0, toK = 0;
		List<Integer> list = new ArrayList<Integer>();

		while (iter != null) {
			list.add(iter.val);
			++len;
			iter = iter.next;
		}
		// 注意这里是需要取余的；
		k = k % len;
		while (toK < k) {
			middle = middle.next;
			toK++;
		}
		// len是长度，middle是第k个结点；
		int i = 0;
		while (middle != null) {
			middle.val = list.get(i++);
			middle = middle.next;
		}
		iter = head;
		while (i < list.size()) {
			iter.val = list.get(i);
			iter = iter.next;
			++i;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		ListThing treeThing = new ListThing(nums);
		treeThing.print(treeThing.root);
		// treeThing.print(root);
		System.out.println(new Solution().rotateRight(treeThing.root, 0));
		treeThing.print(treeThing.root);

	}
}
