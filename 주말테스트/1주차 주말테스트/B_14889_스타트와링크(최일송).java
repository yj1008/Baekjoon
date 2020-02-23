package Pratice.Backjoon;
import java.util.*;

public class B_14889_스타트와링크 {
	static int N;
	static int[][] arr;
	static int[] arr_s1;
	static int[] arr_s2;
	static int Casesum1;
	static int Casesum2;
	static int Min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		arr_s1 = new int[N/2];
		arr_s2 = new int[N/2];

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		Sort1(1,0);
		System.out.println(Min);
	}

	public static void Sort1(int idx, int s) {
		if(N/2==s) {
//			System.out.println(Arrays.toString(arr_s1));
			int c = 0;
			for (int i = 1; i <= N; i++) {
				boolean check = true;
				for (int j = 0; j < N/2; j++) {
					if(arr_s1[j]==i) {
						check = false;
						break;
					}					
				}
				if(check) {
					arr_s2[c++] = i;
				}
			}
//			System.out.println(Arrays.toString(arr_s2));
//			System.out.println();
			Casesum1 = 0;
			for (int i = 0; i < N/2; i++) {
				for (int j = i+1; j < N/2 ; j++) {
					int x = arr_s1[i]-1;
					int y = arr_s1[j]-1;
					Cal(x,y);
				}
			}
			
			Casesum2 = 0;
			for (int i = 0; i < N/2; i++) {
				for (int j = i+1; j < N/2 ; j++) {
					int x = arr_s2[i]-1;
					int y = arr_s2[j]-1;
					Cal2(x,y);
				}
			}
			int temp = Math.abs(Casesum1-Casesum2);
			if(temp<Min) {
				Min = temp;
			}
			return;
		}
		if(idx==N+1) {
			return;
		}
		arr_s1[s] = idx;
		Sort1(idx+1, s+1);
		Sort1(idx+1, s);
	}
	
	public static void Cal(int x, int y) {
		int sum = arr[x][y] + arr[y][x];
		Casesum1 += sum;
	}
	public static void Cal2(int x, int y) {
		int sum = arr[x][y] + arr[y][x];
		Casesum2 += sum;
	}
}

