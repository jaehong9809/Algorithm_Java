import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        TrieNode[] children = new TrieNode[10]; // 각 자리는 0~9까지 숫자를 저장
        boolean isEndOfNumber; // 현재 노드가 하나의 전화번호 끝인지 여부
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // 전화번호를 트라이에 삽입
        public boolean insert(String phoneNumber) {
            TrieNode node = root;
            for (int i = 0; i < phoneNumber.length(); i++) {
                int index = phoneNumber.charAt(i) - '0'; // 숫자에 해당하는 인덱스
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
                
                // 삽입 중간에 이미 끝나는 번호가 있으면 접두어 관계가 발생
                if (node.isEndOfNumber) {
                    return false;
                }
            }

            // 이미 이 번호가 다른 번호의 접두어인지 확인
            for (int i = 0; i < 10; i++) {
                if (node.children[i] != null) {
                    return false; // 이 번호가 다른 번호의 접두어임
                }
            }

            node.isEndOfNumber = true; // 전화번호 끝에 도달했음을 표시
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            boolean isConsistent = true;

            for (int j = 0; j < n; j++) {
                String phoneNumber = br.readLine();
                if (!trie.insert(phoneNumber)) {
                    isConsistent = false;
                }
            }

            if (isConsistent) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
