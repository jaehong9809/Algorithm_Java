import java.util.*;

class Solution {
    static boolean[] visited = new boolean[11];
    static Map<String, Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        
        for(String order : orders){
            for(int c : course){
                if(c > order.length()){
                    break;
                }
                visited = new boolean[11];
                dfs(0, 0, c, order);
            }
        }
        ArrayList<String> results = new ArrayList<>();
        int[] tmp = new int[course.length];
        
        for(int i=0; i<course.length; i++){
            int max = -1;
            
            for(String key : map.keySet()){
                if(key.length()==course[i]){
                    if(max < map.get(key)){
                        max = map.get(key);
                    }
                }
            }
            tmp[i] = max;
        }
        for(int a : tmp){
            System.out.println(a);
        }
        for(int i=0; i<course.length; i++){
            
            for(String key : map.keySet()){
                if(course[i] ==key.length()){
                    if(tmp[i]==map.get(key) &&map.get(key)>=2) results.add(key);
                }
            }
        }
        
        Collections.sort(results);
        
        String[] answer = new String[results.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = results.get(i);
        }
        return answer;
    }
    
    static void dfs(int start, int depth, int limit, String orders){
        if(depth == limit){
            ArrayList<Character> tmp = new ArrayList<>();
            
            for(int i=0; i<orders.length(); i++){
                if(visited[i]){
                    tmp.add(orders.charAt(i));
                }
            }
            Collections.sort(tmp);
            String str = "";
            for(Character c : tmp){
                str+=c;
            }
            map.put(str, map.getOrDefault(str, 0)+1);
            return;
        }
        for(int i=start; i<orders.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i+1, depth+1, limit, orders);
                visited[i] = false;
            }
        }
        
    }
}