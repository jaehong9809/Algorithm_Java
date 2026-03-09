
import java.util.*;
import java.io.*;

class Main {
	static int n, m;
	static char[][] map;
	static int max = 0;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Set<Character> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		set.add(map[0][0]);
		dfs(0, 0, 1);
		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt) {
		max = Math.max(max, cnt);
		// System.out.println(x+", "+y+": "+map[x][y]);

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if (set.contains(map[nx][ny]))
				continue;

			set.add(map[nx][ny]);
			dfs(nx, ny, cnt + 1);
			set.remove(map[nx][ny]);

		}
	}

}