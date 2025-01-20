import java.util.*;

class Main{
    // 넓이, 높이, 무게
    static class Brick{
        int index;
        int d;
        int h;
        int w;

        public Brick(int index, int d, int h, int w) {
            this.index = index;
            this.d = d;
            this.h = h;
            this.w = w;
        }
    }

    static ArrayList<Brick> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] d=new int[n+1];
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            list.add(new Brick(i, a, b, c));
        }

        Collections.sort(list, (a, b)-> b.d - a.d);

        int[] trace = new int[n+1];

        for(int i=0; i<n; i++){
            d[i] = list.get(i).h;
            trace[i]=i;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(list.get(j).w > list.get(i).w && d[j] + list.get(i).h > d[i]){
                    d[i] = d[j] + list.get(i).h;
                    trace[i]=j;
                }
            }
        }
        int maxHeight = 0;
        int lastIndex = 0;
        for (int i = 0; i < n; i++) {
            if (d[i] > maxHeight) {
                maxHeight = d[i];
                lastIndex = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        while (true){
            result.add(list.get(lastIndex).index);
            if(lastIndex ==trace[lastIndex]) break;
            lastIndex = trace[lastIndex];
        }
        System.out.println(result.size());

        for(int i : result){
            System.out.println(i);
        }
    }
}