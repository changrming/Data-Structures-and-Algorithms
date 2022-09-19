/**
 * 
 */
package class09_Trie;

/**
 * @author chang
 *
 */
public class Code01_Trie {
	public  static class Node{
		int p;
		int e;
		Node[]nodes;
		public Node(){
			nodes=new Node[26];
		}
	}
	public static class myTrie{
		Node root;
		public myTrie(){
			root=new Node();
		}
		public void insert(String str){
			Node cur=root;
			if(str.length()=='0')return;
			root.p++;
			for(int i=0;i<str.length();i++){
				char c=str.charAt(i);
				if(cur.nodes[c-'a']==null){
					cur.nodes[c-'a']=new Node();
				}
				cur=cur.nodes[c-'a'];
				cur.p++;
			}
			cur.e++;
		}
		public int search(String str){
			Node cur=root;
			for(int i=0;i<str.length();i++){
				char c=str.charAt(i);
				if(cur.nodes[c-'a']==null){
					return 0;
				}
				cur=cur.nodes[c-'a'];
				
			}
			return cur.e;
		}
		public void delete(String str){
			if(search(str)!=0){
				Node cur=root;
				root.p--;
				for(int i=0;i<str.length();i++){
					char c=str.charAt(i);
					if(cur.nodes[c-'a'].p==1){
						cur.nodes[c-'a']=null;
						return;
					}
					cur=cur.nodes[c-'a'];
				}
				cur.e--;
				
			}
		}
		public int prefix(String str){
			Node cur=root;
			for(int i=0;i<str.length();i++){
				char c=str.charAt(i);
				if(cur.nodes[c-'a']==null){
					return 0;
				}
				cur=cur.nodes[c-'a'];
			}
			return cur.p;
		}
	}
}
