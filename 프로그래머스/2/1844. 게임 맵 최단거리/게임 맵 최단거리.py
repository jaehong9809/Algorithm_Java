from collections import deque

def bfs(maps):
    dx = (-1, 1, 0, 0)
    dy = (0, 0, -1, 1)
    queue = deque()
    queue.append([0, 0])
    
    n = len(maps)
    m = len(maps[0])
    
    visited = [ [False for _ in range(m)] for _ in range(n)]
    visited[0][0]=True
    
    
    while queue:
        now = queue.popleft()
        
        for i in range(4):
            nx = dx[i] + now[0]
            ny = dy[i] + now[1]
            
            if 0<=nx<n and 0<=ny<m and not visited[nx][ny] and maps[nx][ny] != 0:
                queue.append([nx, ny])
                maps[nx][ny] = maps[now[0]][now[1]]+1
                visited[nx][ny]=True
    return maps[n-1][m-1]
def solution(maps):
    answer = bfs(maps)
    
    return answer if answer != 1 else -1