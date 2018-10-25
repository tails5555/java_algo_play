package net.baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 1991번 문제 풀이
public class Main1991 {
    static int[][] tree = new int[26][2];

    static void preOrder(int node){
        if(node == '.' - 'A') return;
        System.out.print((char)(node + 'A'));
        preOrder(tree[node][0]);
        preOrder(tree[node][1]);
    }

    static void inOrder(int node){
        if(node == '.' - 'A') return;
        inOrder(tree[node][0]);
        System.out.print((char)(node + 'A'));
        inOrder(tree[node][1]);
    }

    static void postOrder(int node){
        if(node == '.' - 'A') return;
        postOrder(tree[node][0]);
        postOrder(tree[node][1]);
        System.out.print((char)(node + 'A'));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int k=0;k<N;k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[data - 'A'][0] = left - 'A';
            tree[data - 'A'][1] = right - 'A';
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }
}
