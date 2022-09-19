/**
 * 
 */
package class05_LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chang
 *
 */
public class Code06_CopyListWithRandom {
	public static void main(String[] args) {
		for(int i=0;i<122222;i++){
			int len=(int)(Math.random()*2)+3;
			Node node=generate(len);
			Node res0=copyListRandom(node);
			Node res1=copyListRandom1(node);
			while(res0!=null){
				if(res0.val!=res1.val||res0.random.val!=res1.random.val){
					System.out.println("出错了");
				}
//				System.out.print(res0.val+" ");
//				System.out.print(res1.val+" ");
				res0=res0.next;
				res1=res1.next;
			}
		}
		System.out.println("end");
	}
	private static Node copyListRandom(Node head){
		if(head==null)return null;
		Node cur=head;
		Node n=null;
		while(cur!=null){
			n=cur.next;
			Node toadd=new Node(cur.val);
			cur.next=toadd;
			toadd.next=n;
//			System.out.print(cur.val+" ");
//			System.out.print(cur.next.val+" ");
			cur=n;
		}
		cur=head;
		while(cur!=null){
			cur.next.random=cur.random.next;
			cur=cur.next.next;
		}
		cur=head;
		
		Node res=cur.next,ans=cur.next;
		n=head;
		while(true){
		
			if(res.next==null){
				cur.next=null;
				break;
			}
			n=cur.next.next;
			
			res.next=res.next.next;
			res=res.next;
			cur.next=n;
			cur=n;
			
		}
		return ans;
	}
	private static Node copyListRandom1(Node node){
		if(node==null)return null;
		Map<Node,Node> map=new HashMap<>();
		Node cur=node;
		while(cur!=null){
			map.put(cur,new Node(cur.val));
			cur=cur.next;
		}
		cur=node;
		while(cur!=null){
			map.get(cur).next=map.get(cur.next);
			map.get(cur).random=map.get(cur.random);
			cur=cur.next;
		}
		return map.get(node);
	}
	private static Node generate(int len){
		if(len==0)return null;
		Node[]node=new Node[len];
		int rand=(int)(Math.random()*100);
		Node head=new Node(rand);
		int count=0;
		node[count++]=head;
		Node dummy=head;
		len--;
		while(len-->0){
			rand=(int)(Math.random()*100);
			head.next=new Node(rand);
			node[count++]=head.next;
			head=head.next;
		}
		head=dummy;
		while(head!=null){
			int ran=(int)(Math.random()*len);
			head.random=node[ran];
			head=head.next;
		}
		return dummy;
	}
		
}

