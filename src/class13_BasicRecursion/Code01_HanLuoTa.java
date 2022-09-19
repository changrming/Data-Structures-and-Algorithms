/**
* 
*/
package class13_BasicRecursion;

/**
 * @author chang
 *
 */
public class Code01_HanLuoTa {
	public static void main(String[] args) {
		int res = returnRes("100.3.4.5");
		System.out.println(res);
	}

	public static int returnRes(String ori) {
		String[] tem = ori.split("\\.");
		int res = 0;
		for (String str : tem) {
			int cur = Integer.parseInt(str);
			res = (res <<= 8);
			res += cur;
		}
		return res;
	}
}
