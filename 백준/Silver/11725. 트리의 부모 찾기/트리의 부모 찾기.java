import java.util.*;

class Main {
	static int n;
	static ArrayList<Integer>[] graph;
	static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		parent = new int[n + 1];
		graph = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a].add(b);
			graph[b].add(a);
		}
		func();
		for(int i=2; i<=n; i++) {
			System.out.println(parent[i]);
		}
	}

	public static void func() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				if (visited[next])
					continue;

				q.offer(next);
				parent[next] = now;
				visited[next]=true;
			}
		}
	}
}