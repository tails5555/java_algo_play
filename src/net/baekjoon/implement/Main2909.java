package net.baekjoon.implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Baekjoon 2909 캔디 구매 문제 풀이
// Math.round() 함수를 사용하면 꿀인데, 응용력을 키우기 위해 그냥 풀어보도록 하자.
public class Main2909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int price = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(K > 0) {
            int bill = 10;
            int pivot = 5;
            for (int k = 2; k <= K; k++){
                bill *= 10;
                pivot *= 10;
            }

            int cnt = price / bill;
            int mod = price % bill;
            if(mod >= pivot){
                System.out.println((cnt + 1) * bill);
            } else {
                System.out.println(cnt * bill);
            }
        } else {
            System.out.println(price);
        }
    }
}
