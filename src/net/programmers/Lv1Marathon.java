package net.programmers;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스 완주하지 못한 자 문제
public class Lv1Marathon {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> counter = new HashMap<>();
        for(int k=0;k<participant.length;k++){
            int cnt = counter.getOrDefault(participant[k], 0);
            counter.put(participant[k], cnt + 1);
        }

        for(int k=0;k<completion.length;k++){
            int cnt = counter.getOrDefault(completion[k], 0);
            if(cnt > 0) {
                if(cnt - 1 == 0)
                    counter.remove(completion[k]);
                else
                    counter.put(completion[k], cnt - 1);
            }
        }

        String tmp = "";
        for(String member : counter.keySet()) {
            tmp = member;
        }

        return tmp;
    }

    public static void main(String[] args){
        System.out.println(solution(new String[] { "leo", "kiki", "eden" }, new String[] { "eden", "kiki" }));
        System.out.println(solution(new String[] { "marina", "josipa", "nikola", "vinko", "filipa" }, new String[] { "josipa", "filipa", "marina", "nikola" }));
        System.out.println(solution(new String[] { "mislav", "stanko", "mislav", "ana" }, new String[] { "stanko", "ana", "mislav" }));
        System.out.println(solution(new String[] { "김한국", "이경래", "양종원", "김종국", "곰팽이" }, new String[] { "이경래", "양종원", "김종국", "김한국" }));
    }
}
