package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Baekjoon 2250 번 트리의 높이와 너비 문제 풀이
// 이는 inorder 를 더욱 응용해야 잘 풀 수 있는 문제임. 풀이를 참조하였으나,
public class Main2250 {
    static final int MAX = 87654321;
    static class Node {
        int left;
        int right;
        public Node(int left, int right){
            this.left = left;
            this.right = right;
        }
    }

    static Node[] nodes;
    static int[] node_cnt; // 루트를 찾기 위한 배열 생성
    static int[] low, high;
    static int root_idx;

    static void inorder(int node, int idx) {
        if(nodes[node].left > 0) inorder(nodes[node].left, idx + 1);
        low[idx] = Math.min(low[idx], root_idx);
        high[idx] = Math.max(high[idx], root_idx++);
        if(nodes[node].right > 0) inorder(nodes[node].right, idx + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        low = new int[N + 1];
        Arrays.fill(low, MAX);

        high = new int[N + 1];
        node_cnt = new int[N + 1];
        nodes = new Node[N + 1];

        for(int k = 0; k < N; k++){
            st = new StringTokenizer(br.readLine(), " ");

            int parent = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            node_cnt[parent] += 1;
            if(left != -1) {
                node_cnt[left] += 1;
            }
            if(right != -1) {
                node_cnt[right] += 1;
            }

            nodes[parent] = new Node(left, right);
        }

        // 루트를 찾는 방법은 간단하다.
        // parent, left, right 에서 선언 되었던 횟수 중 1개인 경우가 Root 노드가 된다.
        int root = -1;
        for(int k = 1; k <= N; k++){
            if(node_cnt[k] == 1)
                root = k;
        }

        root_idx = 1;
        inorder(root, 1);

        int result = high[1] - low[1] + 1;
        int level = 1;
        for(int k = 2; k <= N; k++){
            int temp = high[k] - low[k] + 1;
            if (temp > result) {
                result = temp;
                level = k;
            }
        }

        System.out.printf("%d %d\n", level, result);
    }
}
