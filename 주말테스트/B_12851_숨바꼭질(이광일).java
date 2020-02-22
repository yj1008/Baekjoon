package algo0222;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질2 {
    static int K;
    static boolean[] check = new boolean[200001];
    static int[] count = new int[200001];
    static int ans;
    static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        K = sc.nextInt();
        if(N == K) {
            System.out.print(0 + "\n" + 1);
            return;
        }
        bfs(new P(N, 0));
        StringBuilder sb = new StringBuilder();
        sb.append(ans+"\n"+cnt);
        System.out.print(sb.toString());
    }

    static void bfs(P p) {
        Queue<P> q = new LinkedList<P>();
        q.add(p);
        check[p.position] = true;
        count[p.position] = p.sec;
        while (!q.isEmpty()) {
            P tmp = q.poll();
            if (tmp.position == K) {
                ans = tmp.sec;
                cnt++;
                //System.out.println(tmp.sec);
                //break;
            }
            if(ans != 0 && tmp.sec>ans)
                break;
            int a = tmp.position + 1;
            int b = tmp.position - 1;
            int c = tmp.position * 2;
            int tsec = tmp.sec;
            if (a <= 200000 && a <= K) {
                if (!check[a] || (check[a] && count[a]==0) || (check[a]) && (tsec == count[a])) {
                    check[a] = true;
                    count[a] = tsec;
                    q.add(new P(a, tsec + 1));
                }
            }
            if (b >= 0) {
                if (!check[b] || (check[b] && count[b]==0) || (check[b]) && (tsec == count[b])) {
                    check[b] = true;
                    count[b] = tsec;
                    q.add(new P(b, tsec + 1));
                }
            }
            if (c < 200000 && a <= K) {
                if (!check[c] || (check[c] && count[c]==0) || (check[c]) && (tsec == count[c])) {
                    check[c] = true;
                    count[c] = tsec;
                    q.add(new P(c, tsec + 1));
                }
            }

        }
    }

    static class P {
        int position;
        int sec;

        P(int position, int sec) {
            this.position = position;
            this.sec = sec;
        }
    }
}