/**
 * 
 */
package class03_SortAlgorithem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chang 栈和堆都可以实现
 */
public class CODE06_IterativeQuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 0, 0, 17 };
		quickSort(arr);

//		System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
		for (int i = 0; i < 11111; i++) {
			int len = (int) (Math.random() * 30) + 20;
			int[] res = ArrayUntils.generate(len,80);
			int[] clone = res.clone();
			int[] clone1 = res.clone();
			quickSort(res);
			Arrays.sort(clone);
			for (int j = 0; j < res.length; j++) {
				// System.out.print(res[j]+" ");
				// System.out.print(clone[j]+" ");
				if (res[j] != clone[j]) {
					System.out.println("cuowule");
				}
			}

		}
		System.out.println("end");
	}

	 

	private static void quickSort(int[] arr) {
		Queue<int[]> queue=new LinkedList<>();
		if(arr.length==0)return;
		queue.offer(new int[]{0,arr.length-1});
		while(!queue.isEmpty()){
			int[] res= queue.poll();
			int []ans=sort(res[0],res[1],arr);
			if(ans[0]>res[0]){
				queue.offer(new int[]{res[0],ans[0]});
				
			}
			if(ans[1]<res[1]){
				queue.offer(new int[]{ans[1],res[1]});
			}
		}

	}

	private static int[] sort(int l, int r, int[] arr) {
			int rand=(int)(Math.random()*(r-l))+l;
			swap(rand,r,arr);
			int C=l,R=r-1;
			while(C<=R){
				if(arr[C]<arr[r]){
					swap(l++,C++,arr);
				}else if(arr[C]==arr[r]){
					C++;
				}else{
					swap(R--,C,arr);
				}
			}
			swap(R+1,r,arr);
			return new int[]{l-1,R+2};
	}

	private static void swap(int l, int r, int[] arr) {
		int tem = arr[l];
		arr[l] = arr[r];
		arr[r] = tem;
	}
}
