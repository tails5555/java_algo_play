package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 영준Yee와 신비한 뿔의 숲 문제 풀이
public class Main3142 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int uni = 0;
            while(true){
                if(uni + (M - uni) * 2 == N) break;
                uni += 1;
            }

            System.out.printf("#%d %d %d\n", k+1, uni, M - uni);
        }
    }
}
