/**
 * 
 */
package class03_SortAlgorithem;

/**
 * @author chang
 *                leetcode327
 *    1            
 *    2            
 *    3
 *    4
 */
public class CODE05_CountOfRangeSum {
	public static void main(String[] args) {

	}

	public static int find(int[] arr) {
		int [] help=new int[arr.length];
		int prefix=0;
		for(int i=0;i<help.length;i++){
			prefix+=arr[i];
			help[i]=prefix;
		} 

	}
}
