package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// SW Expert D3 진기의 최고오급 붕어빵 문제 풀이
public class Main1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int k = 0; k < T; k++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            Map<Integer, Integer> map = new HashMap<>();
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            int max = 0;
            while(idx < N) {
                int tmp = Integer.parseInt(st.nextToken());
                max = Math.max(max, tmp);
                int value = map.getOrDefault(tmp, 0);
                map.put(tmp, value + 1);
                idx += 1;
            }

            int remain = 0;
            int time = 0;
            boolean confirm = true;
            while(time < max){
                time += 1;
                if(time % M == 0)
                    remain += K;

                int come = map.getOrDefault(time, 0);
                if(come > 0) {
                    if(remain < come) {
                        confirm = false;
                        break;
                    } else {
                        remain -= come;
                        map.remove(time);
                    }
                }
            }

            System.out.printf("#%d %s\n", k+1, confirm && map.keySet().size() == 0 ? "Possible" : "Impossible");
        }
    }
}
