import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
public class Solution {
	public ListNode partition(ListNode head, int x) {
		List<Integer> list = new ArrayList<Integer>();
		ListNode copy = head;
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		head = copy;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) < x) {
				head.val = list.get(i);
				head = head.next;
				list.remove(i);
				// 注意这里的i--；
				i--;
			}
		}
		for (int i = 0; i < list.size(); i++) {
			head.val = list.get(i);
			head = head.next;

		}
		return copy;
	}

	
}
