/**
 * 
 */
package class01_BitOperation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chang
 *
 */
public class Code01_TwoNumbers {
	public static int[] onlyTwoTimes(int[] arr) {
		int res = 0;
		for (int i : arr)
			res ^= i;

		int r = res & (-res);
		int L = 0, R = 0;
		for (int i : arr) {
			int cur = i & r;
			if (cur != 0) {
				L ^= i;
			} else {
				R ^= i;
			}
		}
		return new int[] { L, R };
	}

	public static void main(String[] args) {
		System.out.println("start!");
		for (int j = 0; j < 100000; j++) {
			int len = (int) (Math.random() * 100) + 1;
			int range = (int) (Math.random() * 100) + 80;
			int[] arr = generateArray(len, range);
			int[] ans1 = onlyTwoTimes1(arr);

			int[] ans2 = onlyTwoTimes(arr);
			Arrays.sort(ans1);
			Arrays.sort(ans2);
			if (ans1[0] == ans2[0] && ans1[1] == ans2[1]) {
				continue;
			} else {
				for (int k = 0; k < arr.length; k++) {
					System.out.print(arr[k] + " ");
				}
				System.out.println();
				for (int i = 0; i < 2; i++) {
					System.out.print(ans1[i] + " ");
				}
				System.out.println();
				for (int i = 0; i < 2; i++) {
					System.out.print(ans2[i] + " ");
				}
				System.out.println("cuowu");
			}
		}
		System.out.println("end!!!!!!");

	}

	public static int[] onlyTwoTimes1(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] ans = new int[2];
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		int count = 0;
		for (int num : map.keySet()) {
			if (map.get(num) == 1) {
				ans[count++] = num;
			}
		}
		return ans;
	}

	public static int[] generateArray(int length, int range) {
		if (length % 2 == 1)
			length++;
		Set<Integer> set = new HashSet<>();
		int[] arr = new int[length];
		int r = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
		arr[0] = r;
		set.add(r);
		while (set.contains(r)) {
			r = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
		}
		set.add(r);
		arr[1] = r;
		for (int i = 2; i < arr.length; i += 2) {
			while (set.contains(r)) {
				r = (int) (Math.random() * (range + 1)) - (int) (Math.random() * (range + 1));
			}
			set.add(r);
			arr[i] = r;
			arr[i + 1] = r;
		}
		for (int i = 0; i < arr.length; i++) {
			r = (int) (Math.random() * arr.length);
			swap(arr, r, i);
		}
		return arr;
	}

	public static void swap(int[] arr, int l, int r) {
		int tem = arr[l];
		arr[l] = arr[r];
		arr[r] = tem;
	}
}
