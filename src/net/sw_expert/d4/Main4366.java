package net.sw_expert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// SW Expert D4 정식이의 은행 업무 문제 풀이
public class Main4366 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] twice = new long[39];
        long[] three = new long[39];
        twice[0] = three[0] = 1L;
        for(int k = 1; k < twice.length; k++){
            twice[k] = twice[k - 1] * 2;
            three[k] = three[k - 1] * 3;
        }

        int T = Integer.parseInt(br.readLine());

        for(int k = 0; k < T; k++){
            String binary = br.readLine();
            String trine = br.readLine();

            long twiceMain = 0;
            for(int l = 0; l < binary.length(); l++){
                if(binary.charAt(l) == '1'){
                    twiceMain += twice[binary.length() - l - 1];
                }
            }

            Set<Long> twiceSet = new HashSet<>();
            twiceSet.add(twiceMain);
            for(int l = 0; l < binary.length(); l++){
                long tmp = twiceMain;
                if(binary.charAt(l) == '1'){
                    tmp -= twice[binary.length() - l - 1];
                } else {
                    tmp += twice[binary.length() - l - 1];
                }
                twiceSet.add(tmp);
            }

            long threeMain = 0;
            for(int l = 0; l < trine.length(); l++){
                if(trine.charAt(l) > '0'){
                    threeMain += (three[trine.length() - l - 1] * (trine.charAt(l) - '0'));
                }
            }

            Set<Long> threeSet = new HashSet<>();
            threeSet.add(threeMain);
            for(int l = 0; l < trine.length(); l++) {
                long tmp1 = threeMain;
                long tmp2 = threeMain;
                if (trine.charAt(l) == '0') {
                    tmp1 += three[trine.length() - l - 1];
                    tmp2 += three[trine.length() - l - 1] * 2;
                } else if (trine.charAt(l) == '1') {
                    tmp1 -= three[trine.length() - l - 1];
                    tmp2 += three[trine.length() - l - 1];
                } else {
                    tmp1 -= three[trine.length() - l - 1];
                    tmp2 -= three[trine.length() - l - 1] * 2;
                }

                threeSet.add(tmp1);
                threeSet.add(tmp2);
            }

            twiceSet.retainAll(threeSet);
            System.out.printf("#%d %d\n", k+1, Collections.min(twiceSet));
        }
    }
}
