import java.util.*;
class Solution {
    static boolean[] visited;
    static int n, m;
    static Set<String> results = new HashSet<>();
    static ArrayList<Integer>[] lists;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        visited = new boolean[user_id.length];
        n = banned_id.length;
        m = user_id.length;
        lists = new ArrayList[n];
        for(int i=0; i<n; i++){
            lists[i] = new ArrayList<>();
        }
        
        for(int i = 0; i< banned_id.length; i++){
            String ban = banned_id[i];
            for(int j=0; j<user_id.length; j++){
                String user = user_id[j];
                
                if(user.length() == ban.length()){
                    boolean sign = true;
                    for(int k=0; k<ban.length(); k++){
                        if(ban.charAt(k) != user.charAt(k) && ban.charAt(k)!='*'){
                            sign = false;
                            break;
                        }
                        
                    }
                    if(sign){
                        lists[i].add(j);
                    }
                    
                }
                
            }
        }
        
        dfs(0,user_id );
       
        return results.size();
    }
    static void dfs(int depth, String[] user_id){
        if(depth ==n){
            String tmp = "";
            for(int i=0; i<m; i++){
                if(visited[i]){
                    tmp += user_id[i]+" ";
                }
            }
            results.add(tmp);
            return;
        }
        
        for(int i=0; i<lists[depth].size(); i++){
            if(!visited[lists[depth].get(i)]){
                visited[lists[depth].get(i)]=true;
                dfs(depth+1, user_id);
                visited[lists[depth].get(i)]=false;
            }
            
        }
    }
    
    
}