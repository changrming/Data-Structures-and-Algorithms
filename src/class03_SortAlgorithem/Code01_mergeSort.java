/**
 * 
 */
package class03_SortAlgorithem;

import java.util.Arrays;

/**
 * @author chang
 *
 */
public class Code01_mergeSort {
	public static void main(String[] args) {
		System.out.println("开始测试");
		for (int i = 0; i < 100000; i++) {

			int len = (int) (Math.random() * 2) + 3;
			int[] arr = generate(len);
			int[] arr1 = arr.clone();
			// for(int q=0;q<arr.length;q++){
			// System.out.print(arr[q]+" ");
			// }
			// for(int q=0;q<arr.length;q++){
			// System.out.print(arr1[q]+" ");
			// }
			Arrays.sort(arr);
			mergeSort(arr1, 0, arr.length - 1);
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] != arr1[j]) {

					System.out.println("不同");
				}
			}
		}
		System.out.println("测试结束");

	}

	public static int[] generate(int len) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 100) - (int) (Math.random() * 100);
		}
		return arr;
	}

	public static void mergeSort(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		int med = ((R - L) >> 1) + L; // 记m为r-l差，差为双数，则一共有奇数个数，左区间比右区间数多一个
						// 差m为奇数，则一共有偶数个数，左区间和右区间数一样多
		// 每次分区的区间大小都逐渐变小
		// 距离大小为3/2/1/时会被分完
		mergeSort(arr, L, med);
		mergeSort(arr, med + 1, R);
		merge(arr, L, R, med);
	}

	// 考虑稳定性
	private static void merge(int[] arr, int l, int r, int med) {
		int[] help = new int[r - l + 1];
		int count = 0;
		int L = l, R = med + 1;
		while (L <= med && R <= r) {
			help[count++] = arr[L] <= arr[R] ? arr[L++] : arr[R++];
		}
		while (L <= med) {
			help[count++] = arr[L++];
		}
		while (R <= r) {
			help[count++] = arr[R++];

		}
		for (int i = 0; i < help.length; i++) {
			arr[l + i] = help[i];
		}

	}

}
