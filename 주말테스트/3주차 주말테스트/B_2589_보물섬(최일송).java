package Algorizm.Backjoon;

import java.util.*;

public class B_2589_보물섬 {
	static class Cor {
		int x;
		int y;

		Cor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M;
	static String str;
	static int[][] Map;
	static boolean[][] Check;
	static boolean[][] CopyCheck;
	static Queue<Cor> queue = new LinkedList<>();

	static int[] dx = new int[] { -1, 0, 1, 0 };
	static int[] dy = new int[] { 0, 1, 0, -1 };
	static int Max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		Map = new int[N][M];
		Check = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'L') {
					Map[i][j] = 1;
					//Check[i][j] = true;
				}
			}
		} // 맵 입력 완료

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Map[i][j]==1) {
					BFS(i, j);
				}
			}
		}

		System.out.println(Max);
	}

	public static void BFS(int x, int y) {
		CopyCheck = Copy();
		CopyCheck[x][y] = true;

		int count = -1;

		queue.add(new Cor(x, y));

		while (!queue.isEmpty()) {
			int size = queue.size();
			count++;
			for (int k = 0; k < size; k++) {
				int tx = queue.peek().x;
				int ty = queue.peek().y;
				queue.poll();

				for (int i = 0; i < 4; i++) {
					int dr = tx + dx[i];
					int dc = ty + dy[i];

					if (dr >= 0 && dc >= 0 && dr < N && dc < M && Map[dr][dc]==1 && !CopyCheck[dr][dc]) {
						CopyCheck[dr][dc] = true;
						queue.add(new Cor(dr, dc));
					}
				}
			}
//			for (int j2 = 0; j2 < N; j2++) {
//				for (int k = 0; k < M; k++) {
//					if (CopyCheck[j2][k]) {
//						System.out.print(1 + " ");
//					} else {
//						System.out.print(0 + " ");
//					}
//				}
//				System.out.println();
//			}
//			System.out.println();

		}

		if (Max < count) {
			Max = count;
		}
	}

	public static boolean[][] Copy() {
		boolean[][] temp = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp[i][j] = Check[i][j];
			}
		}
		return temp;
	}
}

//for (int j2 = 0; j2 < N; j2++) {
//	for (int k = 0; k < M; k++) {
//		if(Check[j2][k]) {
//			System.out.print(1+" ");
//		}else {
//			System.out.print(0+" ");
//		}
//	}
//	System.out.println();
//}
//System.out.println();
