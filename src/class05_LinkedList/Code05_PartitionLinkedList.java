/**
 * 
 */
package class05_LinkedList;

/**
 * @author chang
 *
 */
public class Code05_PartitionLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int len = (int) (Math.random() * 15);
			Node head = generateNode(len);
			Node res = partitionLinkedList(head, 0);
			while (res != null) {

				res = res.next;
			}
		}
	}

	private static Node partitionLinkedList(Node head, int v) {
		Node small = new Node(-1), sh = small;
		Node equal = new Node(-1), eh = equal;
		Node big = new Node(-1), bh = big;
		while (head != null) {
			if (head.val < v) {
				sh.next = head;
				sh = head;
			} else if (head.val == v) {
				eh.next = head;
				eh = head;
			} else {
				bh.next = head;
				bh = head;
			}
			head = head.next;
		}
		if (small.next == null && equal.next == null) {
			return big.next;
		} else if (small.next != null && equal.next != null) {
			sh.next = equal.next;
			eh.next = big.next;
			bh.next = null;
			return small.next;
		} else if (small.next == null) {
			eh.next = big.next;
			bh.next = null;
			return equal.next;
		} else {
			sh.next = big.next;
			bh.next = null;
			return small.next;
		}
	}

	public static Node generateNode(int len) {
		Node dummy = new Node(0);
		Node cur = dummy;
		int[] arr = new int[len];
		System.out.println(len);
		for (int i = 0; i < arr.length; i++) {
			int ca = (int) (Math.random() * 15) - (int) (Math.random() * 15);
			arr[i] = ca;
		}
		for (int i = 0; i < arr.length; i++) {
			cur.next = new Node(arr[i]);
			cur = cur.next;
		}
		return dummy.next;
	}
}
