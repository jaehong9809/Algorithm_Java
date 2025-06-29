#include<iostream>
#include<string>
#include<queue>
#include<set>
using namespace std;
set<pair<int, int>> visited;
char arr[101][101];
char arr2[101][101];
int n;
int cnt = 0;
void bfs(int x, int y, char tmp)
{
	queue<pair<int, int>> q;
	q.push({ x,y });
	visited.insert({ x,y });
	int dx[] = { 1,-1,0,0 };
	int dy[] = { 0,0,1,-1};
	while (!q.empty())
	{
		int a = q.front().first;
		int b = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++)
		{
			int newx = a + dx[i];
			int newy = b + dy[i];
			if (newx >= 0 && newx < n && newy >= 0 && newy < n)
			{
				if (visited.find({ newx, newy }) == visited.end()&&arr[a][b]==arr[newx][newy])
				{
					q.push({ newx,newy });
					visited.insert({ newx, newy });
				}
			}
		}
	}
	cnt++;
}
int main() {
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		string str;
		cin >> str;

		for (int j = 0; j < n; j++)
		{
			arr[i][j] = str[j];
		}
	}

	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{

			if (visited.find({i, j }) == visited.end())
			{
				bfs(i, j, arr[i][j]);
			}
		}
	}
	cout << cnt << " ";
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j] == 'G') arr[i][j] = 'R';
			else arr2[i][j] = arr[i][j];
		}
	}
	cnt = 0;
	visited.clear();
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < n; j++)
		{
			if (visited.find({ i, j }) == visited.end())
			{
				bfs(i, j, arr2[i][j]);
			}
		}
	}
	cout << cnt << endl;
}