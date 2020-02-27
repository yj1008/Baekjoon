package Daily.m2.d24;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630_t {
	static boolean[][] arr;
	static int N;
	static int black,white;
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/temp.txt")))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr=new boolean[N][N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					if(st.nextToken().equals("1"))
						arr[i][j]=true;
					else
						arr[i][j]=false;
				}
			}
			
			dfs(0,0,N);
			sb.append(white).append("\n").append(black);
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	static void dfs(int x,int y,int n) {
		if(n == 1) {
            if(arr[y][x]) black++;
            else white++;
            return;
        }
        boolean same = true;
        boolean color = arr[y][x];
        
        out: for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[y+i][x+j] != color) {
                    same = false;
                    break out;
                }
            }
        }
        if(same) {
            if(arr[y][x]) black++;
            else white++;
            return;
        }
        int newNo = n/2;
        dfs(x, y, newNo);
        dfs(x, y+newNo, newNo);
        dfs(x+newNo, y, newNo);
        dfs(x+newNo, y+newNo, newNo);
	}
}
