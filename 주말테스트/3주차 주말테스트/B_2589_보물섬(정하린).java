package Daily.m2.d24;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2589 {
	static char[][] arr;
	static boolean[][] visited;
	static int[][] visit;
	static int N,M;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/temp.txt")))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr=new char[N][M];
			last=new Target(-1,-1,-1);
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				String strTmp=st.nextToken();
				for(int j=0;j<M;j++) {
					arr[i][j]=strTmp.charAt(j);
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j]=='L') {
						visited=new boolean[N][M];
						visit=new int[N][M];
						bfs(i,j);
					}
				}
			}
			sb.append(last.cnt);
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static int[] dr= {0,-1,0,1,0};
	static int[] dc= {0,0,1,0,-1};
	static Target first;
	static Target last;
	static void bfs(int i,int j) {
		boolean flag=false;
		Queue<Target> queue = new LinkedList<Target>();
		queue.add(new Target(i,j,0));
		visited[i][j]=true;
//		visit[i][j]=1;
		while(!queue.isEmpty()) {
			Target t = queue.poll();
			visit[t.x][t.y]=t.cnt;
			if(t.cnt>last.cnt) {
				last.x=t.x;
				last.y=t.y;
				last.cnt=t.cnt;
				flag=true;
			}
			for(int k=1;k<=4;k++) {
				int row=t.x+dr[k];
				int col=t.y+dc[k];
				if(row >=0 && row <N && col >=0 && col <M) {
					if(visited[row][col]) continue;
					if(arr[row][col]=='W') continue;
					if(visit[row][col]!=0 && visit[row][col] <=t.cnt) continue;
					queue.add(new Target(row,col,t.cnt+1));
					visited[row][col]=true;
				}
			}
		}
		
		if(flag) {
			first=new Target(i,j,0);
		}
	}
	
	static class Target{
		int x;
		int y;
		int cnt;
		public Target(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Target [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}
		
	}
}
