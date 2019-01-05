package net.programmers;

// Programmers Lv2 타겟 넘버 문제 풀Yee
public class Lv2TargerNum {
    static boolean[] visited;
    static int conf;
    static int cnt;
    static void dfs(int[] numbers, int idx, int value){
        if(idx == numbers.length) {
            if(value == conf){
                cnt += 1;
            }
            return;
        }
        visited[idx] = false;
        dfs(numbers, idx + 1, value + numbers[idx] * (-1));
        visited[idx] = true;
        dfs(numbers, idx + 1, value + numbers[idx]);
    }

    public static int solution(int[] numbers, int target) {
        visited = new boolean[numbers.length];
        conf = target;
        dfs(numbers, 0, 0);
        return cnt;
    }

    public static void main(String[] args){
        System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));
    }
}
