import java.util.*;

public class B_2580_스도쿠 {
	static class Cor {
		int x;
		int y;

		Cor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int Num;
	static int[][] Map;
	static boolean zero = false;
	static boolean[][] Check;
	static ArrayList<Cor> list = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map = new int[9][9];
		Check = new boolean[9][9];
		Num = 0;

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				Map[i][j] = sc.nextInt();
				if(Map[i][j]==0) {
					list.add(new Cor(i,j));
				}else {
					Check[i][j] = true;
				}
			}
		}

		Start(0);

	}

	public static void Start(int idx) {
		if(zero) {
			return;
		}
		if (idx == 81) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(Map[i][j] + " ");
				}
				System.out.println();
			}
			zero=true;
			return;
		}
		
		int x = idx/9;
		int y = idx%9;
		
		if(Map[x][y]!=0) {
			Start(idx+1);
		}else { //해당 좌표가 0이라면
			for (int i = 1; i <= 9; i++) {
				if(numcheck(x,y,i)) {
					Map[x][y] = i;
					Start(idx+1);
					Map[x][y] = 0;
				}
			}
		}
		
	}

	public static boolean numcheck(int i, int j, int v) {

		for (int k = 0; k < 9; k++) {
			if (Map[i][k] == v) {
				return false;
			}
			if (Map[k][j] == v) {
				return false;
			}
		}

		for (int k = (i / 3) * 3; k < (i / 3) * 3 + 3; k++) {
			for (int k2 = (j / 3) * 3; k2 < (j / 3) * 3 + 3; k2++) {
				if (Map[k][k2] == v) {
					return false;
				}
			}
		}

		return true;
	}
}