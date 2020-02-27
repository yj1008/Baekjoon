package Algorizm.Backjoon;

import java.util.*;

public class B_2630_색종이만들기2 {
	static int N;
	static int[][] Map;
	static int count1, count2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		Map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Map[i][j] = sc.nextInt();
			}
		}
		count1 = 0;
		count2 = 0;
			
		for (int i = 2; i <= N; i=i*2) {
			
			for (int j = 0; j <N ; j+=N/i) {
				for (int j2 = 0; j2 < N; j2+=N/i) {
					if(Map[j][j2]!=2 && CheckMap(j,j2,N/i,Map[j][j2])) {
						
						if(Map[j][j2]==1) {
							count1++;
							
						}else if(Map[j][j2]==0) {
							count2++;
						}
						ChangeMap(j,j2,N/i,2);
						
					}
				}
			}
			
		}
	
		System.out.println(count2);
		System.out.println(count1);
	}


		
	
	
	public static void ChangeMap(int x, int y, int L, int v) {
		for (int i = x; i < x+L; i++) {
			for (int j = y; j < y+L; j++) {
				Map[i][j]=2;
			}
		}
	}
	
	public static boolean CheckMap(int x, int y, int L, int v) {
		for (int i = x; i < x+L; i++) {
			for (int j = y; j < y+L; j++) {
				if(Map[i][j]!=v) {
					return false;
				}
			}
		}		
		return true;
	}
}
