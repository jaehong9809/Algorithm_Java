using System;
using System.Collections.Generic;

class Program
{
    private static int[] dx = { -1, 1, 0, 0 };
    private static int[] dy = { 0, 0, -1, 1 };
    private static int[,] map;
    private static int t;
    private static int m, n, k;
    private static bool[,] visited;

    public static void Main(string[] args)
    {
        t = int.Parse(Console.ReadLine());
        while (t-- > 0)
        {
            var strings = Console.ReadLine().Split(' ');
            m = int.Parse(strings[0]);
            n = int.Parse(strings[1]);
            k = int.Parse(strings[2]);

            map = new int[m, n];
            visited = new bool[m, n];
            for (int i = 0; i < k; i++)
            {
                var split = Console.ReadLine().Split(' ');
                int a = int.Parse(split[0]);
                int b = int.Parse(split[1]);

                map[a, b] = 1;
            }

            int cnt = 0;
            for (int i = 0; i < m; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (!visited[i, j] && map[i, j] == 1)
                    {
                        BFS(i, j);
                        cnt++;
                    }
                }
            }

            Console.WriteLine(cnt);
        }
    }

    static void BFS(int x, int y)
    {
        Queue<(int a, int b)> q = new Queue<(int a, int b)>();

        q.Enqueue((x, y));

        visited[x, y] = true;
        while (q.Count > 0)
        {
            var valueTuple = q.Dequeue();

            for (int i = 0; i < 4; i++)
            {
                int nx = dx[i] + valueTuple.a;
                int ny = dy[i] + valueTuple.b;
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (visited[nx, ny]) continue;
                if (map[nx, ny] == 0) continue;

                visited[nx, ny] = true;
                q.Enqueue((nx, ny));
            }
        }
    }
}