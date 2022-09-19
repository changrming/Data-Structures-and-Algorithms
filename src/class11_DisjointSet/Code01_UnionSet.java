/**
 * 
 */
package class15_UnionSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author chang
 *
 */
public class Code01_UnionSet {

	public static class UnionSet<T> {

		Map<T, T> parents = new HashMap<>();
		Map<T, Integer> size = new HashMap<>();

		public UnionSet(List<T> list) {
			for (T t : list) {
				parents.put(t, t);
				size.put(t, 1);
			}
		}

		public T findParents(T t) {
			Stack<T> stack = new Stack<>();
			T res = null;
			while (true) {
				if (parents.get(t) == t) {
					res = t;
					break;
				}
				stack.push(t);
				t = parents.get(t);
			}
			while (!stack.isEmpty()) {
				parents.put(stack.pop(), res);
			}
			return res;
		}

		public boolean isSameUnion(T t1, T t2) {
			return findParents(t1) == findParents(t2);
		}

		public void union(T t1, T t2) {
			T f1 = findParents(t1);
			T f2 = findParents(t2);
			if (f1 != f2) {
				int s1 = size.get(f1);
				int s2 = size.get(f2);
				if (s1 >= s2) {
					parents.put(f2, f1);
					size.put(f1, s1 + s2);
					size.remove(f2);
				} else {
					parents.put(f1, f2);
					size.put(f2, s1 + s2);
					size.remove(f1);
				}
			}
		}
	}

}
