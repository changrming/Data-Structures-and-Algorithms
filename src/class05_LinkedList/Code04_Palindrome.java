/**
 * 
 */
package class05_LinkedList;

import java.util.ArrayList;
import java.util.List;

import class05_LinkedList.Code01_ReverseLinkedList.Node;

/**
 * @author chang
 *
 */
public class Code04_Palindrome {
	 

	public boolean judgePalindrome(Node head) {
		if (head == null)
			return true;
		Node pre = head;
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		head = pre;
		int step = 0;
		if (count % 2 == 0) {
			step = count / 2;
		} else {
			step = count / 2 + 1;
		}
		Node node=null;
		while (step-- > 0) {
			if(step==0){
				node=head;
			}
			head = head.next;
		}
		Node reverse = ReverseLinkedList(head);
		Node res=ReverseLinkedList(reverse);
		while(reverse!=null){
			if(reverse.val!=pre.val){
				return false;
			}
			reverse=reverse.next;
			pre=pre.next;
		}
		return true;
	}

	public static Node ReverseLinkedList(Node head) {
		if (head == null)
			return null;
		Node pre = null, cur = head;
		head = head.next;
		while (cur != null) {
			cur.next = pre;
			pre = cur;
			cur = head;
			if (head != null) {
				head = head.next;
			}
		}
		return pre;
	}

	private static boolean judgePalindrome1(Node head) {
		Node dummy = new Node(-1);
		dummy.next = head;
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		int[] arr = new int[count];
		Node cur = dummy.next;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = cur.val;
			cur = cur.next;
		}
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			if (arr[i] != arr[j])
				return false;
		}
		return true;
	}

	public static Node generateNode(int len) {
		Node dummy = new Node(0);
		Node cur = dummy;
		int[] arr = new int[len];
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			int ca = (int) (Math.random() * 45) - (int) (Math.random() * 45);
			arr[i] = ca;
			arr[j] = ca;
		}
		for (int i = 0; i < arr.length; i++) {
			cur.next = new Node(arr[i]);
			cur = cur.next;
		}
		return dummy.next;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			int len = (int) (Math.random() * 13) + 0;
			Node head = generateNode(len);
			Node pre=head;
			List<Node> list1=new ArrayList<>();
			List<Node> list2=new ArrayList<>();
			while(head!=null){
				list1.add(head);
				head=head.next;
			}
			
			// while(head!=null){
			// System.out.print(head.val+" ");
			// head=head.next;
			// }
			if (judgePalindrome1(head) != judgePalindrome1(head)) {
				System.out.println("chucuola!!!");
			}
			while(pre!=null){
				list2.add(pre);
				pre=pre.next;
			}
			for(int j=0;j<list1.size();j++){
				if(list1.get(j)!=list2.get(j)){
					System.out.println("链表变化了");
				}
			}
		}
		System.out.println("wancheng");
	}
}
