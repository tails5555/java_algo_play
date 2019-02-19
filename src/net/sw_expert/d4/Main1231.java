package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 중위순회 문제 풀이
public class Main1231 {
    static int N;
    static StringBuilder inOd;
    static Node[] node;

    static class Node {
        String tmp;
        int left;
        int right;

        public Node(String tmp, int left, int right){
            this.tmp = tmp;
            this.left = left;
            this.right = right;
        }
    }

    static void inOrder(int idx){
        Node n = node[idx];
        if(n.left != -1) inOrder(n.left);
        inOd.append(n.tmp);
        if(n.right != -1) inOrder(n.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int k = 0; k < 10; k++) {
            N = Integer.parseInt(br.readLine());
            inOd = new StringBuilder();
            node = new Node[N + 1];
            for(int l = 1; l <= N; l++){
                st = new StringTokenizer(br.readLine(), " ");
                int idx = Integer.parseInt(st.nextToken());
                String tmp = st.nextToken();
                int left = -1;
                int right = -1;
                if(st.hasMoreTokens()){
                    left = Integer.parseInt(st.nextToken());
                }
                if(st.hasMoreTokens()){
                    right = Integer.parseInt(st.nextToken());
                }
                node[idx] = new Node(tmp, left, right);
            }

            inOrder(1);
            System.out.printf("#%d %s\n", k+1, inOd.toString());
        }
    }
}
