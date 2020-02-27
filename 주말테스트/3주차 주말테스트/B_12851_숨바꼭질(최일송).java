package Algorizm.Backjoon;

import java.util.*;

public class B_12851_숨바꼭질2 {
	static int N, K;
	static boolean[] Check = new boolean[100001];
	static Queue<Integer> queue = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		queue.add(N);
		Check[N] = true;

		int count = -1;
		int count2 = 0;
		boolean flag = true;

		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			
			Queue<Integer> tqueue = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				int temp = queue.poll();
				// System.out.println(temp);
				if (temp == K) {
					count2++;
					flag = false;
				}

				if ((temp * 2) <= 100000 && !Check[temp * 2]) {
					tqueue.add(temp * 2);
				}
				if ((temp + 1) <= 100000 && !Check[temp + 1]) {
					tqueue.add(temp + 1);
				}
				if ((temp - 1) >= 0 && !Check[temp - 1]) {
					tqueue.add(temp - 1);
				}
				queue.add(temp);
			}

			for (int i = 0; i < size; i++) {
				int temp = queue.poll();

				if ((temp * 2) <= 100000 && !Check[temp * 2]) {
					Check[temp * 2] = true;
				}
				if ((temp + 1) <= 100000 && !Check[temp + 1]) {
					Check[temp + 1] = true;
				}
				if ((temp - 1) >= 0 && !Check[temp - 1]) {
					Check[temp - 1] = true;
				}

			}
			
			while(!tqueue.isEmpty()) {
				queue.add(tqueue.poll());
			}
			
			if (!flag) {
				break;
			}
		}

		System.out.println(count);
		System.out.println(count2);
	}

}
