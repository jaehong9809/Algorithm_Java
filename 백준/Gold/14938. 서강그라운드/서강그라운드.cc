#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
using namespace std;
#define INF 1e9

int n, m, r;

vector<int> items(101, 0);

int graph[101][101];

int main() {
	cin >> n >> m >> r;

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (i == j)graph[i][j] = 0;
			else {
				graph[i][j] = INF;
			}
		}
	}
	for (int i = 1; i <= n; i++)
	{
		int item;
		cin >> item;
		items[i] = item;
	}
	for (int i = 0; i < r; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		graph[a][b] = c;
		graph[b][a] = c;

	}
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
			}
		}
	}

	vector<int> result;
	for (int i = 1; i <= n; i++) {
		int total = 0;
		for (int j = 1; j <= n; j++) {
			if (graph[i][j] <= m)total += items[j];
		}
		result.push_back(total);
	}
	cout << *max_element(result.begin(), result.end());
}
