/**
 * 
 */
package class06_BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import class06_BinaryTree.Code03_SerializeDeserialize.Node;

/**
 * @author chang
 *
 */
public class Code04_EncodeNTreetoBinaryTree {
	public static void main(String[] args) {
		mutiNode root = new mutiNode(5);
		mutiNode nn = new mutiNode(0);
		root.children.add(nn);
		root.children.add(new mutiNode(3));
		root.children.add(new mutiNode(4));
		nn.children.add(new mutiNode(8));
		nn.children.add(new mutiNode(10));
		Node cur = deCode(root);
		TreeUntils.print(cur);
	}

	private static class mutiNode {
		int val;
		List<mutiNode> children;

		private mutiNode(int v) {
			this.val = v;
			children = new ArrayList<>();
		}
	}

	public static Node deCode(mutiNode node){
		if(node==null)
			return null;
		Node root=new Node(node.val);
		Node cur=null;
		boolean flag=false;
		for(mutiNode child: node.children){
			if(!flag){
				root.left=deCode(child);
				cur=root.left;
				flag=true;
			}else{
				cur.right=deCode(child);
				cur=cur.right;
			}
		}
		return root;
	}
}
