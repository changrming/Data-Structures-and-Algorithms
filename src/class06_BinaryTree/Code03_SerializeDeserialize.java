/**
 * 
 */
package class06_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chang
 *
 */
public class Code03_SerializeDeserialize {
	// one pre,pos,level traversal result represents one unique Tree while
	// one
	// med traversal result could match more than one Tree;

	public static void main(String[] args) {
		// System.out.println("d");
		for (int i = 0; i < 1; i++) {
			Node head = TreeUntils.generate(0, 5, 10);
			TreeUntils.print(head);
//			String no = preSerialize(head);
			String re=levelSer(head);
			System.out.println(re);
//			Node nod=preDe(no);
//			TreeUntils.print(nod);
			// if (isSameValueStructure(head, res) == false) {
			// System.out.println("出错了");
			// }
		}
		System.out.println("end!");
	}

	// method to verify two Binary Tree is same;
	public static boolean isSameValueStructure(Node head1, Node head2) {
		if (head1 == null && head2 != null) {
			return false;
		}
		if (head1 != null && head2 == null) {
			return false;
		}
		if (head1 == null && head2 == null) {
			return true;
		}
		if (head1.val != head2.val) {
			return false;
		}
		return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
	}

	// attention:the queue here is from the String array,if use String array
	// require one member variable to record the index because the number of
	// nodes going to generate is not sure till the recursion finished

	public static Node preDe(String res) {
		String[] ans=res.split(",");
		Queue<String> queue=new LinkedList<>();
		for(String s:ans){
			queue.offer(s);
		}
		return preDDD(queue);
	}

	public static Node preDDD(Queue<String> queue) {
		String cur = queue.poll();
		if (cur.equals("null"))
			return null;
		Node root = new Node(Integer.parseInt(cur));
		root.left=preDDD(queue);
		root.right=preDDD(queue);
		return root;
	}
	public static String preSerialize(Node node) {
		String res = "";
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()) {
			node = stack.pop();
			if (node != null) {
				res += (node.val + ",");
				stack.push(node.right);
				stack.push(node.left);
			} else {
				res += "null,";
			}
		}
		return res;
	}

	public static String levelSer(Node node) {
		Queue<Node> queue = new LinkedList<>();
		String ans="";
		queue.offer(node);
		while(!queue.isEmpty()){
			Node cur=queue.poll();
			if(cur==null){
				ans+="null,";
			}else{
				ans+=(cur.val+",");
				queue.offer(cur.left);
				queue.offer(cur.right);
			}
		}
		return ans;
	}
	public static Node levelDer(String ans){
		
	}
}
