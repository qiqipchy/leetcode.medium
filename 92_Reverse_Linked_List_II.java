import java.util.ArrayList;
import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null || head.next == null || m == n)
			return head;
		List<ListNode> list = new ArrayList<ListNode>();
		ListNode iter = head;
		int count = 0;
		while (iter != null) {
			count++;
			// 就是不停的从后向前进行反转
			if (count >= m && count < n) {
				list.add(iter);
				for (int i = list.size() - 1; i >= 0; i--) {
					ListNode node = list.get(i);
					int temp = node.val;
					node.val = node.next.val;
					node.next.val = temp;
				}
			}
			iter = iter.next;
		}
		return head;
	}
	public ListNode createList(ListNode root, int... args) {
		ListNode pre = null;
		for (int i : args) {
			if (root == null) {
				root = new ListNode(i);
				pre = root;
			} else {
				pre.next = new ListNode(i);
				pre = pre.next;
			}
		}
		return root;
	}
	public void printList(ListNode root) {
		while (root != null) {
			System.out.print(root.val + " => ");
			root = root.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode root = solution.createList(null,
				new int[]{1, 2, 3, 4, 5, 6, 7});
		solution.printList(root);
		solution.reverseBetween(root, 2,6);
		solution.printList(root);
	}
}
