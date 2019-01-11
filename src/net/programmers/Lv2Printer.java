package net.programmers;

import java.util.LinkedList;
import java.util.Queue;

// Programmers 프린터 문제 풀Yee
public class Lv2Printer {
    static boolean[] visited;
    public static boolean printed(int[] priorities, int idx){
        for(int k=0;k<priorities.length;k++){
            if(priorities[k] > priorities[idx] && !visited[k]) {
                return false;
            }
        }
        return true;
    }

    public static int solution(int[] priorities, int location){
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[priorities.length];
        for(int k=0;k<priorities.length;k++){
            queue.offer(k);
        }

        for(int k=0;k<priorities.length;k++) {
            for(int l=0;l<queue.size();l++) {
                int tmp = queue.poll();
                if (printed(priorities, tmp)) {
                    if(location == tmp) return k + 1;
                    else {
                        visited[tmp] = true;
                        break;
                    }
                } else {
                    queue.offer(tmp);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] { 2, 1, 3, 2 }, 2));
        System.out.println(solution(new int[] { 1, 1, 9, 1, 1, 1 }, 0));
    }
}
