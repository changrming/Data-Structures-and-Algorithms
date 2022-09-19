/**
 * 
 */
package class05_LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chang
 *
 */
public class Code02_RemoveDuplivatesFromSortedList {
	public static Node RemoveDuplivatesFromSortedList(Node head) {
		if(head==null)return null;
		Node cur=head,dummy=head;
		head=head.next;
		while(head!=null){
			if(head.val==cur.val){
				cur.next=head.next;
//				head=head.next;
			}else{
				cur=cur.next;
			}
			head=head.next;
		}
		return dummy;
		
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			int len = (int) (Math.random() * 18) + 8;
			Node ne = generate(len), tem=ne;
//			List<Integer> list=new ArrayList<>();
//			if(tem==null)continue;
//			list.add(tem.val);
//			tem=tem.next;
//			while(tem!=null){
//				System.out.print(tem.val+" ");
//				tem=tem.next;
//			}
			Node du=RemoveDuplivatesFromSortedList(ne);
			int count=0;
			while(du!=null){
				System.out.print(du.val+" ");
				du=du.next;
			}
		}
	}

	public static Node generate(int len) {
		int r = 0;
		Node cur = new Node(0), dummy = cur;
		System.out.print("0 ");
		for (int i = 0; i < len; i++) {
			r = Math.random() > 0.2 ? r : r + (int) (Math.random() * 11)-11;
			cur.next = new Node(r);
			cur = cur.next;
			System.out.print(r+" ");
		}
		System.out.println();
		return dummy;
	}

}
