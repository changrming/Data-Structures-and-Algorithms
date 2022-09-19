/**
 * 
 */
package class03_SortAlgorithem;

/**
 * @author chang
 *
 */
public class ArrayUntils {
	public static int[] generate(int len,int range) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * range) - (int) (Math.random() * range);
		}
		return arr;
	}
}
//1大数据简历 2大数据面试题 3算法 
