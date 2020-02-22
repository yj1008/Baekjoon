import java.util.Scanner;

public class Main {
    static int N;
    static int White;
    static int Blue;
    static boolean[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new boolean[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt() == 1;


        run(0, 0, N);

        System.out.print(White + "\n" + Blue);
    }

    static void run(int r, int c, int n) {
        if (n == 1) {
            if (map[r][c]) {
                Blue++;
            }
            else
                White++;
            return;
        }
        boolean Save = map[r][c];
        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                if (map[r][c] != map[i][j]) {
                    run(r, c, n / 2);
                    run(r + n / 2, c, n / 2);
                    run(r, c + n / 2, n / 2);
                    run(r + n / 2, c + n / 2, n / 2);
                    return;
                }
            }
        }

        if(map[r][c])
            Blue++;
        else
            White++;
        return;
    }
}
