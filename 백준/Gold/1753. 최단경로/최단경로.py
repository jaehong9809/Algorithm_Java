import heapq
import sys
input = sys.stdin.readline
v, e = map(int, input().split(" "))
start = int(input())
INF = 1000000000

d = [INF for i in range(v + 1)]

graph = [[] for i in range(v + 1)]

for i in range(e):
    a, b, c = map(int, input().split(" "))
    graph[a].append((b, c))


def dijkstra(v, e, start):
    hq = []

    heapq.heappush(hq, (0, start))
    d[start] = 0

    while hq:
        cost, now = heapq.heappop(hq)

        if d[now] < cost:
            continue

        for node in graph[now]:
            next = node[1] + d[now]
            if next < d[node[0]]:
                heapq.heappush(hq, (next, node[0]))
                d[node[0]] = next


dijkstra(v, e, start)

for i in range(1, v + 1):
    if d[i] == INF:
        print("INF")
    else:
        print(d[i])
