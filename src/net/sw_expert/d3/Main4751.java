package net.sw_expert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// SW Expert D3 다슬이의 다이아몬드 장식 문제 풀이
public class Main4751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int k = 0; k < N; k++){
            char[] tmp = br.readLine().toCharArray();
            StringBuilder[] sbs = new StringBuilder[5];
            for(int l = 0; l < sbs.length; l++){
                sbs[l] = new StringBuilder();
                if(l == 0 || l == 4){
                    for(int m = 0; m < tmp.length; m++){
                        sbs[l].append("..#.");
                    }
                    sbs[l].append(".");
                } else if(l == 1 || l == 3) {
                    for(int m = 0; m < tmp.length; m++){
                        sbs[l].append(".#.#");
                    }
                    sbs[l].append(".");
                } else {
                    for (int m = 0; m < tmp.length; m++) {
                        sbs[l].append(String.format("#.%c.", tmp[m]));
                    }
                    sbs[l].append("#");
                }
            }

            for(int l = 0; l < sbs.length; l++){
                System.out.println(sbs[l].toString());
            }
        }
    }
}
