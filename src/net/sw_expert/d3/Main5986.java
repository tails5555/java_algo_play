package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// SW Expert D3 종현이와 세 소수 문제 풀이
public class Main5986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[1000];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;
        for(int k = 2; k < Math.sqrt(999); k++){
            if(isPrime[k]) {
                for (int l = k * 2; l <= 999; l += k) {
                    isPrime[l] = false;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int k = 0; k <= 999; k++){
            if(isPrime[k])
                list.add(k);
        }

        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int a = 0; a < list.size(); a++){
                if(list.get(a) > N - 2) break;
                for(int b = a; b < list.size(); b++){
                    int c = N - list.get(b) - list.get(a);
                    if(c < 0) continue;
                    if(!isPrime[c]) continue;
                    if(list.get(b) <= c && list.get(a) + list.get(b) + c == N){
                        cnt += 1;
                    }
                }
            }
            System.out.printf("#%d %d\n", k+1, cnt);
        }
    }
}