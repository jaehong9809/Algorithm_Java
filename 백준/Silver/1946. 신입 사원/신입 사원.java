import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//1946
class Main{
    static class Grade implements Comparable<Grade>{
        public int x;
        public int y;

        public Grade(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Grade o) {
            return this.x-o.x;
        }
    }
    static int t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t=Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < t; test_case++) {

            ArrayList<Grade> arrayList = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                int a, b;
                String s = br.readLine();
                StringTokenizer st=new StringTokenizer(s);
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                arrayList.add(new Grade(a, b));
            }
            Collections.sort(arrayList);
            int cnt = 1;
            int min=arrayList.get(0).y;
//시간 초과 알고리즘 2중 for문으로 인한 O(n^2)
//            for (int i = 0; i <n ; i++) {
//                for (int j = 0; j <=i-1; j++) {
//                    if(i==j)continue;
//                    if((arrayList.get(i).x>arrayList.get(j).x)&&(arrayList.get(i).y>arrayList.get(j).y)){
//                      cnt--;
//                      break;
//                    }
//                }
//            }

            for (int i = 0; i < n; i++) {
                if(arrayList.get(i).y<min){
                    min = arrayList.get(i).y;
                    cnt++;
                }
            }
            bw.write(cnt+"\n");

        }
        bw.flush();
        bw.close();
    }
}