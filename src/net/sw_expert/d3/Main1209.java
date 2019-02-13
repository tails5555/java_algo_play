package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// SW Expert D3 SUM 문제 풀이
public class Main1209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int k = 0; k < 10; k++){
            int test = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            int sum = Integer.MIN_VALUE;

            for(int l = 0; l < 100; l++) {
                st = new StringTokenizer(br.readLine(), " ");
                int idx = 0;
                int tmpsum = 0;
                while(st.hasMoreTokens()) {
                    int tmp = Integer.parseInt(st.nextToken());
                    arr[l][idx++] = tmp;
                    tmpsum += tmp;
                }
                sum = Math.max(sum, tmpsum);
            }

            for(int l = 0; l < 100; l++){
                int tmpsum = 0;
                for(int m = 0; m < 100; m++){
                    tmpsum += arr[m][l];
                }
                sum = Math.max(sum, tmpsum);
            }

            for(int l = 0; l < 100; l++){
                int tmpsum = 0;
                for(int m = 0; m < 2; m++){
                    if(m == 0){
                        tmpsum += arr[l][l];
                    } else {
                        tmpsum += arr[l][99 - l];
                    }
                }
                sum = Math.max(sum, tmpsum);
            }

            System.out.printf("#%d %d\n", test, sum);
        }
    }
}
