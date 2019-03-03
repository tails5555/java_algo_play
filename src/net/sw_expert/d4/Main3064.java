package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// SW Expert D4 Binary Indexed Tree 문제 풀이
// Binary Indexed Tree 자료구조 문장 참조.
public class Main3064 {
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
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            BITree biTree = new BITree(N);
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 1; l <= N; l++){
                biTree.update(l, Integer.parseInt(st.nextToken()));
            }

            StringBuilder second = new StringBuilder();
            for(int l = 0; l < M; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int c = Integer.parseInt(st.nextToken());
                if(c == 1){
                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());
                    biTree.update(x, y);
                } else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    second.append(String.format("%d ", biTree.range_sum(a, b)));
                }
            }

            bw.write(String.format("#%d %s\n", k+1, second.toString()));
        }

        bw.flush();
    }
}
