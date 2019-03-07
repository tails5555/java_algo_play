package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// SW Expert D3 Write And Erase 문제 풀이
public class Main2386 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            for(int l = 0; l < N; l++){
                int tmp = Integer.parseInt(br.readLine());
                if(set.contains(tmp)){
                    set.remove(tmp);
                } else {
                    set.add(tmp);
                }
            }
            System.out.printf("#%d %d\n", k + 1, set.size());
        }
    }
}
