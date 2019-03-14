package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 정곤이의 단조 증가하는 수 문제 풀이
public class Main6190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[] num = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int l = 0; l < N; l++){
                num[l] = Integer.parseInt(st.nextToken());
            }

            int res = Integer.MIN_VALUE;
            for(int l = 0; l < N; l++){
                for(int m = l + 1; m < N; m++){
                    int tmp = num[l] * num[m];
                    if(tmp < 10) {
                        res = Math.max(res, tmp);
                        continue;
                    }
                    String a = Integer.toString(tmp);
                    if((tmp % 10 == 0) || (a.charAt(0) - '0' > tmp % 10)) continue;
                    else {
                        char cur = a.charAt(0);
                        boolean checked = true;
                        for(int n = 0; n < a.length(); n++){
                            if(cur > a.charAt(n)) {
                                checked = false;
                                break;
                            } else {
                                cur = a.charAt(n);
                            }
                        }
                        if(checked) {
                            res = Math.max(res, tmp);
                        }
                    }
                }
            }
            if(res != Integer.MIN_VALUE)
                System.out.printf("#%d %d\n", k + 1, res);
            else
                System.out.printf("#%d %d\n", k + 1, -1);
        }
    }
}
