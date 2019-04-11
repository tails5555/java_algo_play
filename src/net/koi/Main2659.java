package net.koi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Baekjoon 2659 번 십자카드 문제 풀이
// 시간 복잡도는 O(N). 안의 a, b, c, d 는 이미 정해졌기 때문에 시간 복잡도에 해당되진 않는다.
public class Main2659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 1;
        for(int a = 1; a <= 9; a++){
            for(int b = 1; b <= 9; b++){
                for(int c = 1; c <= 9; c++){
                    for(int d = 1; d <= 9; d++){
                        int t1 = a * 1000 + b * 100 + c * 10 + d * 1;
                        int t2 = b * 1000 + c * 100 + d * 10 + a;
                        int t3 = c * 1000 + d * 100 + a * 10 + b;
                        int t4 = d * 1000 + a * 100 + b * 10 + c;

                        int min = Math.min(t1, Math.min(t2, Math.min(t3, t4)));
                        if(!map.containsKey(min)) {
                            map.put(min, cnt);
                            cnt += 1;
                        }
                    }
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[4];
        for(int k = 0; k < 4; k++){
            arr[k] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for(int k = 0; k < 4; k++){
            int f1 = arr[k];
            int f2 = arr[(k + 1) % 4];
            int f3 = arr[(k + 2) % 4];
            int f4 = arr[(k + 3) % 4];
            int t = f1 * 1000 + f2 * 100 + f3 * 10 + f4 * 1;
            min = Math.min(min, t);
        }

        System.out.println(map.get(min));
    }
}
