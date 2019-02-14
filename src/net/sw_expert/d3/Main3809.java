package net.sw_expert.d3;

import java.util.Scanner;

// SW Expert D3 화섭이의 정수 나열 문제 풀이
public class Main3809 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int k = 0; k < T; k++){
            int N = s.nextInt();
            int[] tmp = new int[N];
            boolean[] checked = new boolean[1000];
            for(int l = 0; l < N; l++){
                tmp[l] = s.nextInt();
                checked[tmp[l]] = true;
            }

            int res = 1001;
            for(int l = 0; l < 10; l++){
                if(!checked[l] && l < res) res = l;
            }

            if(res == 1001) {
                for (int l = 1; l <= 2; l++) { // N 은 1000 까지라서 10~99 는 999, 100~999 는 998, 1000~9999 는 997 번 들어가니깐 1000 부터 측정하는 건 무의미하다.
                    for (int m = 0; m < N - l; m++) {
                        String str = "";
                        for (int n = m; n <= m + l; n++)
                            str += Integer.toString(tmp[n]);
                        checked[Integer.parseInt(str)] = true;
                    }

                    int start = (int) Math.pow(10.0, l);
                    int end = (int) Math.pow(10.0, l + 1);
                    for(int m = start; m < end; m++){
                        if(!checked[m] && m < res) res = m;
                    }
                    if(res != 1001)
                        break;
                }
            }

            System.out.printf("#%d %d\n", k + 1, res);
        }
    }
}
