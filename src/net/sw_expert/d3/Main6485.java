package net.sw_expert.d3;

import java.util.Scanner;

// SW Expert 6485. 삼성시의 버스노선
public class Main6485 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[][] buses = new int[N][2];
            for(int k=0;k<N;k++){
                buses[k][0] = sc.nextInt();
                buses[k][1] = sc.nextInt();
            }

            int P = sc.nextInt();
            int[] stations = new int[P];
            int[] cnts = new int[P];
            for(int k=0;k<P;k++){
                stations[k] = sc.nextInt();
                for(int l=0;l<N;l++){
                    if(stations[k] >= buses[l][0] && stations[k] <= buses[l][1]){
                        cnts[k]++;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(String.format("#%d ", test_case));
            for(int k=0;k<P;k++){
                sb.append(String.format("%d ", cnts[k]));
            }
            System.out.println(sb.toString());
        }
    }
}
