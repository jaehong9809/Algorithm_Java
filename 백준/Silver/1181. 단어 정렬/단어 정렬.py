import sys

n = int(input())

d = []

for _ in range(n):
    d.append(input())
    
d = list(set(d))

d.sort(key = lambda x: (len(x), x))
for i in d:
    print(i)