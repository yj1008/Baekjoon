package Algorizm.Backjoon;

import java.util.*;

public class B_14890_경사로 {
	static int[][] Map;
	static int N, L;
	static int Count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		L = sc.nextInt();

		Map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Map[i][j] = sc.nextInt();
			}
		} // 입력 완료

		B: for (int i = 0; i < N; i++) { // 가로체크
			int temp = Map[i][0];
			int tcount = 1;
			for (int j = 1; j < N; j++) {

				if (Math.abs(Map[i][j - 1] - Map[i][j]) >= 2) { // 높이차이가 2인경우
					continue B;
				} else if (temp == Map[i][j]) { // 값이 같은경우
					tcount++;
					temp = Map[i][j];
				} else if (temp < Map[i][j]) { // 오르막 길
					if (tcount >= L) {
						// 다행히 넘어갈수 있음
						temp = Map[i][j];
						tcount = 1; // 대신 새로운 높이에 맞춰 개수는 1개로 변경
					} else { // 오르막인데
						continue B;
					}
				} else if (temp > Map[i][j]) {
					temp = Map[i][j];
					int j2 = 0;
					for (j2 = j; j2 < j+L; j2++) {
						if(j2==N || Map[i][j2]!=temp) {
							continue B;
						} //중간에 넘어가거나 끊기면 종료
					}
					j2--;
					temp = Map[i][j2]; // 최소길이만큼 일치한다면 마지막 위치를 기억
					j=j2;
					tcount=0;
				}
			}
			//System.out.print(i+" ");
			Count++;
		}
		//System.out.println();
		//System.out.println(Count);
		
		int Count2 = 0;
		B: for (int i = 0; i < N; i++) { // 세로체크
			int temp = Map[0][i];
			int tcount = 1;
			for (int j = 1; j < N; j++) {
				if (Math.abs(Map[j-1][i] - Map[j][i]) >= 2) { // 높이차이가 2인경우
					continue B;
				} else if (temp == Map[j][i]) { // 값이 같은경우
					tcount++;
					temp = Map[j][i];
				} else if (temp < Map[j][i]) { // 오르막 길
					if (tcount >= L) {
						// 다행히 넘어갈수 있음
						temp = Map[j][i];
						tcount = 1; // 대신 새로운 높이에 맞춰 개수는 1개로 변경
					} else { // 오르막인데
						continue B;
					}
				} else if (temp > Map[j][i]) {
					temp = Map[j][i];
					int j2 = 0;
					for (j2 = j; j2 < j+L; j2++) {
						if(j2==N || Map[j2][i]!=temp) {
							continue B;
						}
					}
					j2--;
					temp = Map[j2][i];
					j=j2;
					tcount=0;
				}
			}
			//System.out.print(i+" ");
			Count2++;
		}
		//System.out.println();
		//System.out.println(Count2);
		System.out.println(Count+Count2);
	}

}