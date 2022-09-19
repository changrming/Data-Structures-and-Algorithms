/**
 * 
 */
package class01_BitOperation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chang
 *
 */
public class Code02_KMTimes {
	public static int findKTimes(int[] arr, int k, int m) {
		int[]cnt=new int[32];
		for(int num:arr){
			for(int i=0;i<32;i++){
				if(((num>>i)&1)==1){
					cnt[i]++;
				}
			}
		}
		int ans=0;
		for(int i=0;i<32;i++){
			if(cnt[i]%m!=0){
				ans|=(1<<i);
			}
		}
		return ans;
		
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100000; i++) {
			int range = (int) (Math.random() * 30) + 40;
			int k = (int) (Math.random() * 8)+1 ;
			int m = k + (int) (Math.random() * 8) + 2;
			int[] arr = generateArray(range, k, m);
//			System.out.print(k + " ");
//			System.out.print(m);
//			System.out.println();
//			for (int p = 0; p < arr.length; p++) {
//				System.out.print(arr[p] + " ");
//			}
//			System.out.println();
//			System.out.println(findKTimes(arr, k, m));
//			System.out.println(findKTimes1(arr, k, m));
			if (findKTimes(arr, k, m) != findKTimes1(arr, k, m)) {
				System.out.println("出错了");
			}
		}
		System.out.println("ok");

	}

	public static int[] generateArray(int range, int k, int m) {
		Set<Integer> set = new HashSet<>();
		int time = (int) (Math.random() * 30) + 6;
		int len = k + m * time;
		int r = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
		int[] arr = new int[len];
		set.add(r);
		int cur =0;
		for (int i = 0; i < k; i++) {
			arr[i] = r;
			cur = i;
		}
		cur++;//要从下个位置开始赋值
		for (int i = 0; i < time; i++) {
			r = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
			while (set.contains(r)) {
				r = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
			}
			set.add(r);
			for (int j = 0; j < m; j++) {
				arr[cur++] = r;
			}
		}
		 for(int i=0;i<arr.length;i++){
		 int t=(int)(Math.random()*arr.length);
		 int tem=arr[t];
		 arr[t]=arr[i];
		 arr[i]=tem;
		 }
		return arr;
	}

	public static int findKTimes1(int[] arr, int k, int m) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		for (int num : map.keySet()) {
			if (map.get(num) == k) {
				return num;
			}
		}
		return -1;
	}
}
