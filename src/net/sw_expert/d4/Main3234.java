package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 준환이의 양팔저울 문제 풀이
// 좌측, 우측의 아이디어는 떠올랐지만, 중간에 expo 와 factorial 로 시간 단축을 하는 방법에 대한 풀이는 참고하였음.
public class Main3234 {
    static int[] weight;
    static int total, count;
    static boolean[] visited;
    static final int[] exponential = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };
    static final int[] factorial = { 0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880 };
    static void backtracking(int left, int right, int cnt){
        if(cnt == visited.length) {
            if(left >= right) count += 1;
            return;
        }

        if(left >= total - left) {
            count += exponential[visited.length - cnt] * factorial[visited.length - cnt];
            return;
        }

        for(int k = 0; k < weight.length; k++){
            if(!visited[k]){
                visited[k] = true;
                backtracking(left + weight[k], right, cnt + 1);
                if(left >= weight[k] + right)
                    backtracking(left, right + weight[k], cnt + 1);
                visited[k] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            weight = new int[N];
            visited = new boolean[N];
            total = 0;
            count = 0;
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                weight[l] = Integer.parseInt(st.nextToken());
                total += weight[l];
            }

            backtracking(0, 0, 0);
            System.out.printf("#%d %d\n", k + 1, count);
        }
    }
}
