/**
 * 
 */
package class05;

/**
 * @author chang
 *
 */
public class Code03_smallSum {
	public static void main(String[] args) {
		for(int i=0;i<10000;i++){
			int len=(int)(Math.random()*160)+8;
			int[]arr=generate(len);
			int[]arr1=arr.clone();
			
			
			int res=getsmallSum1(arr,0,arr.length-1);
			int res1=getsmallSum(arr1,0,arr.length-1);
			if(res!=res1){
				System.out.println("cuowu");
			}
		}
		System.out.println("end!");
	}
	public static int[] generate(int len) {
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = (int) (Math.random() * 100) - (int) (Math.random() * 100);
		}
		return arr;
	}
	public static int getsmallSum1(int[] arr, int l, int r) {
		int ans=0;
		for(int i=0;i<arr.length;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]<arr[j]){
					ans+=arr[i];
				}
			}
		}
		return ans;
	}
	public static int getsmallSum(int[] arr, int l, int r) {
		if(l==r){
			return 0;
		}
		int med=((r-l)>>1)+l;
		int ans=0;
		ans+=getsmallSum(arr,l,med);
		ans+=getsmallSum(arr,med+1,r);
		ans+=merge(arr,l,r,med);
	}

	public static int merge(int[] arr, int l, int r, int med) {
		 int[]help=new int[r-l+1];
		 int count=0;
		 int ans=0;
		 int L=l,R=med+1;
		 while(L<=med&&R<=r){
			 
		 }
	}
}
