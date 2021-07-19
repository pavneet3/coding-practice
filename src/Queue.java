
public class Queue {

	int a[];
	int head = -1; // -1
	int last = -1; // -1

	Queue(int cap) {
		a = new int[cap];
	}

	// 1,0
	public void insert(int value) {
		if (head == -1 && last == -1) {
			head = 0;
			last = 0;
			a[last] = value;
		} else if ((last + 1) % a.length == head) {
			System.out.println("full");
		} else {
			last = (last + 1) % a.length;
			a[last] = value;
		}
	}

	public int delete() {
		if (head == -1 && last == -1) {
			System.out.println("empty");
			return -1;
		}
		int r = a[head];
		if (head == last) {
			head = -1;
			last = -1;
		} else {
			head = (head + 1) % a.length;
		}
		return r;
	}

	public void printCurrentState() {
		int i = head;
		if (head == -1 && last == -1) {
			System.out.println("empty");
		} else {
			if (last >= head) {
				for (i = head; i <= last; i++) {
					System.out.print(a[i] + " ");
				}
			} else {
				for (i = head; i < a.length; i++) {
					System.out.print(a[i] + " ");
				}
				for (i = 0; i <= last; i++) {
					System.out.print(a[i] + " ");
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Queue q = new Queue(3);
		q.insert(1);
		q.insert(2);
		q.insert(2);
		q.insert(2);
		q.printCurrentState();
		q.delete();
		q.insert(2);
		q.insert(2);
		q.insert(2);
		q.insert(2);
		q.delete();
		q.delete();
		q.delete();
		q.printCurrentState();
	}

}
