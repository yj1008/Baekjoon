package Algorizm.Backjoon;

import java.util.*;

public class B_2606_바이러스 {
	static int N, M;
	static boolean[] Check;
	static Queue<Integer> queue = new LinkedList<>();
	static ArrayList<Integer> list[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Check = new boolean[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList();
		}
		
		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			list[a].add(b);
			list[b].add(a);
		}
		
		queue.add(1);
		Check[1] = true;
		int count = 0;
		while(!queue.isEmpty()) {
			
			int temp = queue.poll();
			
			for (int i = 0; i < list[temp].size(); i++) {
				
				if(!Check[list[temp].get(i)]) {
					count++;
					Check[list[temp].get(i)] = true;
					queue.add(list[temp].get(i));
				}
				
			}
			
		}
		
		System.out.println(count);
	}

}
