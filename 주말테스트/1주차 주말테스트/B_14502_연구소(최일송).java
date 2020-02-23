package Pratice.Backjoon;

import java.util.*;

public class B_14502_연구소 {
	static int N;
	static int M;
	static int[][] Map;

	static Queue<Integer> queuex = new LinkedList<>();
	static Queue<Integer> queuey = new LinkedList<>();
	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int Max = 0;
	static int[] X = new int[3];
	static int[] Y = new int[3];
	static int[] arr_x;
	static int[] arr_y;
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Map = new int[N][M];
		arr_x = new int[N * M];
		arr_y = new int[N * M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Map[i][j] = sc.nextInt();
				if (Map[i][j] == 0) {
					arr_x[count] = i;
					arr_y[count] = j;
					count++;
				}
			}
		}

		Start(0, 0);
		System.out.println(Max);
	}

	public static void Start(int idx, int s) {
		if (s == 3) {
			int[][] cm = CopyMap();
			cm[X[0]][Y[0]] = 1;
			cm[X[1]][Y[1]] = 1;
			cm[X[2]][Y[2]] = 1;
			Virus(cm);
			CheckMap(cm);
			return;
		}
		if (idx == count) {
			return;
		}

		X[s] = arr_x[idx];
		Y[s] = arr_y[idx];
		Start(idx+1, s + 1);
		Start(idx+1, s);
	}

	public static int[][] CopyMap() {
		int[][] cm = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cm[i][j] = Map[i][j];
			}
		}

		return cm;
	}

	public static void Virus(int[][] map) {

		for (int i = 0; i < N; i++) { // 바이러스 전부 Q에 넣음
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					queuex.add(i);
					queuey.add(j);
				}
			}
		}

		while (!queuex.isEmpty()) {
			int x = queuex.poll();
			int y = queuey.poll();
			for (int i = 0; i < 4; i++) {
				int dc = x + dx[i];
				int dr = y + dy[i];

				if (dc >= 0 && dr >= 0 && dc < N && dr < M && map[dc][dr] != 2 && map[dc][dr] != 1) {
					queuex.add(dc);
					queuey.add(dr);
					map[dc][dr] = 2;
				}
			}

		}

	}

	public static void CheckMap(int[][] map) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count++;
				}
			}
		}
		if (Max < count) {
			Max = count;
		}
	}
}
