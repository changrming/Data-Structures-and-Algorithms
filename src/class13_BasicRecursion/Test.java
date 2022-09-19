/**
 * 
 */
package class13_BasicRecursion;

/**
 * @author chang
 *
 */
public class Test {
	public static void main(String[] args) {
		System.out.println(notstrictIncrease(new int[]{4,2,3}));
		System.out.println(notstrictIncrease(new int[]{4,2,1}));
		System.out.println(notstrictIncrease(new int[]{-1,4,2,3}));
		System.out.println(notstrictIncrease(new int[]{2,3,3,2,4}));
		System.out.println(notstrictIncrease(new int[]{2,3,3,2,2}));
		
		
	}

	public static boolean notstrictIncrease(int[] arr) {
		int N=arr.length;
		int[]dp=new int[N];//数组的index位置表示: 长度为index的非递减子序列最后一个数的最小值
		int scope=0;
		
		dp[0]=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]>=dp[scope]){
				dp[++scope]=arr[i];
			}else{
				int le=0,ri=scope;
				while(le<=ri){
					int med=le+((ri-le)>>1);
					if(dp[med]>=arr[i]){
						ri=med-1;
					}else{
						le=med+1;
					}
				}
				
				dp[le]=arr[i];
				
			}
		}
		return N-scope-1<=1;
	}

}
