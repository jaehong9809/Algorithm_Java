import java.util.*;
import java.io.*;

public class Main {
	static int n, m;
	static int[] indegrees;
	static ArrayList<Integer>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		indegrees = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			indegrees[b]++;
		}
		func();
	}

	static void func() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (indegrees[i]== 0)
				q.offer(i);
		}

		while (!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now+" ");
			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				
				if(indegrees[next]>0) indegrees[next]--;
				
				if(indegrees[next]==0) {
					q.offer(next);
				}
			}

		}

	}

}
