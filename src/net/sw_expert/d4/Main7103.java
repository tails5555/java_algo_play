package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D4 준홍이의 4개의 제곱수 문제 풀이
// 다중 중복문에 sqrt 를 사용하여 시간 복잡도를 줄일 수 있는가를 판별하는 문제.
// 시간 복잡도는 O((logN)^3) 정도 나옴.
public class Main7103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int l = 0; l <= Math.sqrt(N); l++){
                int lRest = N - l * l;
                if(lRest > 0) {
                    for(int m = l; m <= Math.sqrt(lRest); m++){
                        int mRest = N - l * l - m * m;
                        if(mRest > 0) {
                            for(int n = m; n <= Math.sqrt(mRest); n++){
                                int nRest = N - l * l - m * m - n * n;
                                if(nRest > 0) {
                                    int o = N - l * l - m * m - n * n;
                                    int tsqr = (int) Math.sqrt(o);
                                    if (tsqr * tsqr == o && tsqr >= n) {
                                        cnt += 1;
                                    }
                                } else break;
                            }
                        } else break;
                    }
                } else break;
            }

            System.out.printf("#%d %d\n", k + 1, cnt);
        }
    }
}
