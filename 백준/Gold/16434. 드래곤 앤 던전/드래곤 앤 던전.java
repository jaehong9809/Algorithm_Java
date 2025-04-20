import java.util.Scanner;

class Main {
    static int atk, n;
    static Node[] nodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        atk = sc.nextInt();
        nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            nodes[i] = new Node(a, b, c);
        }

        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long left = 1;
        long right = (long) 1e18;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (calc(mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }

    static boolean calc(long maxHp) {
        long curAtk = atk;
        long hp = maxHp;

        for (int i = 0; i < n; i++) {
            Node node = nodes[i];

            if (node.type == 1) {
                // 몬스터 방
                long monsterAtk = node.x;
                long monsterHp = node.y;

                long turnsToKill = (monsterHp + curAtk - 1) / curAtk;
                long damage = monsterAtk * (turnsToKill - 1);
                hp -= damage;

                if (hp <= 0) return false;
            } else {
                // 포션 방
                curAtk += node.x;
                hp = Math.min(maxHp, hp + node.y);
            }
        }
        return true;
    }

    static class Node {
        int type;
        int x, y;

        public Node(int type, int x, int y) {
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }
}