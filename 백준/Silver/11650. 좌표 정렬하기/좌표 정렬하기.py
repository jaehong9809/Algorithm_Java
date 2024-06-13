n = int(input())

d = []

for i in range(n):

    d.append(list(map(int, input().split())))


d.sort(key = lambda x: (x[0], x[1]))

for i in d:
    print(i[0], i[1])