package Daily.m2.d24;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B12851 {
	static final int  MAX_SIZE=100001;
	static int[] arr=new int[MAX_SIZE];
	static boolean[] visited=new boolean[MAX_SIZE];
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("res/temp.txt")))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == M) {
				sb.append(0).append("\n").append(1);
			}else if(N>M) {
				sb.append(N-M).append("\n").append(1);
			}else {
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(N);
				arr[N]=0;
				visited[N]=true;
				int cnt=0;
				out: while(!queue.isEmpty()) {
					int tmp = queue.poll();
					for(int i=0;i<3;i++) {
						int num=0;
						if(i==0) {
							num=tmp+1;
						}else if(i==1) {
							num=tmp-1;
						}else {
							num=tmp*2;
						}
						if(num > -1 && num <=100000){
							if(num == M) {
								if(min==Integer.MAX_VALUE){
									min=arr[tmp];
								}
								if(min==arr[tmp]) {
									cnt++;
								}
							}
							
							if(min<arr[tmp]) {
								sb.append(min+1).append("\n").append(cnt);
								break out;
							}
							
							if(arr[num]!=0 && arr[num]!=arr[tmp]+1) {
								continue;
							}
							queue.add(num);
							arr[num]=arr[tmp]+1;
						}
					}
				}
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
