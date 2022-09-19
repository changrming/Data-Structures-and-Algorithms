/**
 * 
 */
package class06_BinaryTree;

/**
 * @author chang
 *
 */
public class Code07_BalancedBinaryTree {
	private class info{
		int height=0;
		boolean is=true;
		private info(){
			
		}
		private info(int h,boolean b){
			this.height=h;
			this.is=b;
		}
	}
	
	
	private  info isBalanced(Node node){
		if(node==null){
			return new info(0,true);
		}
		info l=isBalanced(node.left);
		info r=isBalanced(node.right);
		if(Math.abs(l.height-r.height)>1||l.is==false||r.is==false){
			return new info(Math.max(l.height,r.height),false);
		}
		return new info(Math.max(l.height,r.height),true);
	}
}
