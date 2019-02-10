package net.sw_expert.d2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// SW Expert D2 패턴 마디의 길이 문제 풀이
public class Main2007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int k = 0; k < T; k++){
            int res = 0;
            char[] tmp = br.readLine().toCharArray();
            for(int l = 1; l <= 10; l++){
                int[][] ranges = new int[tmp.length / l][2];
                for(int m = 0; m < tmp.length / l; m++){
                    ranges[m][0] = m * l;
                    ranges[m][1] = m * l + (l - 1);
                }

                boolean hasPattern = true;
                char[] a = Arrays.copyOfRange(tmp, ranges[0][0], ranges[0][1] + 1);
                for(int[] arr : ranges){
                    char[] b = Arrays.copyOfRange(tmp, arr[0], arr[1] + 1);
                    if(!Arrays.equals(a, b)) {
                        hasPattern = false;
                        break;
                    }
                }
                if(hasPattern) {
                    res = l;
                    break;
                }
            }
            System.out.printf("#%d %d\n", k+1, res);
        }
    }
}
