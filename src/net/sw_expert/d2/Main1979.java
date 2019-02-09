package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D2 어디에 단어가 들어갈 수 있을까 문제
public class Main1979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] arr = new int[N][N];

            int res = 0;
            for(int l = 0; l < N; l++){
                int idx = 0;
                st = new StringTokenizer(br.readLine(), " ");
                int cnt = 0;
                while(st.hasMoreTokens()) {
                    arr[l][idx] = Integer.parseInt(st.nextToken());
                    if(arr[l][idx] == 1)
                        cnt += 1;
                    else {
                        if(cnt == K) res += 1;
                        cnt = 0;
                    }
                    idx += 1;
                }
                if(cnt == K) res += 1;
            }

            for(int l = 0; l < N; l++){
                int cnt = 0;
                for(int m = 0; m < N; m++){
                    if(arr[m][l] == 1)
                        cnt += 1;
                    else {
                        if(cnt == K) res += 1;
                        cnt = 0;
                    }
                }
                if(cnt == K) res += 1;
            }

            System.out.printf("#%d %d\n", k+1, res);
        }
    }
}
