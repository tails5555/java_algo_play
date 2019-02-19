package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D4 사칙연산 유효성 검사 문제 풀이
// 그냥 반씩 나누어 루트노드부터 중간까지 연산자면 TRUE, 그 다음 노드부터 맨 마지막 자식노드까지 숫자면 TRUE.
// 이렇게 입력이 많아야 하나요 굳이?
public class Main1233 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int k = 0; k < 10; k++){
            int N = Integer.parseInt(br.readLine());
            Node[] node = new Node[N + 1];
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

            boolean validate = true;
            int mid = N / 2;
            for(int l = 1; l <= mid; l++){
                if("0123456789".contains(node[l].tmp)){
                    validate = false;
                    break;
                }
            }
            if(validate) {
                for (int l = mid + 1; l <= N; l++) {
                    if("+-*/".contains(node[l].tmp)) {
                        validate = false;
                        break;
                    }
                }
            }

            System.out.printf("#%d %d\n", k+1, validate ? 1 : 0);
        }
    }
}
