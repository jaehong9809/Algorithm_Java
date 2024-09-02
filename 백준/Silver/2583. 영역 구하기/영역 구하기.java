import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int M, N, K;
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> result = new ArrayList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[M + 1][N + 1];
		visited = new boolean[M + 1][N + 1];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			for (int j = a; j < c; j++) {
				for (int q = b; q < d; q++) {
					map[q][j] = 1;
				}
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 0) {
					bfs(i, j);
				}
			}
		}

		Collections.sort(result);
		System.out.println(result.size());
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();

	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;
		int cnt = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			cnt++;
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + now[0];
				int ny = dy[i] + now[1];
				if (nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;

				if (!visited[nx][ny] && map[nx][ny] == 0) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}
			}

		}
		result.add(cnt);
	}

}