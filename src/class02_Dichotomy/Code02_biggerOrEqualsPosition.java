/**
 * 
 */
package class02_Dichotomy;

import java.util.Arrays;

/**
 * @author chang
 *
 */
public class Code02_biggerOrEqualsPosition {
	public static int findBiggerOrEqualsPosition(int[]arr,int k){
		int N=arr.length;
		int L=0,R=N-1;
		while(L<=R){
			int med=L+((R-L)>>1);
			if(arr[med]>=k){
				R=med-1;
			}else{
				L=med+1;
			}
		}
		return L;
	}

	public static void main(String[] args) {
		System.out.println("测试开始");

		for(int i=0;i<10000;i++){
			int len=(int)(Math.random()*100)+1;
			int range=(int)(Math.random()*91)+10;
			int[]arr=generateArray(len,range);
			int k=(int)(Math.random()*34)-(int)(Math.random()*34);
			int f=findBiggerOrEqualsPosition1(arr,k);
			int s=findBiggerOrEqualsPosition(arr,k);
			if(f!=s){
				System.out.println("cuowu......");
			}
		}
		System.out.println("测试完成");

	}
	public static int findBiggerOrEqualsPosition1(int []arr,int k){
		for(int i=0;i<arr.length;i++){
			if(arr[i]>=k){
				return i;
			}
		}
		return arr.length;//注意
	}

	public static int[] generateArray(int length, int range) {
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
		}
		Arrays.sort(arr);
		return arr;
	}
}
