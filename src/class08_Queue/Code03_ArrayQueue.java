/**
 * 
 */
package class04;

/**
 * @author chang
 *
 */
public class Code03_ArrayQueue {
	public static void main(String[] args) {

	}

	public static class MyQueue {
		int[] arr;
		int size;
		int limit;
		int cur;
		int tail;

		public MyQueue(int l) {
			this.limit = l;
			arr = new int[l];
		}

		public void push(int value) {
			if (size == limit) {
				throw new RuntimeException("队列已经满了,无法再添加");
			}
			arr[tail] = value;
			size++;
			if (tail == this.limit - 1) {
				tail = 0;
			} else {
				tail++;
			}
		}

		public int pop() {
			if (size == 0) {
				throw new RuntimeException("队列中无元素");
			}
			int res = arr[cur];
			size--;
			if (cur == this.limit - 1) {
				cur = 0;
			} else {
				cur++;
			}
			return res;
		}

		public int peek() {
			if (size == 0) {
				throw new RuntimeException("队列中无元素");
			}
			return arr[cur];
		}

		public boolean isEmpty() {
			return size == 0;
		}
	}
}
