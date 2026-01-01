using System;
using System.Collections.Generic;
using System.IO;

class Program
{
    static int n, m, v;
    private static List<List<int>> graph = new List<List<int>>();
    private static bool[] visited;

    public static void Main(string[] args)
    {
        string[] tmp = Console.ReadLine().Split(" ");
        n = int.Parse(tmp[0]);
        m = int.Parse(tmp[1]);
        v = int.Parse(tmp[2]);

        for (int i = 0; i <= n; i++)
        {
            graph.Add(new List<int>());
        }

        for (int i = 0; i < m; i++)
        {
            var strings = Console.ReadLine().Split(" ");
            int a = int.Parse(strings[0]);
            int b = int.Parse(strings[1]);

            graph[a].Add(b);
            graph[b].Add(a);
        }

        for (int i = 1; i <= n; i++)
        {
            graph[i].Sort();
        }

        visited = new bool[n + 1];
        dfs(v);
        Console.WriteLine();
        visited = new bool[n + 1];
        bfs(v);
    }

    static void dfs(int now)
    {
        Console.Write(now + " ");
        if (!visited[now])
        {
            visited[now] = true;
        }

        for (int i = 0; i < graph[now].Count; i++)
        {
            int next = graph[now][i];
            if (visited[next]) continue;

            visited[next] = true;
            dfs(next);
        }
    }

    static void bfs(int now)
    {
        Queue<int> q = new Queue<int>();
        q.Enqueue(now);
        visited[now] = true;
        while (q.Count > 0)
        {
            int current = q.Dequeue();
            Console.Write(current + " ");
            for (int i = 0; i < graph[current].Count; i++)
            {
                int next = graph[current][i];
                if (visited[next]) continue;

                visited[next] = true;
                q.Enqueue(next);
            }
        }
    }
}