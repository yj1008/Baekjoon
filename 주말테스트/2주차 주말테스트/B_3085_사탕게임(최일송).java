package Algorizm.Backjoon;
import java.util.*;
public class B_3085_사탕게임 {

	static int N;
	static char[][] Map;
	static int[] dx = new int[] {0,-1,0,1,0};
	static int[] dy = new int[] {0,0,1,0,-1};
	static int Max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				Map[i][j] = str.charAt(j);
			}
		}// 데이터 담는 과정 끝
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {  //모든좌표 탐색 부분
				
				int x = i;
				int y = j;
				
				for (int k = 0; k < 5; k++) { //현좌표 포함 5번의 체인지
					char[][] CopyMap = new char[N][N];
					CopyMap = copymap();
					
					int dr = x + dx[k];
					int dc = y + dy[k];
					
					if(dr>=0 && dc>=0 && dr<N &dc<N) {
						char temp = CopyMap[x][y];
						CopyMap[x][y] = CopyMap[dr][dc];
						CopyMap[dr][dc] = temp; //값 스위칭 완료
						
						//이제 길이만큼 비교할때 x,y값만 이용하면 됨 //dr,dc는 스위칭용
						
						int c1 = 0;
						for (int l = x; l >= 0; l--) {//본인포함 상으로
							if(CopyMap[x][y] == CopyMap[l][y]) {
								c1++;
							}else {
								break;
							}
						}
						
						for (int l = x; l < N; l++) { //본인포함 하로
							if(CopyMap[x][y] == CopyMap[l][y]) {
								c1++;
							}else {
								break;
							}
						}
						c1-=1;
						
						int c2 = 0;
						for (int l = y; l >= 0; l--) {//본인포함 좌로
							if(CopyMap[x][y] == CopyMap[x][l]) {
								c2++;
							}else {
								break;
							}
						}
						
						for (int l = y; l < N; l++) { //본인포함 하로
							if(CopyMap[x][y] == CopyMap[x][l]) {
								c2++;
							}else {
								break;
							}
						}
						c2-=1;
						
						int mc = Math.max(c1, c2);
						Max = Math.max(mc, Max);
						
					}
				}
				
				
			}
		}
		System.out.println(Max);
	}
	
	public static char[][] copymap(){
		char[][] CopyMap = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				CopyMap[i][j] = Map[i][j];
			}
		}
		
		return CopyMap;
	}

}
