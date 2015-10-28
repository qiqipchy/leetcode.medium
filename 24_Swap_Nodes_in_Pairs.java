
//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode first = head, second = first.next;
		while (true) {
			int temp = first.val;
			first.val = second.val;
			second.val = temp;

			if (second.next == null)
				return head;
			first = second.next;
			if (first.next == null)
				return head;
			second = first.next;

		}

	}

	public ListNode InitialList() {
		int[] nums = { 1, 2, 3, 4 };
		ListNode head = null, r = null, p = null;
		for (int i = 0; i < nums.length; i++) {
			if (head == null) {
				head = new ListNode(nums[i]);
				p = head;
				continue;
			}
			r = new ListNode(nums[i]);
			p.next = r;
			p = r;
		}
		return head;
	}

	private void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "->");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode head = solution.InitialList();
		solution.swapPairs(head);
		solution.printList(head);
	}
}
