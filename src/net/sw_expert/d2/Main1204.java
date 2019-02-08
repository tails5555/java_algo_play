package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// SW Expert D2 최빈수 구하기 문제 풀이
public class Main1204 {
    public static int getHigher(Map<Integer, Integer> map) {
        List<Integer> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list, (o1, o2) -> {
            int v1 = map.get(o1);
            int v2 = map.get(o2);
            if(v1 == v2) return o2 - o1;
            else return v2 - v1;
        });
        return list.get(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k=0;k<T;k++){
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Map<Integer, Integer> count = new HashMap<>();
            while(st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());
                int tmp = count.getOrDefault(num, 0);
                count.put(num, tmp + 1);
            }
            System.out.printf("#%d %d\n", K, getHigher(count));
        }
    }
}
