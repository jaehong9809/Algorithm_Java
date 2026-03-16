import java.util.*;
import java.io.*;

class Main {
	static int n, e;
	static ArrayList<int[]>[] graph;
	static int INF = (int)1e9;
	static int start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<int[]>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[a].add(new int[] { b, c });
			graph[b].add(new int[] { a, c });
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		long total1 = 0;
		total1 += dijkstra(1, start);
		total1 += dijkstra(start, end);
		total1 += dijkstra(end, n);
		long total2 = 0;
		total2 += dijkstra(1, end);
		total2 += dijkstra(end, start);
		total2 += dijkstra(start, n);

		long total = Math.min(total1,  total2);
		if(total>=INF)System.out.println(-1);
		else System.out.println(total);
	}

	static int dijkstra(int ss, int ee) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[1] - b[1];
		});
		pq.offer(new int[] { ss, 0 });
		int[] d = new int[n + 1];
		Arrays.fill(d, INF);
		d[ss] = 0;
		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			int now = poll[0];
			int cost = poll[1];
			if (d[now] < cost)
				continue;

			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i)[0];
				int nextCost = graph[now].get(i)[1];
				if (d[next] > d[now] + nextCost) {
					d[next] = d[now] + nextCost;
					pq.offer(new int[] { next, d[next] });
				}
			}

		}
		return d[ee];
	}
}