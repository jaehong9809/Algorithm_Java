import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int x, y;
	static int k;
	static int[][] map;
	static int left = 0;
	static int right = 0;
	static int front = 0;
	static int back = 0;
	static int down = 0;
	static int up = 0;
	static int[] dx = { 0, 0, 0, -1, 1 };
	static int[] dy = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		String[] input = br.readLine().split(" ");

		for (String tmp : input) {
			int dir = Integer.parseInt(tmp);
			if (move(dir)) {
				System.out.println(up);
			}
		}
	}

	static boolean move(int dir) {
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		if (nx < 0 || nx >= n || ny < 0 || ny >= m)
			return false;
		int tmp = map[nx][ny];
		if (dir == 1) {
			int t = right;
			right = up;
			up = left;
			left = down;
			down = t;
			if (tmp == 0) {
				map[nx][ny] = down;
			} else {
				down = map[nx][ny];
				map[nx][ny] = 0;
			}
		} else if (dir == 2) {
			int t = left;
			left = up;
			up = right;
			right = down;
			down = t;
			if (tmp == 0) {
				map[nx][ny] = down;
			} else {
				down = map[nx][ny];
				map[nx][ny] = 0;
			}
		} else if (dir == 3) {
			int t = back;
			back = up;
			up = front;
			front = down;
			down = t;
			if (tmp == 0) {
				map[nx][ny] = down;
			} else {
				down = map[nx][ny];
				map[nx][ny] = 0;
			}
		} else {
			int t = front;
			front = up;
			up = back;
			back = down;
			down = t;
			if (tmp == 0) {
				map[nx][ny] = down;
			} else {
				down = map[nx][ny];
				map[nx][ny] = 0;
			}
		}
		x = nx;
		y = ny;

		return true;
	}
}
