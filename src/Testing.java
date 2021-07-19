import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testing {

	static void dependencyStr() {
		List<List<Integer>> l = new ArrayList<>();  
		List<Integer> o = new ArrayList<Integer>();
		int v = populateL(l);
		boolean vis[] = new boolean[v];
		for(int i=0;i<v;i++) {
			if(!vis[i]) {
				visit(l,i,vis,o);
			}
		}
		System.out.println(o);
	}
	
	
	
	private static void visit(List<List<Integer>> l, int i, boolean vis[],List<Integer> r) {
		List<Integer> list = l.get(i);
		vis[i] = true;
		for(Integer e : list) {
			if(!vis[e]) {
				visit(l, e, vis,r);
			}
		}
		r.add(i);
	}



	private static int populateL(List<List<Integer>> l) {
		l.add(Arrays.asList(1,2));
		l.add(Arrays.asList());
		l.add(Arrays.asList());
		l.add(Arrays.asList(4));
		l.add(Arrays.asList());
		return 5;
	}



	static void rearrangeArray() {
		int a[] = new int[] { 1,2,3,4,5,6,7 };
		boolean t = true;
		int i = 0;
		while (i < a.length - 1) {
			if (t) {
				if (a[i] < a[i + 1]) {
					swap(a, i, i + 1);
				}
			} else {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
				}
			}
			i++;
			t = !t;
		}
		printA(a);
	}

	static void printA(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	static void swap(int a[], int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		dependencyStr();
	}

}
