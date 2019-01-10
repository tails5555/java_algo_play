package net.baekjoon.backtraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 1759번 문제 풀이
public class Main1759 {
    static char[] alps;
    static boolean[] visited;
    static int L;
    static StringBuilder sb = new StringBuilder();

    public static void backtracking(int idx, int cnt){
        if(cnt == L){
            StringBuilder tmp = new StringBuilder();
            int aeiouCnt = 0;
            int nonAeiouCnt = 0;
            for(int k=0;k<visited.length;k++){
                if(visited[k]) {
                    tmp.append(String.format("%c", alps[k]));
                    if(alps[k] == 'a' || alps[k] == 'e' || alps[k] == 'i' || alps[k] == 'o' || alps[k] == 'u') aeiouCnt += 1;
                    else nonAeiouCnt += 1;
                }
            }
            if(aeiouCnt >= 1 && nonAeiouCnt >= 2) {
                sb.append(tmp.toString());
                sb.append('\n');
            }
            return;
        }

        for(int k=idx;k<alps.length;k++){
            if(!visited[k]) {
                visited[k] = true;
                backtracking(k, cnt + 1);
                visited[k] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        alps = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine(), " ");
        for(int k=0;k<C;k++){
            alps[k] = st.nextToken().charAt(0);
        }
        Arrays.sort(alps);

        backtracking(0, 0);

        System.out.print(sb.toString());
    }
}
