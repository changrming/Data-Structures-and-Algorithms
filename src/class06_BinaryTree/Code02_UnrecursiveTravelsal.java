/**
* 
*/
package class06_BinaryTree;

import java.util.Stack;

/**
 * @author chang
 *
 */
public class Code02_UnrecursiveTravelsal {

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			Node node = TreeUntils.generate(0, 5, 15);
			System.out.println("------pre-------");
			pre(node);
			System.out.println();
			System.out.println("------med-------");
			med(node);
			System.out.println();
			pos2(node);
			System.out.println();
			TreeUntils.print(node);

		}
	}

	public static void pre(Node root) {
		Stack<Node> stack = new Stack<>();
		if (root == null)
			return;
		stack.push(root);
		// System.out.print(root.val +" ");
		while (!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.val + "  ");
			if (root.right != null) {
				stack.push(root.right);
			}
			if (root.left != null) {
				stack.push(root.left);
			}
		}
	}

	public static void med(Node root) {
		Stack<Node> stack = new Stack<>();
		if (root == null){
			return ;			
		}
		stack.push(root);
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			System.out.print(root.val + " ");
			root = root.right;

		}

	}

	public static void pos2(Node h) {
		if (h != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(h);
			Node c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().val + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}
}
