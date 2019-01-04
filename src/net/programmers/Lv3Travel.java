package net.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// Programmers Lv3 여행 경로 문제 풀Yee
public class Lv3Travel {
    static List<Stack<String>> res;
    public static void dfs(String[][] tickets, boolean[] visited, Stack<String> stack, int cnt){
        if(cnt == tickets.length) {
            Stack<String> fin = new Stack<>();
            for(String st : stack) {
                fin.push(st);
            }
            res.add(fin);
            return;
        }

        String arrive = stack.peek();

        for(int k=0;k<tickets.length;k++){
            if(tickets[k][0].equals(arrive) && !visited[k]) {
                stack.push(tickets[k][1]);
                visited[k] = true;

                dfs(tickets, visited, stack, cnt+1);

                visited[k] = false;
                stack.pop();
            }
        }
    }

    public static String[] solution(String[][] tickets){
        res = new ArrayList<>();
        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            } else return o1[0].compareTo(o2[0]);
        });

        Stack<String> tmp = new Stack<>();
        boolean[] used = new boolean[tickets.length];
        tmp.push("ICN");

        dfs(tickets, used, tmp, 0);

        if(res.size() > 1) {
            Collections.sort(res, (Stack<String> o1, Stack<String> o2) -> {
                for(int k=0;k<o1.size();k++){
                    String s1 = o1.get(k);
                    String s2 = o2.get(k);

                    if (!s1.equals(s2)) {
                        return s1.compareTo(s2);
                    }
                }
                return 0;
            });
        }

        return res.get(0).stream().toArray(String[]::new);
    }

    public static void main(String[] args){
        String[][] tickets1 = {
            { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" }
        };
        String[][] tickets2 = {
            { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" }
        };

        System.out.println(Arrays.toString(solution(tickets1)));
        System.out.println(Arrays.toString(solution(tickets2)));
    }
}
