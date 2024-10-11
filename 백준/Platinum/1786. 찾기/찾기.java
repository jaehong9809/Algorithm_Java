import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String text = br.readLine();  // T 입력
        String pattern = br.readLine();  // P 입력
        
        // 패턴의 시작 위치 탐색
        List<Integer> result = kmp(text, pattern);
        
        // 패턴이 발견된 횟수 출력
        System.out.println(result.size());
        
        // 패턴이 발견된 시작 위치 출력
        for (int idx : result) {
            System.out.print(idx + " ");
        }
    }
    
    public static List<Integer> kmp(String text, String pattern) {
        int[] pi = getPi(pattern);
        List<Integer> result = new ArrayList<>();
        int j = 0;
        
        // 텍스트에서 패턴 찾기
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];  // j를 pi 배열 값으로 이동
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == pattern.length() - 1) {
                    result.add(i - j + 1);  // 패턴이 일치하는 위치 저장
                    j = pi[j];  // 다음 검색을 위해 j를 이동
                } else {
                    j++;
                }
            }
        }
        return result;
    }
    
    public static int[] getPi(String pattern) {
        int[] pi = new int[pattern.length()];
        int j = 0;
        
        for (int i = 1; i < pattern.length(); i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = pi[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                pi[i] = ++j;
            }
        }
        return pi;
    }
}
