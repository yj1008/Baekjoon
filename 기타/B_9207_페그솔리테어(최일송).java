package Algorizm.Backjoon;

import java.util.*;

public class B_9207_페그솔리테어 {
	static int T;
	static char[][] Map = new char[5][9];
	static int[] dx = new int[] {-1,0,1,0};
	static int[] dy = new int[] {0,1,0,-1};
	static int Min;
	static int Count;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			Min = Integer.MAX_VALUE;
			Count = 0;
			for (int i = 0; i < 5; i++) {
				String str = sc.next();
				for (int j = 0; j < 9; j++) {
					Map[i][j] = str.charAt(j);
				}
			}
			
			Start(0);
			System.out.println(Min+" "+Count);
		}
	}

	public static void Start(int s) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if(Map[i][j]=='o') {
					
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						
						if(x>=0 && y>=0 && x<5 && y<9 && Map[x][y]=='o') {
							int tx = x+dx[k];
							int ty = y+dy[k];
							if(tx>=0 && ty>=0 && tx<5 && ty<9 && Map[tx][ty]=='.') {
								Map[i][j]='.';
								Map[x][y]='.';
								Map[tx][ty]='o';
								Start(s+1);
								Map[i][j]='o';
								Map[x][y]='o';
								Map[tx][ty]='.';
								
							}
						}
					}
				}
			}
		}
		int count = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if(Map[i][j]=='o') {
					count++;
				}
			}
		}
		if(Min>count) {
			Min = count;
			Count = s;
		}
	}
}
