package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D2 달팽이 숫자 문제 풀이
// 2차원 배열로 회전, 달팽이 등을 그리는 문제도 가아끄음 코딩 테스트에 나오니깐 알아는 둬야 될 듯함.
public class Main1954 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int k=0;k<T;k++){
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N + 1][N + 1];
            int K = 0;
            int A = N;
            int SW = 1;
            int I = 1, J = 0;
            do{
                for(int P = 1; P <= A; P++){
                    K = K + 1;
                    J = J + SW;
                    arr[I][J] = K;
                }
                A = A - 1;

                if(A > 0){
                    for(int P = 1; P <= A; P++){
                        K = K + 1;
                        I = I + SW;
                        arr[I][J] = K;
                    }
                    SW = SW*(-1);
                } else {
                    break;
                }
            } while(true);

            sb.append(String.format("#%d\n", k+1));
            for(int a = 1; a < arr.length; a++){
                for(int b = 1; b < arr[0].length; b++) {
                    sb.append(String.format("%d ", arr[a][b]));
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
