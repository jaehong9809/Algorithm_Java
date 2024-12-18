import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> rank = new HashMap<>();
        Map<String, Person> people = new HashMap<>();
        int[] results = new int[friends.length];
        for (String friend : friends) {
            rank.put(friend, 0);
            people.put(friend, new Person());
        }

        for (String gift : gifts) {
            String[] s = gift.split(" ");
            String a = s[0];
            String b = s[1];
            people.get(a).give.put(b, people.get(a).give.getOrDefault(b,0)+1);
            people.get(a).give_num++;
            people.get(b).take.put(a, people.get(b).take.getOrDefault(a,0)+1);
            people.get(b).take_num++;
        }
        for (String s : people.keySet()) {
            Person person = people.get(s);
            rank.put(s, person.give_num- person.take_num);
        }


        for (int i = 0; i < friends.length; i++) {
            String a = friends[i];
            for (int j = 0; j < friends.length; j++) {
                if(i==j) continue;
                String b = friends[j];
                int atob = people.get(a).give.getOrDefault(b, 0);
                int btoa = people.get(b).give.getOrDefault(a, 0);

                if(atob>btoa) results[i]++;
                else if(atob ==btoa || (atob==0 && btoa==0)){
                    if(rank.get(a)>rank.get(b)){
                        results[i]++;
                    }
                }
            }
        }
        for (int result : results) {
            answer = Math.max(result, answer);
        }
        return answer;
    }

    public static class Person{
        Map<String, Integer> give = new HashMap<>();
        Map<String, Integer> take = new HashMap<>();
        int give_num=0;
        int take_num=0;

        public Person() {
        }
    }

}