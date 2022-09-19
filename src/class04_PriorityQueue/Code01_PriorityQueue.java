/**
 * 
 */
package class04_PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author chang
 *
 */
public class Code01_PriorityQueue {
	public static void main(String[] args) {
		MyHeap my = new MyHeap(new Comparator<int[]>>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0]-o2[0];
			}
		});
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < 5; j++) {
				
				my.add((int) (Math.random() * 200) - (int) (Math.random() * 200));
			}
		}
		
		while (!my.isEmpty()) {
			System.out.println(my.pop());
		}
	}

	private static class MyHeap<T> {

		Map<T, Integer> index;
		List<T> list;
		Comparator<T> comp;

		public MyHeap(Comparator<T> com) {
			comp = com;
			index = new HashMap<>();
			list = new ArrayList<>();
		}

		public void add(T t) {
			list.add(t);
			index.put(t, list.size() - 1);
			heapinsert(list.size() - 1);
		}

		public T pop() {
			T tem = list.get(0);
			swap(0, list.size() - 1);
			list.remove(list.size() - 1);
			index.remove(tem);
			heapify(0);
			return tem;
		}

		private T peek() {
			return list.get(0);
		}

		// only the following methods' argurment is number while other
		// methods' object
		private void heapinsert(int dex) {
			while (true) {
				int fa = (dex - 1) / 2;
				if (comp.compare(list.get(fa), list.get(dex)) > 0) {
					swap(fa, dex);
					dex = fa;
				} else {
					break;
				}
			}

		}

		private void heapify(int dex) {
			while (true) {
				int bigger = dex * 2 + 1;
				if (bigger >= list.size())
					break;

				if (bigger + 1 < list.size()) {
					bigger = comp.compare(list.get(bigger), list.get(bigger + 1)) > 0 ? bigger + 1
							: bigger;
				}

				if (comp.compare(list.get(bigger), list.get(dex)) < 0) {
					swap(bigger, dex);
					dex = bigger;
				} else {
					break;
				}
			}
		}
		private void swap(int l, int r) {
			T ll = list.get(l);
			T rr = list.get(r);
			index.put(ll, r);
			index.put(rr, l);
			list.set(l, rr);
			list.set(r, ll);
		}

		// 若没有map索引，要想完成下面三个操作只能搜索整个树
		// if remove t by inputting its index,it's meaningless;
		// however what we need to do is searching the whole tree if
		// we want to delete one node in the heap , resign one node or
		// judge contain;

		private void resign(T t) {

			heapify(index.get(t));
			heapinsert(index.get(t));

		}

		private void remove(T t) {
			int cur = index.get(t);
			swap(index.get(t), list.size() - 1);

			index.remove(t);
			list.remove(list.size() - 1);
			heapify(cur);
			heapinsert(cur);
		}

		private boolean contains(T t) {
			return index.containsKey(t);
		}

	

		private boolean isEmpty() {
			return list.size() == 0;
		}
	}
}
