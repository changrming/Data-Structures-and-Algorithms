/**
 * 
 */
package class03_SortAlgorithem;

import java.util.Arrays;

/**
 * @author chang
 *
 */
public class CODE02_IterativeMergeSort {
	public static void main(String[] args) {
		for (int i = 0; i < 11111; i++) {
			int len = (int) (Math.random() * 2) + 3;
			int[] arr = ArrayUntils.generate(len,30);
			int[] ar0 = arr.clone();
			for (int j = 0; j < arr.length; j++) {
				// if (arr[j] != ar0[j]) {
				// System.out.println("cuowu ");
				// }
				// System.out.print(arr[j]+" ");
			}
			mergeSort(arr);
			Arrays.sort(ar0);
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] != ar0[j]) {
					System.out.println("cuowu ");
				}
			}
		}
		System.out.println("end!");
	}

	

	public static void mergeSort(int[] arr) {
		int N=arr.length;
		int L=0,R=0;
		for(int i=1;i<N;i*=2){
			int cnt=(int)(Math.ceil(1.0*N/2*i));
			int an=0;
			while(cnt-->0){
				
				L=2*i*an;
				R=2*i*an+i;
				if(R>=N){
					break;
				}
				merge(L,R,i,arr);
				an++;
			}
		}
		
	}

	public static void merge(int L, int R, int step, int[] arr) {
		int rr=Math.min(R+step-1,arr.length-1);
		int l=L;
		int med=R-1;
		int[] help=new int[rr-L+1];
		int count=0;
		while(L<=med&&R<=rr){
			if(arr[L]<arr[R]){
				help[count++]=arr[L++];
			}else{
				help[count++]=arr[R++];
			}
		}
		while(L<=med){
			help[count++]=arr[L++];
		}
		while(R<=rr){
			help[count++]=arr[R++];
			
		}
		for(int i=0;i<help.length;i++){
			arr[l+i]=help[i];
		}
		
		
	}
}
