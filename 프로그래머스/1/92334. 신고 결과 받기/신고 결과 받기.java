import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> map =new HashMap<>();
        Map<String, HashSet<String>> tmp = new HashMap<>();
        for(String id : id_list){
            map.put(id, 0);
            tmp.put(id, new HashSet<>());
        }
        
        for(String re : report){
            String[] s = re.split(" ");
            String a = s[0];
            String b = s[1];
            tmp.get(b).add(a);
        }
        
        for(String id : id_list){
            if(tmp.get(id).size()>=k){
                for(String s : tmp.get(id)){
                    map.put(s, map.get(s)+1);
                }
            }
        }        
        int n = id_list.length;
        int[] answer = new int[n];
        for(int i=0;i<n; i++){
            answer[i] = map.get(id_list[i]);
        }
        
        
        return answer;
    }
}