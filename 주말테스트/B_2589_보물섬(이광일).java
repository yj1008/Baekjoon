package algo0222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보물섬 {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        boolean[][] map = new boolean[N][M];
        int[][] Count;
        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) != 'W';
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!map[i][j])
                    continue;
                else {
                    Queue<Pos> q = new LinkedList<>();
                    Count = new int[N][M];
                    boolean[][] map_tmp = new boolean[N][M];
                    for(int a=0;a<N;a++)
                        for(int b=0;b<M;b++)
                            map_tmp[a][b] = map[a][b];
                    int cnt = 0;
                    q.add(new Pos(i,j));
                    Pos tmp = null;
                    while(!q.isEmpty()){
                        tmp = q.poll();
                        for(int k=0;k<4;k++){
                            int rr = tmp.r + dr[k];
                            int cc = tmp.c + dc[k];
                            if(rr<N && cc< M && rr>=0 && cc>= 0 && map_tmp[rr][cc]){
                                q.add(new Pos(rr,cc));
                                Count[rr][cc] = Count[tmp.r][tmp.c] + 1;
                                map_tmp[rr][cc] = false;
                            }

                        }
                    }

                    max = Math.max(max,Count[tmp.r][tmp.c]);
                }
            }
        }
        System.out.print(max);


    }

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
