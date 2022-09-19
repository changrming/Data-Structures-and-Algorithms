/**
 * 
 */
package class06_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chang
 *
 */
// the left-son printed before the aim-node;
//
// if the node has no right-son:
// the left-brother and their father is already printed
// but the right-brother and their father not

public class Code05_NextValueInMedTravelsal {
//左兄 左父 左子树 cur 右子树 右父 右兄
	public static void main(String[] args) {
		for (int i = 0; i < 111100; i++) {
			Node node = generateNodee(0, 6, 25);
			Node res= randomNode(node);
		 
			Node a1=findNext(res);
			Node a2=findNext(res);
			if(a1!=a2){
				 
					System.out.println("cuowu");
				 
				
			}

		}
		System.out.println("end");
	}

	public static Node randomNode(Node root) {
		if (root == null)
			return null;
		Queue<Node> queue = new LinkedList<>();
		Node cur = root;
		int count = (int) (Math.random() * 100) + 1;
		while (true) {
			cur = root;
			queue.offer(cur);
			while (!queue.isEmpty()) {
				cur = queue.poll();
				count--;
				if (count == 0)
					return cur;
				if (cur.left != null)
					queue.offer(cur.left);
				if (cur.right != null)
					queue.offer(cur.right);
			}
		}
	}

	public static Node findNext(Node cur) {
		if(cur==null)return null;
		if (cur.right != null) {
			cur = cur.right;
			while (cur.left != null)
				cur = cur.left;
			return cur;
		}
		while (true) {
			Node fa = cur.father;
			if (fa == null)
				break;
			if (fa.left == cur)
				return fa;
			cur = fa;
		}
		return null;

	}

	public static Node findNext1(Node cur) {
		if(cur==null)return null;
		Node aim = cur;
		while (cur.father != null) {
			cur = cur.father;
		}
		Stack<Node> stack = new Stack<>();
		Queue<Node> queue = new LinkedList<>();
		
		while (!stack.isEmpty() || cur != null) {
			if (cur != null) {
				stack.push(cur);
				cur = cur.left;
			} else {
				cur = stack.pop();
				queue.offer(cur);
				cur = cur.right;
			}
		}
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur == aim) {
				if (!queue.isEmpty()) {
					return queue.poll();
				} else {
					break;
				}
			}
		}
		return null;
	}

	public static Node generateNodee(int depth, int maxDepth, int range) {
		if (depth > maxDepth || Math.random() < 0.5) {
			return null;
		}
		int rand = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
		Node root = new Node(rand);
		Node le = generateNodee(depth + 1, maxDepth, range);
		Node ri = generateNodee(depth + 1, maxDepth, range);
		if (le != null) {
			le.father = root;
		}
		if (ri != null) {
			ri.father = root;
		}
		root.left = le;
		root.right = ri;
	
		return root;
	}
}
