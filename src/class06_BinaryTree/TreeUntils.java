/**
 * 
 */
package class06_BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chang
 *
 */
public class TreeUntils {

	public static void print(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
		
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.val + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static Node generate(int depth, int maxDepth, int range) {
		if (depth > maxDepth || Math.random() < 0.5) {
			return null;
		}
		int rand = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
		Node root = new Node(rand);
		root.left = generate(depth + 1, maxDepth, range);
		root.right = generate(depth + 1, maxDepth, range);
		return root;
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
	
}
