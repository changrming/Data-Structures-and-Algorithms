/**
 * 
 */
package class05;

/**
 * @author chang
 *
 */
public class Code04_biggerTwoTimes {
	public static void main(String[] args) {
		int[]arr=new int[]{1,4,6,8,9,1,1,2,3,3,4};
		int ans=0;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>2*arr[j]){
					ans+=1;
				}
			}
		}
		System.out.println(ans);
		System.out.println(sortAndSum(arr,0,arr.length-1));
	}
	public static int sortAndSum(int[]arr,int l,int r){
		if(l==r){
			return 0;
		}
		int ans=0;
		int med=l+((r-l)>>1);
		ans+=sortAndSum(arr,l,med);
		ans+=sortAndSum(arr,med+1,r);
		ans+=merge(arr,l,r,med);
		return ans;
	}
	public static int merge(int arr[], int l, int r, int m) {
		int L = l, R = m+1;//[m+1 , R)
		int ans=0;
		while (L <= m) {
			while (R <= r && arr[L] > arr[R] * 2) {
				R++;
			}
			ans+=(R-m-1);
			L++;
		}
		L=l;
		R=m+1;
		int []tem=new int[r-l+1];
		int count=0;
		while (L <= m && R <= r) {
			if (arr[L] < arr[R]) {
			
				tem[count++] = arr[L++];
			} else {
				tem[count++] = arr[R++];
			}
		}
		while (L <= m) {
			tem[count++] = arr[L++];
		}
		while (R <= r) {
			tem[count++] = arr[R++];
		}
		for (int i = 0; i < tem.length; i++) {
			arr[i+l]=tem[i];
		}
		return ans;
	}
}
