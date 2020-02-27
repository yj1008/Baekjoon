package algo0222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[][] map = new int[N + 1][N + 1];
        boolean[] check = new boolean[N+1];
        for (int i = 0; i < P; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[b][a] = 1;
            map[a][b] = 1;
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        check[1] = true;
        while(!q.isEmpty()){
            int tmp = q.poll();
            for(int i=1;i<=N;i++){
                if(!check[i] && map[tmp][i]==1){
                    q.add(i);
                    System.out.print(i);
                    check[i] = true;
                }
            }
        }
        int ans = 0;
        for(int i=2;i<=N;i++)
            if(check[i])
                ans++;


        System.out.print(ans);
    }
}
