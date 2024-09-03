import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    static int n, m;
    static int r, c;
    static int l;
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TEST_CASE = 1; TEST_CASE <= T; TEST_CASE++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            map = new int[n][m];

            for (int i = 0; i < n; i++) {
                String[] str = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                }
            }


            int res = bfs();
            sb.append("#" + TEST_CASE + " " + res + "\n");
        }
        System.out.println(sb);
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        queue.offer(new int[]{r, c});
        visited[r][c] = 1;
        int cnt = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowTunnel = map[now[0]][now[1]];
            cnt++;
            if(visited[now[0]][now[1]]==l) continue;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now[0];
                int ny = dy[i] + now[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (visited[nx][ny]!=0) continue;

                if (map[nx][ny] == 0) continue;


                if (nowTunnel == 1) {
                    if (i == 0) {
                        if (map[nx][ny] ==1||map[nx][ny] == 3 || map[nx][ny] == 6||map[nx][ny] == 7) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    if (i == 1) {
                        if (map[nx][ny] ==1||map[nx][ny] == 2 || map[nx][ny] == 4||map[nx][ny] == 7) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    if (i == 2) {
                        if (map[nx][ny] ==1||map[nx][ny] == 3 || map[nx][ny] == 4||map[nx][ny] == 5) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    if (i == 3) {
                        if (map[nx][ny] ==1||map[nx][ny] == 2 || map[nx][ny] == 5||map[nx][ny] == 6) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
                if (nowTunnel == 2) {
                    if (i == 1) {
                        if (map[nx][ny] == 1 || map[nx][ny] == 2||map[nx][ny] == 4||map[nx][ny] == 7) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    if (i == 3) {
                        if (map[nx][ny] == 1 || map[nx][ny] == 2||map[nx][ny] == 5||map[nx][ny] == 6) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
                if (nowTunnel == 3) {
                    if (i == 0) {
                        if (map[nx][ny] == 1 || map[nx][ny] == 3||map[nx][ny] == 6||map[nx][ny] == 7) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    if (i == 2) {
                        if (map[nx][ny] == 1 || map[nx][ny] == 3||map[nx][ny] == 4||map[nx][ny] == 5) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
                if (nowTunnel == 4) {
                    if (i == 0) {
                        if (map[nx][ny] == 1 || map[nx][ny] == 3||map[nx][ny] == 6||map[nx][ny] == 7) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    if (i == 3) {
                        if (map[nx][ny] == 1 || map[nx][ny] ==2||map[nx][ny] == 5||map[nx][ny] == 6) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
                if (nowTunnel == 5) {
                    if (i == 0) {
                        if (map[nx][ny] == 1 || map[nx][ny] ==3||map[nx][ny] == 6||map[nx][ny] == 7) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    if (i == 1) {
                        if (map[nx][ny] == 1 || map[nx][ny] ==2||map[nx][ny] == 4||map[nx][ny] == 7) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
                if (nowTunnel == 6) {
                    if (i == 1) {
                        if (map[nx][ny] == 1 || map[nx][ny] ==2||map[nx][ny] == 4||map[nx][ny] == 7) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    if (i == 2) {
                        if (map[nx][ny] == 1 || map[nx][ny] ==3||map[nx][ny] == 4||map[nx][ny] == 5) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
                if (nowTunnel == 7) {
                    if (i == 2) {
                        if (map[nx][ny] == 1 || map[nx][ny] ==3||map[nx][ny] == 4||map[nx][ny] == 5) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                    if (i == 3) {
                        if (map[nx][ny] == 1 || map[nx][ny] ==2||map[nx][ny] == 5||map[nx][ny] == 6) {
                            visited[nx][ny] = visited[now[0]][now[1]]+1;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return cnt;
    }
}