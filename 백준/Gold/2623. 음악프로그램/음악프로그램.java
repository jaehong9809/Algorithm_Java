import java.util.*;
import java.io.*;

class Main {
	static int n, m;
	static ArrayList<Integer>[] graph;
	static int[] indegrees;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		indegrees = new int[n + 1];

		graph = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");

			for (int j = 2; j < s.length; j++) {
				int now = Integer.parseInt(s[j]);
				int past = Integer.parseInt(s[j - 1]);
				graph[past].add(now);
				indegrees[now]++;
			}
		}
		func();
	}

	public static void func() {
		Queue<Integer> q = new ArrayDeque<Integer>();
		for (int i = 1; i <= n; i++) {
			if (indegrees[i] == 0)
				q.offer(i);
		}
		List<Integer> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int now = q.poll();
			list.add(now);
			sb.append(now + "\n");
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				if (indegrees[next] > 0)
					indegrees[next]--;
				if (indegrees[next] == 0)
					q.offer(next);
			}
		}
		if (list.size() != n)
			System.out.println(0);
		else
			System.out.println(sb.toString());

	}
}