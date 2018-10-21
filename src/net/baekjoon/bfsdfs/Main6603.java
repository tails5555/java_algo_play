package net.baekjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Baekjoon 6603 번 문제 풀이
public class Main6603 {
    static int[] lotto;
    static StringBuilder sb;
    static int count;
    public static void dfs(String str, int idx){
        if(count == 6){
            sb.append(str + "\n");
        } else {
            for(int k=idx+1;k<lotto.length;k++){
                count = count + 1;
                dfs(String.format("%s%d ", str, lotto[k]), k);
            }
        }
        count = count - 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int size = Integer.parseInt(st.nextToken());
            if(size == 0) break;
            lotto = new int[size];
            for(int k=0;k<size;k++){
                lotto[k] = Integer.parseInt(st.nextToken());
            }
            sb = new StringBuilder();
            for(int k=0;k<size;k++) {
                count = 1;
                dfs(String.format("%d ", lotto[k]), k);
            }
            sb.append("\n");
            bw.write(sb.toString());
        }
        bw.flush();
        bw.close();
    }
}
