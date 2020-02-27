package Daily.m2.d23;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2606 {
	static boolean[] visited;
	static boolean[][] arr;
	static int result;
	static int N;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/temp.txt")))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			visited=new boolean[101];
			result=0;
			//
			N = Integer.parseInt(st.nextToken());//1부터 N까지 있다.
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());//받을 가지수
			//
			arr=new boolean[N+1][N+1];
			
			for(int i=0;i<M;i++) {
				st=new StringTokenizer(br.readLine());
				int first=Integer.parseInt(st.nextToken());
				int second=Integer.parseInt(st.nextToken());
				arr[first][second]=true;
				arr[second][first]=true;
			}
			
			dfs(1);
			System.out.println(result-1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static void dfs(int idx) {
		result++;
		visited[idx]=true;
		for(int i=1;i<=N;i++) {
			if(arr[idx][i] && !visited[i])
				dfs(i);
		}
	}
}
