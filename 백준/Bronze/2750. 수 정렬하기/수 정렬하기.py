import sys
import heapq
input = sys.stdin.readline

n = int(input())
d = []
for _ in range(n):
    d.append(int(input()))
d.sort()

for i in d:
    print(i)
