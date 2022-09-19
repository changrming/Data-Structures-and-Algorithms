/**
 * 
 */
package class06_BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author chang
 *
 */
public class Code01_FindParantNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 100000l; i++) {
			Node node = TreeUntils.generate(0, 4, 10);
			Queue<Node> queue = new LinkedList<>();
			if (node == null) {
				continue;
			} else {
				Node root = node;
				queue.offer(root);
				int count = 0;
				while (!queue.isEmpty()) {
					root = queue.poll();
					count++;
					if (root.left != null) {
						queue.offer(root.left);
					}
					if (root.right != null) {
						queue.offer(root.right);
					}
				}
				int rand = (int) (Math.random() * (count)) + 1;
				count = 0;
				Node res = null;
				queue.offer(node);
				while (!queue.isEmpty()) {
					root = queue.poll();
					count++;
					if (count == rand) {
						res = root;
						break;
					}
					if (root.left != null) {
						queue.offer(root.left);
					}
					if (root.right != null) {
						queue.offer(root.right);
					}
				}
				Set<Node> a1 = findParant1(res, node);
				Set<Node> a2 = findParant(res, node);
				if (!judge(a1, a2)) {
					TreeUntils.print(node);
					System.out.println("chucuole," + "节点为" + res.val);
					for (Node no : a1) {
						System.out.print(no.val + " ");
					}
					System.out.println("---------");
					for (Node no : a2) {
						System.out.print(no.val + " ");
					}
				}

			}
		}
		System.out.println("wancheng");
	}

	private static Set<Node> findParant1(Node node, Node root) {
		Stack<Node> stack = new Stack<>();
		if (root == null) {
			return new HashSet<>();
		}
		stack.push(root);
		Map<Node, Node> map = new HashMap<>();
		while (!stack.isEmpty()) {
			root = stack.pop();
			if (root.right != null) {
				map.put(root.right, root);
				stack.push(root.right);
			}
			if (root.left != null) {
				map.put(root.left, root);
				stack.push(root.left);
			}
		}
		Set<Node> ans = new HashSet<>();
		while (map.containsKey(node)) {
			ans.add(map.get(node));
			node = map.get(node);
		}
		return ans;
	}

	/**
	 * @param res
	 * @param node
	 * @return 前序： 祖先 左兄 节点 右兄 子节点 后序： 子节点 左兄 节点 右兄 祖先 右左中： 右兄 子节点 cur节点 左兄
	 *         祖父
	 */

	private static Set<Node> findParant(Node node, Node root) {
		Set<Node> set = new HashSet<>();
		Set<Node> res = new HashSet<>();
		if (root == null)
			return res;
		Node cur = root;
		Stack<Node> stack = new Stack<>();
		stack.push(cur);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			if (cur == node) {
				while (!stack.isEmpty())
					stack.pop();
				break;
			}
			set.add(cur);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}
		cur = root;
		stack.push(cur);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			if (cur == node)
				return res;
			if (set.contains(cur)) {
				res.add(cur);
			}
			if (cur.left != null)
				stack.push(cur.left);
			if (cur.right != null)
				stack.push(cur.right);
		}
		return res;
	}

	public static Set<Node> fff(Set<Node> set1, Set<Node> set2) {
		Set<Node> ans = new HashSet<>();
		for (Node node : set1) {
			if (set2.contains(node))
				ans.add(node);
		}
		return ans;

	}

	public static boolean judge(Set<Node> set1, Set<Node> set2) {
		if (set1.size() == 0 && set2.size() == 0)
			return true;
		if (set1.size() != set2.size())
			return false;
		for (Node node : set1) {
			if (!set2.contains(node))
				return false;
		}
		for (Node node : set2) {
			if (!set1.contains(node))
				return false;
		}
		return true;
	}

}
