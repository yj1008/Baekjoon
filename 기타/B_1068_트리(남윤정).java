import java.util.*;
import java.io.*;
 
public class 트리 {
    public static void main(String[] args) throws Exception {
       // System.setIn(new FileInputStream("res/b/트리.txt"));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
 
        ArrayList<Integer>[] list = new ArrayList[N];
 
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }
         
        int root = 0;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            if(a == -1)
                root = i;
            else
                list[a].add(i);
        }
 
        int x = sc.nextInt();
        if (x == root) {
            System.out.println(0);
            return;
        }
 
        boolean[] v = new boolean[N];
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        v[root] = true;
        while (!q.isEmpty()) {
            Integer i = q.poll();
             
            if (list[i].size() == 0) {
                cnt++;
                continue;
            }
 
            for (Integer j : list[i]) {
                if (j == x) {
                    if (list[i].size()-1 == 0) {
                        cnt++;
                    }
                    continue;
                }
 
                if (!v[j]) {
                    v[j] = true;
                    q.add(j);
                }
            }
        }
 
        System.out.println(cnt == 0 ? 1 : cnt);
    }
}