package net.sw_expert.d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 삼성 SW Expert D1 1 대 1 가위 바위 보 문제
public class Main1936 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        A = A % 3;
        B = B % 3;

        if((B + 1) % 3 == A) {
            System.out.println("A");
        } else if((A + 1) % 3 == B) {
            System.out.println("B");
        } else {
            System.out.println("DRAW");
        }
    }
}
