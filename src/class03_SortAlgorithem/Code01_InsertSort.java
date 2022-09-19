/**
 * 
 */
package class03_SortAlgorithem;

import java.util.Arrays;

/**
 * @author chang
 *
 */
public class Code01_InsertSort {
	public static void InsertSort(int[] arr) {
		int length = arr.length;
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while (j >= 1 && arr[j] < arr[j - 1]) {
//				swap(arr, j--, j - 1); 
				swap(arr, j, j - 1);
				j--;
			}
		}
	}

	public static void swap(int[] arr, int a, int b) {
		arr[a] = arr[a] ^ arr[b];
		arr[b] = arr[a] ^ arr[b];
		arr[a] = arr[a] ^ arr[b];
	}

	public static void sort(int[] arr) {
		Arrays.sort(arr);
	}

	public static void main(String[] args) {
		int[] arr=new int[]{5,4,1,4,7,-2,6,3,7};
		InsertSort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
//		System.out.println("测试开始");
//		for (int i = 0; i < 3; i++) {
//			int len = (int) (Math.random() * 5) + 1;
//			int range = (int) (Math.random() * 9) + 10;
//			int[] arr1 = generateArray(len, range);
//			int[] arr2 = arr1.clone();
//			sort(arr1);
//			InsertSort(arr2);
//			for (int j = 0; j < arr1.length; j++) {
//				if (arr1[j] != arr2[j]) {
//					System.out.println("不相等");
//				}
//			}
//		}
//		System.out.println("测试结束");
	}

	public static int[] generateArray(int len, int range) {
		int[] arr = new int[len];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
		}
		return arr;

	}
}
