/**
 * 
 */
package class02_Dichotomy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author chang
 *
 */
public class Code01_partialMinimum {
	public static int getpartialMinimum(int[] arr) {
		if(arr[0]<arr[1]) return 0;
		int N=arr.length;
		if(arr[N-1]<arr[N-2]) return N-1;
		int L=1,R=N-2;
		while(L<=R){
			int med=L+((R-L)>>1);
			if(arr[med]<arr[med-1]&&arr[med]<arr[med+1]){
				return med;
			}else if(arr[med]>arr[med-1]){
				R=med-1;
			}else{
				L=med+1;
			}
		}
		return -1;
		
		
	}

	public static Set<Integer> getpartialMinimum1(int[] arr) {
		Set<Integer> list = new HashSet<>();
		if (arr[0] < arr[1])
			list.add(0);
		if (arr[arr.length - 1] < arr[arr.length - 2])
			list.add(arr.length - 1);
		for (int i = 1; i < arr.length - 1; i++) {
			if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
				list.add(i);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println("开始计算");
		for (int i = 0; i < 100009; i++) {
			int len = (int) (Math.random() * 10) + 8;
			int range = (int) (Math.random() * 90) + 100;
			int[] arr = generateArray(len, range);
			Set<Integer> list = getpartialMinimum1(arr);
			int res = getpartialMinimum(arr);
			if (!list.contains(res)) {
				System.out.println("出错了");
			}
			// for (int j = 0; j < arr.length; j++) {
			// System.out.print(arr[j] + " ");
			// }
			// System.out.println();
			// for (int num : list) {
			// System.out.print(num + " ");
			// }
			// System.out.println();
			//
			// System.out.println(res);

		}
		System.out.println("计算完成");

	}

	public static int[] generateArray(int len, int range) {
		int[] arr = new int[len];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {

			int res = (int) (Math.random() * (range + 1));
			int count = 0;
			while (set.contains(res)) {

				res = (int) (Math.random() * (range + 1));

			}
			set.add(res);

			arr[i] = res;
		}
		int change = (int) (Math.random() * (arr.length - 5));
		arr[change] = Integer.MAX_VALUE;
		arr[change + 2] = Integer.MAX_VALUE - 1;
		return arr;
	}
}
