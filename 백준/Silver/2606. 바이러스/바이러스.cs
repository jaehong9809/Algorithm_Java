using System;
using System.Collections.Generic;

class Program
{
    private static int v, e;
    private static List<int>[] graph;

    public static void Main(string[] args)
    {
        v = int.Parse(Console.ReadLine());
        e = int.Parse(Console.ReadLine());

        graph = new List<int>[v + 1];

        for (int i = 0; i <= v; i++)
        {
            graph[i] = new List<int>();
        }

        for (int i = 0; i < e; i++)
        {
            var strings = Console.ReadLine().Split(" ");
            int a = int.Parse(strings[0]);
            int b = int.Parse(strings[1]);

            graph[a].Add(b);
            graph[b].Add(a);
        }
        
        Console.Write(BFS(1) - 1);
    }

    static int BFS(int start)
    {
        Queue<int> queue = new Queue<int>();
        queue.Enqueue(start);
        bool[] visited = new bool[v + 1];

        visited[start] = true;
        int cnt = 0;
        while (queue.Count > 0)
        {
            var now = queue.Dequeue();
            cnt++;

            for (int i = 0; i < graph[now].Count; i++)
            {
                var next = graph[now][i];
                if (visited[next]) continue;

                queue.Enqueue(next);
                visited[next] = true;
            }
        }

        return cnt;
    }
}