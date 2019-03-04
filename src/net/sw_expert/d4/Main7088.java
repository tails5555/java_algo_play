package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SW Expert D4 은기의 송아지 세기 문제 풀기
public class Main7088 {
    static class BITree {
        int[] node;

        public BITree(int size) {
            this.node = new int[size + 1];
        }

        public int read(int idx){
            int sum = 0 ;
            while(idx > 0){
                sum += node[idx];
                idx -= (idx & -idx);
            }
            return sum;
        }

        public void update(int idx, int val){
            while (idx < node.length){
                node[idx] += val;
                idx += (idx & -idx);
            }
        }

        public int range_sum(int l,int r){
            return read(r) - read(l-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            BITree[] cows = new BITree[3];
            for(int l = 0; l < 3; l++){
                cows[l] = new BITree(N);
            }
            for(int l = 1; l <= N; l++){
                int cow = Integer.parseInt(br.readLine());
                cows[cow - 1].update(l, 1);
            }

            StringBuilder sb = new StringBuilder();
            for(int l = 1; l <= Q; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                for(int m = 0; m < 3; m++){
                    sb.append(String.format("%d ", cows[m].range_sum(from, to)));
                }
                sb.append("\n");
            }

            bw.write(String.format("#%d\n", k + 1) + sb.toString());
        }

        bw.flush();
    }
}
