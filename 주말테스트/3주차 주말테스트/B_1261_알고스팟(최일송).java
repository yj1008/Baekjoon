package Algorizm.Backjoon;

import java.util.*;

public class B_1261_알고스팟_BFS2 {
	static class Cor {
		int x;
		int y;

		Cor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static int[][] Map;
	static int[][] MapCount;
	static boolean[][] Check;
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static Deque<Cor> queue = new LinkedList<>();
	static int Min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		Map = new int[N][M];
		MapCount = new int[N][M];
		Check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '1') {
					Map[i][j] = 1;
				}
			}
		} // 맵저장, 좌표저장

		CheckMap();
		System.out.println(MapCount[N - 1][M - 1]);
	}

	public static void CheckMap() {
		queue.add(new Cor(0, 0));
		Check[0][0] = true;

		while (!queue.isEmpty()) {
			Cor temp = queue.pollLast();
			int x = temp.x;
			int y = temp.y;
			
			for (int i = 0; i < 4; i++) {
				int dr = x + dx[i];
				int dc = y + dy[i];

				if (dr < 0 || dc < 0 || dr >= N || dc >= M || Check[dr][dc]) {
					continue;
				}
				if(Map[dr][dc]==0) {
					MapCount[dr][dc] = MapCount[x][y];
					queue.addLast(new Cor(dr,dc));
				}else {
					MapCount[dr][dc] = MapCount[x][y]+1;
					queue.addFirst(new Cor(dr,dc));
				}
				Check[dr][dc] = true;
			}
		}
		
	}

}
