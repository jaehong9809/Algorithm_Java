import java.util.*;

class Main {
	static int n;
	static int m;
	static int startx;
	static int starty;
	static int dir;
	static int[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] cleaned;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		startx = sc.nextInt();
		starty = sc.nextInt();
		dir = sc.nextInt();
		map = new int[n][m];
		cleaned = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int cnt=0;
		while (true) {
			if (map[startx][starty] == 0 && !cleaned[startx][starty]) {
				cleaned[startx][starty] = true;
				cnt++;
			}
			boolean existUncleanedRoom = false;
			for (int i = 0; i < 4; i++) {
				int nx = startx + dx[i];
				int ny = starty + dy[i];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
					continue;
				}

				if (map[nx][ny] == 0 && !cleaned[nx][ny]) {
					existUncleanedRoom = true;
				}
			}
		
			if (existUncleanedRoom) {
				int tmpdir = dir;
				for (int i = 0; i < 4; i++) {
					tmpdir--;
					if (tmpdir < 0) {
						tmpdir = 3;
					}
					int nx = startx + dx[tmpdir];
					int ny = starty + dy[tmpdir];
					if (map[nx][ny] == 0 && !cleaned[nx][ny]) {
						startx = nx;
						starty = ny;
						dir = tmpdir;
						break;
					}
				}
				

			} else {
				int tmpdir = (dir + 2) % 4;
				int nx = startx + dx[tmpdir];
				int ny = starty + dy[tmpdir];
				if (nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] == 1) {
					break;
				} else {
					startx = nx;
					starty = ny;
				}
			}

		}
		System.out.println(cnt);
	}

}