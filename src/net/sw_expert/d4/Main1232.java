package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// SW Expert D4 사칙연산 문제 풀이
public class Main1232 {
    static int N;
    static List<String> postOd;
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

    static void postOrder(int idx){
        Node n = node[idx];
        if(n.left != -1) postOrder(n.left);
        if(n.right != -1) postOrder(n.right);
        postOd.add(n.tmp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int k = 0; k < 10; k++) {
            N = Integer.parseInt(br.readLine());
            postOd = new ArrayList<>();
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

            postOrder(1);

            Stack<Integer> stack = new Stack<>();
            for(int l = 0; l < postOd.size(); l++){
                if("+-*/".contains(postOd.get(l))){
                    int tmp1 = stack.pop();
                    int tmp2 = stack.pop();
                    switch(postOd.get(l)){
                        case "+" :
                            stack.push(tmp2 + tmp1);
                            break;
                        case "-" :
                            stack.push(tmp2 - tmp1);
                            break;
                        case "*" :
                            stack.push(tmp2 * tmp1);
                            break;
                        case "/" :
                            stack.push(tmp2 / tmp1);
                            break;
                    }
                } else {
                    stack.push(Integer.parseInt(postOd.get(l)));
                }
            }
            System.out.printf("#%d %d\n", k+1, stack.peek());
        }
    }
}
