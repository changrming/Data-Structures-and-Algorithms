/**
 * 
 */
package class04_PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author chang
 *
 */
public class Code02_SegmentMatchMaximum {
	public static void main(String[] args) {

		for(int i=0;i<100000;i++){
			int len=(int)(Math.random()*3)+2;
			int[][]arr=generate(len);
			int[][]arr0=arr.clone();
			int res=findSegmentMatchMaximum1(arr);
			int res1=findSegmentMatchMaximum(arr);
			if(res!=res1){
				System.out.print("出错了:");
				for(int j=0;j<arr0.length;j++){
					System.out.print("["+arr0[j][0]+"~"+arr0[j][1]+"]  ");
				}
				System.out.println( );
				System.out.println(res);
				System.out.println(res1);
			}
		}
		System.out.println("计算结束");
	}
	public static int[][] generate(int len){
		int[][]arr=new int[len][2];
		for(int i=0;i<len;i++){
			int tem=(int)(Math.random()*50)-(int)(Math.random()*50);
			int nex=tem+(int)(Math.random()*20)+2;
			arr[i][0]=tem;
			arr[i][1]=nex;
		}
		return arr;
	}

	public static int findSegmentMatchMaximum(int[][] arr) {
		Arrays.sort(arr,(a,b)->{
			return a[0]-b[0];
		});
		PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
			return a - b;
		});
		int ans = 0;
		for (int[] nums : arr) {
			while (!queue.isEmpty()) {
				if (queue.peek() <= nums[0]) {
					queue.poll();
				} else {
					break;
				}
			}
			ans = Math.max(ans, queue.size()+1);
			queue.add(nums[1]);
		}
		return ans;
	}
	public static int findSegmentMatchMaximum1(int[][] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int[] nums : arr) {
			min = Math.min(min, nums[0]);
			max = Math.max(max, nums[1]);
		}
		int res=0;
		for (double d = min + 0.5; d < max - 0.5; d += 1.0) {
			int ans=0;
			for (int[] num : arr) {
				if (num[0] < d && num[1] > d) {
					ans++;
				}
			}
			res=Math.max(res,ans);
		}
		return res;
	}
}
