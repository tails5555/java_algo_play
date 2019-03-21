package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 2559 번 KOI 2011 초등부 수열 문제 풀이
public class Main2559 {
    static class BinaryIndexedTree {
        private int[] node;
        private int length;

        public BinaryIndexedTree(int size) {
            this.node = new int[size + 1];
            this.length = size;
        }

        public int read(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += node[idx];
                idx -= (idx & -idx);
            }
            return sum;
        }

        public void update(int idx, int val) {
            while (idx < node.length) {
                node[idx] += val;
                idx += (idx & -idx);
            }
        }

        public int range_sum(int l, int r) {
            return read(r) - read(l - 1);
        }

        public int length() {
            return this.length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        BinaryIndexedTree bit = new BinaryIndexedTree(N + 1);
        for(int k = 1; k <= N; k++){
            bit.update(k, Integer.parseInt(st.nextToken()));
        }

        int res = Integer.MIN_VALUE;
        for(int k = 1; k <= N - M + 1; k++){
            res = Math.max(res, bit.range_sum(k, k + (M - 1)));
        }

        System.out.println(res);
    }
}
