#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;
#define INF 1e9

int N, M;

vector<pair<int, int>> graph[50001];

int d[50001];
void dijkstra(int startx) {
	priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
	pq.push({ startx, 0 });
	d[startx] = 0;
	while (!pq.empty()) {
		int dist = pq.top().second;
		int now = pq.top().first;
		pq.pop();
		if (d[now] < dist)continue;
		for (int i = 0; i < graph[now].size(); i++) {
			int cost = dist + graph[now][i].second;
			if (d[graph[now][i].first] > cost) {
				d[graph[now][i].first] = cost;
				pq.push({ graph[now][i].first , cost });
			}
		}

	}
}

int main() {
	cin >> N >> M;
	fill(d, d+50001, INF);
	for (int i = 0; i < M; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		graph[a].push_back({ b, c });
		graph[b].push_back({ a, c });
	}
	dijkstra(1);
	cout << d[N] << '\n';
}