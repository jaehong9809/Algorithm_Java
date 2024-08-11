import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main{
    static ArrayList<ArrayList<Integer>> arrayList=new ArrayList<>();
    static int n, m, k, start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        StringTokenizer st=new StringTokenizer(s);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= n; i++) {
            arrayList.add(new ArrayList<>());
        }
        for (int i = 0; i <m; i++) {
            s=br.readLine();
            st=new StringTokenizer(s);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(b);
        }
        int []cnt= bfs(start);
        int result=0;
        for (int i = 1; i <=n ; i++) {
            if(cnt[i]==k){
                System.out.println(i);
                result++;
            }
        }
        if (result==0) System.out.println(-1);

    }
    public static int[] bfs(int startx){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startx);
        int visited[]=new int[n+1];
        Arrays.fill(visited, -1);
        visited[startx]=0;
        
        while (!queue.isEmpty()) {
            int now=queue.poll();
            for (int i = 0; i < arrayList.get(now).size(); i++) {
                if(visited[arrayList.get(now).get(i)]==-1){
                    visited[arrayList.get(now).get(i)]=visited[now]+1;
                    queue.offer(arrayList.get(now).get(i));
                }
            }
        }
        return visited;
    }
}