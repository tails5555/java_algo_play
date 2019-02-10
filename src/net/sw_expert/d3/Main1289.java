package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// SW Expert D3 원재의 메모리 복구하기 문제 풀이
public class Main1289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++){
            char[] arr = br.readLine().toCharArray();
            char[] tmp = new char[arr.length];
            Arrays.fill(tmp, '0');

            int cnt = 0;
            while(true) {
                for(int l = 0; l < arr.length; l++){
                    if(arr[l] != tmp[l]) {
                        Arrays.fill(tmp, l, arr.length, tmp[l] == '1' ? '0' : '1');
                        cnt += 1;
                        break;
                    }
                }
                if(Arrays.equals(arr, tmp)) break;
            }
            System.out.printf("#%d %d\n", k+1, cnt);
        }
    }
}
