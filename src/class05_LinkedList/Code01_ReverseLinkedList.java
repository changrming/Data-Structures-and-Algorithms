/**
 * 
 */
package class05_LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chang pre cur head ^ | |____|
 * 
 */

public class Code01_ReverseLinkedList {
	public static Node ReverseLinkedList(Node head) {
		if (head == null)
			return null;
		Node cur = head, pre = null;
		head = head.next;
		while (cur != null) {
			cur.next = pre;
			if (head != null)
				head = head.next;
			pre = cur;
			cur = head;
		}
		return pre;

	}

	public static void main(String[] args) {
		for (int i = 0; i < 20000; i++) {
			int len = (int) (Math.random() * 15);
			Node res = generateNode(len);
			Node pre = res;
			List<Node> list1 = new ArrayList<>();
			List<Node> list2 = new ArrayList<>();

			while (res != null) {
				list1.add(res);
				res = res.next;
			}
			Node ans = ReverseLinkedList(pre);
			Node pre1 = ans;
			while (ans != null) {
				list2.add(ans);
				ans = ans.next;
			}
			for (int j = 0; j < len; j++) {
				if (list1.get(j) != list2.get(len - 1 - j)) {
					System.out.println("chucuola");
				}
			}
		}
		System.out.println("end");
	}

	public static Node copyNode(Node node) {
		if (node == null)
			return null;
		Node head = new Node(node.val), dummy = new Node(0);
		dummy.next = head;
		while (node.next != null) {
			node = node.next;
			head.next = new Node(node.val);
			head = head.next;
		}
		return dummy.next;
	}

	public static Node generateNode(int length) {
		int[] arr = new int[length];
		Node dummy = new Node(0), pre = dummy;
		for (int i = 0; i < length; i++) {
			arr[i] = (int) (Math.random() * 30);
			dummy.next = new Node(arr[i]);
			dummy = dummy.next;
		}
		// for(int i=arr.length-1;i>=0;i--){
		// System.out.print(arr[i]+" ");
		// }
		// System.out.println();
		return pre.next;
	}
}
